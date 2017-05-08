package com.gameder.app.handlers.profiles;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

@RestController
public class ProfilesHandler {

    private TreeSet<Profile> profileTreeSet = new TreeSet<>();
    private Profile running;
    private Iterator<Profile> iterator = profileTreeSet.iterator();
    private boolean asd = true;

    @CrossOrigin
    @RequestMapping(value = "/api/profiles1", method = RequestMethod.GET)
    public ArrayList<Profile> getGamerList() {
        if(asd) {
            generateProfiles();
        }

        ArrayList<Profile> profiles = getFiveProfiles();
        //profiles.add(new Profile("A Little Pony", "http://cartoonbros.com/wp-content/uploads/2016/04/My-Little-Pony-9.png"));
        //profiles.add(new Profile("Another Little Pony", "http://cartoonbros.com/wp-content/uploads/2016/04/My-Little-Pony-10.png"));
        //profiles.add(new Profile("Yet Another Little Pony", "http://cartoonbros.com/wp-content/uploads/2016/04/My-Little-Pony-11.png"));

        return profiles;
    }
    @CrossOrigin
    @RequestMapping(value = "/api/profiles", method = RequestMethod.GET)
    public ArrayList<Profile> getGamerListTest() {

        ArrayList<Profile> profiles = new ArrayList<Profile>();
        profiles.add(ProfileGenerator.getRandomProfile());
        profiles.add(ProfileGenerator.getRandomProfile());
        profiles.add(ProfileGenerator.getRandomProfile());
        profiles.add(ProfileGenerator.getRandomProfile());
        profiles.add(ProfileGenerator.getRandomProfile());
        profiles.add(ProfileGenerator.getRandomProfile());

        return profiles;
    }


    public void generateProfiles() {
        for(int i = 0; i < 50; i++) {
            Profile p = ProfileGenerator.getRandomProfile();
            profileTreeSet.add(p);
        }
    }

    public ArrayList<Profile> getFiveProfiles() {
        if(!profileTreeSet.isEmpty()) {
            if(running == null) {
                running = profileTreeSet.first();
            }

            ArrayList<Profile> profiles = new ArrayList<>();
            int i = 0;
            while(iterator.hasNext() && i < 5) {
                profiles.add(profileTreeSet.higher(running));
                running = profileTreeSet.higher(running);
                i++;
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
