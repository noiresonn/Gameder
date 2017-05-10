package com.gameder.app.handlers.profiles;

import com.gameder.app.preferences.Preferences;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

@RestController
public class ProfilesHandler {

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
        generateProfiles();
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

        //(profileTreeSet = ;
    }

    /**
     * For database
     * @param ts
     */
    public void saveProfileTree(TreeSet<Profile> ts) {

    }

    /**
     *  Generates 50 profiles and adds them to the tree
     */
    public void generateProfiles() {
        for(int i = 0; i < 50; i++) {
            Profile p = ProfileGenerator.getRandomProfile();
            profileTreeSet.add(p);
        }
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

                /**
                 *  If both ends have been reached, the roots will be reset
                 */
                if(maxRoot == null && minRoot == null) {
                    minnull = false;
                    maxnull = false;
                    maxRoot = profileTreeSet.higher(rootPreference);
                    minRoot = profileTreeSet.lower(rootPreference);
                }
            }
            return profiles;
        } else {
            return null;
        }
    }

    public TreeSet<Profile> getProfilesTreeset() {
        return this.profileTreeSet;
    }
}
