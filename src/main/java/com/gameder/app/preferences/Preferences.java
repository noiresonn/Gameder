package com.gameder.app.preferences;

import java.util.Random;

/**
 * Created by Vade on 8.5.2017.
 */


public class Preferences {

    private static Random r = new Random();
    private static int result;

    public static int getRandomPreferences () {
        result =  r.nextInt(100-0);
        return result;
    }
}
