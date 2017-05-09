package com.gameder.app.handlers.profiles;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class ProfileSetTest {
    @Test
    public void ProfileSetIsFilled() {
        ProfilesHandler p = new ProfilesHandler();

        p.generateProfiles();

        TreeSet<Profile> ts = p.getProfilesTreeset();
        Iterator ite = ts.iterator();

        while(ite.hasNext()) {
            Object pro = ite.next();
            System.out.println(pro.toString());
        }

        Assert.assertFalse(ts.isEmpty());
    }

    @Test
    public void ProfileSetIsInOrder() {
        ProfilesHandler p = new ProfilesHandler();

        p.generateProfiles();

        TreeSet<Profile> ts = p.getProfilesTreeset();

        Assert.assertTrue(ts.first().getPreference() < ts.last().getPreference());
    }

    @Test
    public void ProfileListIsCorrectSize() {
        ProfilesHandler p = new ProfilesHandler();
        ArrayList<Profile> cp = p.getGamerList();
        for(Profile pr : cp) {
            System.out.println("ProfileList : " + pr.toString());
        }
        Assert.assertTrue(cp.size() == 5);
    }

    @Test
    public void ProfileListIsValid() {
        ProfilesHandler p = new ProfilesHandler();
        ArrayList<Profile> a = p.getGamerList();
        ArrayList<Profile> b = p.getGamerList();

        for(Profile x : a) {
            System.out.println("a : " + x.toString());
        }

        for(Profile x : b) {
            System.out.println("b : " + x.toString());
        }

        Assert.assertNotEquals(a, b);
    }

    @Test
    public void RootIsFound() {
        ProfilesHandler p = new ProfilesHandler();

        Assert.assertNotNull(p.findRoot());
    }

    @Test
    public void ProfileListBordersWorking() {
        ProfilesHandler p = new ProfilesHandler();

        for(int i = 0; i < 20; i++) {
            p.getGamerList();
        }
        ArrayList<Profile> arp = p.getGamerList();
        Assert.assertNotNull(arp);
    }
}
