package com.gameder.app.handlers.profiles;

import com.gameder.app.preferences.Preferences;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

@RestController
public class ProfilesHandler {
    private static final String dbEndpoint = System.getenv("DB_ENDPOINT");

    private TreeSet<Profile> profileTreeSet = new TreeSet<>();

    private Profile rootPreference;
    private Profile maxRoot;
    private Profile minRoot;

    private boolean maxnull = false;
    private boolean minnull = false;

    /**
     * Endpoint
     * Generates the tree if it's empty
     * Finds the root if if it's empty
     *
     * @return five profiles in an array for the frontend
     */
    @CrossOrigin
    @RequestMapping(value = "/api/profiles", method = RequestMethod.GET)
    public ArrayList<Profile> getGamerList() {
        if(profileTreeSet.isEmpty()) {
            generateProfiles();
        }

        if(rootPreference == null) {
            rootPreference = findRoot();
        }
        ArrayList<Profile> profiles = getFiveProfiles();
        return profiles;
    }

    /**
     * Tester
     * @return three random profiles
     */
    @CrossOrigin
    @RequestMapping(value = "/api/profiles1", method = RequestMethod.GET)
    public ArrayList<Profile> getGamerListTest() {

        ArrayList<Profile> profiles = new ArrayList<Profile>();
        profiles.add(ProfileGenerator.getRandomProfile());
        profiles.add(ProfileGenerator.getRandomProfile());
        profiles.add(ProfileGenerator.getRandomProfile());

        return profiles;
    }

    /**
     * Finds the root profile for searching the tree
     * ATM the root is random number but it can be easily changed to a specific preference number.
     * If the number is not found, the algorithm will choose the closest(higher) number.
     *
     *  Made by Vili
     * */
    public Profile findRoot() {
        int root = Preferences.getRandomPreferences();
        Iterator<Profile> iterator = profileTreeSet.iterator();

        while(true) {
            while(iterator.hasNext()) {
                Profile p = iterator.next();
                if(p.getPreference() == root) {
                    /**
                     * Max and min roots used to find closest profiles.
                     */
                    maxRoot = profileTreeSet.higher(p);
                    minRoot = profileTreeSet.lower(p);
                    return p;
                }
            }
            iterator = profileTreeSet.iterator();
            root++;
            /**
             * If the root number is not found, reset it to zero.
             * The limit is arbitrary, but with a fully working database the limit should be databases size.
             */
            if(root > 100) {
                root = 0;
            }
        }
    }

    /**
     * For database
     */
    public void loadProfileTree() {
        try {
            URL url = new URL(dbEndpoint);
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection) con;
            http.setRequestMethod("GET");
            http.setRequestProperty("Content-Type", "text/plain;charset=UTF-8");

            System.out.println(http.getResponseCode());

            BufferedInputStream bis = new BufferedInputStream(http.getInputStream());
            ObjectInputStream ois = new ObjectInputStream(bis);

            profileTreeSet = (TreeSet) ois.readObject();
            System.out.printf("Size of the tree is %d\n", profileTreeSet.size());

            System.out.println("load");
        } catch (Exception e) {
            System.out.println("Could not make the request");
        }
    }

    /**
     * For database
     */
    public void saveProfileTree(TreeSet<Profile> profiles) {
        try {
            URL url = new URL(dbEndpoint);
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection) con;
            http.setRequestMethod("POST");
            http.setRequestProperty("Content-Type", "text/plain;charset=UTF-8");
            http.setDoOutput(true);

            BufferedOutputStream bos = new BufferedOutputStream(http.getOutputStream());
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            oos.writeObject(profiles);
            oos.close();

            System.out.printf("save: %d\n", http.getResponseCode());
        } catch (Exception e) {
            System.out.println("Could not make the request");
        }
    }

    /**
     *  Generates 50 profiles and adds them to the tree
     */
    public void generateProfiles() {
        TreeSet<Profile> profiles = new TreeSet<Profile>();

        for(int i = 0; i < 50; i++) {
            Profile p = ProfileGenerator.getRandomProfile();
            profiles.add(p);
        }

        this.saveProfileTree(profiles);
        this.loadProfileTree();
    }

    /**
     *  Gives five closest(most preferred) profiles from the tree.
     *
     *  Made by Vili
     *  @return five profiles in an arraylist
     */
    public ArrayList<Profile> getFiveProfiles() {
        if(!profileTreeSet.isEmpty()) {

            ArrayList<Profile> profiles = new ArrayList<>();

            for(int i = 0; i < 5; i ++) {
                /** If the min and max -ends are not reached search both
                 * Compares preference numbers, chooses the closest
                 * If either end is reached, it will skip that side
                 * The algorithm can be easily limited if the profile pool is huge
                 * */

                /**
                 *  If both ends have been reached, the roots will be reset
                 */
                if(maxRoot == null && minRoot == null) {
                    minnull = false;
                    maxnull = false;
                    maxRoot = profileTreeSet.higher(rootPreference);
                    minRoot = profileTreeSet.lower(rootPreference);
                }

                if(!minnull && !maxnull) {
                    /**
                     * Minroot is closer
                     * /
                     * Maxroot is closer
                     * /
                     * Roots are equally close, adds maxroot
                     */
                    if((maxRoot.getPreference() - rootPreference.getPreference()) > (rootPreference.getPreference() - minRoot.getPreference())) {
                        profiles.add(minRoot);
                        minRoot = profileTreeSet.lower(minRoot);
                        if(minRoot == null) {
                            minnull = true;
                        }
                    } else if((maxRoot.getPreference() - rootPreference.getPreference()) < (rootPreference.getPreference() - minRoot.getPreference())) {
                        profiles.add(maxRoot);
                        maxRoot = profileTreeSet.higher(maxRoot);
                        if(maxRoot == null) {
                            maxnull = true;
                        }
                    } else {
                        profiles.add(maxRoot);
                        maxRoot = profileTreeSet.higher(maxRoot);
                        if(maxRoot == null) {
                            maxnull = true;
                        }
                    }
                } else if(minnull) {
                    profiles.add(maxRoot);
                    maxRoot = profileTreeSet.higher(maxRoot);
                } else if(maxnull) {
                    profiles.add(minRoot);
                    minRoot = profileTreeSet.lower(minRoot);
                }

            }
            return profiles;
        } else {
            System.out.println("Reached else");
            return null;
        }
    }

    public Profile getRoot() {
        return this.rootPreference;
    }

    public TreeSet<Profile> getProfilesTreeset() {
        return this.profileTreeSet;
    }
}
