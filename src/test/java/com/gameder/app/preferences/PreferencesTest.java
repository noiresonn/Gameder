package com.gameder.app.preferences;

/**
 * Created by Vade on 8.5.2017.
 */

import org.junit.Assert;
import org.junit.Test;


public class PreferencesTest {
    @Test
    public void getRandomPreferences() throws Exception {
        java.lang.Integer test;
        test = Preferences.getRandomPreferences();
        Assert.assertTrue(0 <= test && test<=100);
        System.out.println(test);
    }


}
