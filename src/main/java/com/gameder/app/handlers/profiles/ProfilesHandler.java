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
        //profiles.add(new Profile("A Little Pony", "http://cartoonbros.com/wp-content/uploads/2016/04/My-Little-Pony-9.png"));
        //profiles.add(new Profile("Another Little Pony", "http://cartoonbros.com/wp-content/uploads/2016/04/My-Little-Pony-10.png"));
        //profiles.add(new Profile("Yet Another Little Pony", "http://cartoonbros.com/wp-content/uploads/2016/04/My-Little-Pony-11.png"));

        return profiles;
    }
    @CrossOrigin
    @RequestMapping(value = "/api/profiles1", method = RequestMethod.GET)
    public ArrayList<Profile> getGamerListTest() {

        ArrayList<Profile> profiles = new ArrayList<Profile>();
        profiles.add(ProfileGenerator.getRandomProfile());
        profiles.add(ProfileGenerator.getRandomProfile());
        profiles.add(ProfileGenerator.getRandomProfile());

        return profiles;
    }

    public Profile findRoot() {
        int root = Preferences.getRandomPreferences();
        generateProfiles();
        Iterator<Profile> iterator = profileTreeSet.iterator();

        while(true) {
            while(iterator.hasNext()) {
                Profile p = iterator.next();
                if(p.getPreference() == root) {
                    maxRoot = profileTreeSet.higher(p);
                    minRoot = profileTreeSet.lower(p);
                    System.out.println("Root number: " + root + " ; Root profile: " + p.toString());
                    return p;
                }
            }
            iterator = profileTreeSet.iterator();
            root++;
            if(root > 100) {
                root = 0;
            }
        }
    }

    public void generateProfiles() {
        for(int i = 0; i < 50; i++) {
            Profile p = ProfileGenerator.getRandomProfile();
            profileTreeSet.add(p);
        }
    }

    public ArrayList<Profile> getFiveProfiles() {
        if(!profileTreeSet.isEmpty()) {

            ArrayList<Profile> profiles = new ArrayList<>();

            for(int i = 0; i < 5; i ++) {
                if(!minnull && !maxnull) {
                    if((maxRoot.getPreference() - rootPreference.getPreference()) > (rootPreference.getPreference() - minRoot.getPreference())) {
                        profiles.add(minRoot);
                        minRoot = profileTreeSet.lower(minRoot);
                        if(minRoot == null) {
                            System.out.println("           Min limit reached");
                            minnull = true;
                        }
                    } else if((maxRoot.getPreference() - rootPreference.getPreference()) < (rootPreference.getPreference() - minRoot.getPreference())) {
                        profiles.add(maxRoot);
                        maxRoot = profileTreeSet.higher(maxRoot);
                        if(maxRoot == null) {
                            System.out.println("           Max limit reached");
                            maxnull = true;
                        }
                    } else {
                        profiles.add(maxRoot);
                        maxRoot = profileTreeSet.higher(maxRoot);
                        if(maxRoot == null) {
                            System.out.println("          Max limit reached");
                            maxnull = true;
                        }
                    }
                } else if(minnull) {
                    profiles.add(maxRoot);
                    maxRoot = profileTreeSet.higher(maxRoot);
                    System.out.println("GIMME MAX");
                } else if(maxnull) {
                    profiles.add(minRoot);
                    minRoot = profileTreeSet.lower(minRoot);
                    System.out.println("GIMME MIN");
                }
                System.out.println("END");
                if(maxRoot == null && minRoot == null) {
                    System.out.println("           Reset");
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
