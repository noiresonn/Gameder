package com.gameder.app.handlers.profiles;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.TreeSet;

public class ProfileRegisterTest {

    @Test
    public void RegisterIsValid() throws IOException {
        ProfileRegister pr = new ProfileRegister();

        TreeSet<Profile> ts = new TreeSet<>();
        ts.add(ProfileGenerator.getRandomProfile());
        ts.add(ProfileGenerator.getRandomProfile());

        pr.saveProfileRegister(ts);

        Assert.assertEquals(pr.getProfileRegister(), ts);
    }

}
