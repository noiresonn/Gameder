package com.gameder.app.handlers.profiles;

import org.junit.Assert;
import org.junit.Test;

public class ProfileGeneratorTest {
    @Test
    public void ProfileNameShouldBeValid() {
        Profile test = ProfileGenerator.getRandomProfile();
        Assert.assertTrue("Works",test.getName().length() > 0);
    }

    @Test
    public void ProfileImgShouldBeValid() {
        Profile test = ProfileGenerator.getRandomProfile();
        Assert.assertTrue("Works",test.getImg().length() > 0);
    }

}
