package com.gameder.app.handlers.profiles;

import org.junit.*;

public class ProfileTest {
    @Test
    public void ProfileNameShouldBeValid() {
        Assert.assertEquals(new Profile("A Little Pony", "imgUrl", "",0,true, "").getName(), "A Little Pony");
    }

}
