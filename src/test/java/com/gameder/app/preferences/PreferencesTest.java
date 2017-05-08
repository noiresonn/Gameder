package com.gameder.app.preferences;

/**
 * Created by Vade on 8.5.2017.
 */

import org.junit.Assert;
import org.junit.Test;


public class PreferencesTest {
    @Test
    public Integer getRandomPreferences() throws Exception {
        Integer test = getRandomPreferences();
        Assert.assertTrue(0 <= test && test<=100);
        return test;
    }


}
