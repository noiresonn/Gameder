
package com.gameder.app.handlers.profiles;

import com.gameder.app.preferences.Preferences;

import java.util.Random;

public class ProfileGenerator {

    public static String getRandomName() {
        String[] usernames = {"ferventnumber", "orcuslistener", "ableflag", "smellypapoose", "druggedoriginates",
                "croxdalemagma", "unsavouryallianz", "anxietywick", "bittenmoustache", "carillonbaseball", "polentabinding",
                "yogi-beartippy", "illogicaldancers", "minidiscnegligible", "drymitt", "absorbedknabstrup", "gazebosalisbury",
                "bolideoliver", "pebblesrigil", "finnaureole", "kokoscavaig", "riverbroth", "izzyamber", "pradacentury",
                "torontobivy", "dispenserstunning", "exclaimrobust", "walnutemmy", "discountsknock", "radialhobby",
                "accessibledagger", "dometasha", "unablearcherfish", "disguisedtruro", "smuthlisten", "glaisdalecringle",
                "retweetrude", "forgetfulenjoy", "limpqrcode", "mischiefcancer", "changeablejohannesburg",
                "mollyrhubarb", "motionlessmercy", "innocentchanges", "absorbsconcurrent", "permitglaucous", "kenziavocet",
                "ourmaxwell", "nijinskyastley", "scoonercrocodiles", "cautionvertical", "starsnavel", "fiftyformulas", "dollsgift",
                "treigmeasly", "terrineremnant", "ritecolaf", "vegetariansteamy", "rotatingdash", "slidersrocked",
                "yellerbonnie", "clinkhenmore", "warnscrew", "kyanitesize", "rhomiserly", "warblerwastebasket", "overviewamuck",
                "soundinhave", "rowlockmews", "dianafaculties", "zirconsmart", "rosyoisín", "winghamwhip", "pridejealous",
                "athletictaxi", "zealouscrap", "areastrounce", "tellingservo", "gillietiny", "shandygrimley", "spendbismarck",
                "copalmolly", "shoemakerminstral", "crackerpitter", "jokerfarrier", "shellscreeching", "vacuolespurebred",
                "footblueshift", "worthoilyritecolaf", "karachicompany"};

        Random rand = new Random();
        int index = rand.nextInt(usernames.length);
        return usernames[index];
    }
    public static String getRandomMail() {
        String[] emails = {"killmenow@att.net", "citadel@yahoo.com","sassen@sbcglobal.net","nachbaur@hotmail.com",
                "tellis@outlook.com","mwandel@me.com","bjornk@yahoo.com","wayward@verizon.net","mfleming@mac.com",
                "wildfire@me.com","leakin@live.com","ajohnson@aol.com","aukjan@me.com","delpino@me.com","danny@optonline.net",
                "agapow@optonline.net","fglock@comcast.net","ranasta@sbcglobal.net","mfburgo@att.net","dburrows@att.net",
                "budinger@sbcglobal.net","mthurn@hotmail.com","johndo@me.com","loscar@outlook.com","kodeman@aol.com","parksh@icloud.com",
                "tbmaddux@sbcglobal.net", "marioph@hotmail.com","jnolan@att.net","jemarch@me.com","smallpaul@optonline.net",
                "jginspace@yahoo.ca","oevans@sbcglobal.net","bebing@yahoo.com","jamuir@aol.com","treeves@optonline.net","duncand@gmail.com",
                "kalpol@optonline.net","vsprintf@icloud.com","moonlapse@comcast.net","hauma@yahoo.ca","mbalazin@hotmail.com","mdielmann@gmail.com",
                "skoch@sbcglobal.net","fallorn@hotmail.com","njpayne@comcast.net","sassen@sbcglobal.net","bdthomas@live.com","matthijs@yahoo.com",
                "grady@me.com"};
        Random rand = new Random();
        int index = rand.nextInt(emails.length);
        return emails[index];
    }


    public static String getRandomImg() {
        String url = "https://robohash.org/";
        Random rand = new Random();
        int set = rand.nextInt(10000);
        url += set;
        return url;
    }
    public static Boolean getRandomBoolean() {
        Random rand = new Random();
        boolean headsOrTails = rand.nextBoolean();
        return headsOrTails;
    }

    public static Profile getRandomProfile() {
        return new Profile(getRandomName(), getRandomImg(),getRandomMail(), Preferences.getRandomPreferences(),getRandomBoolean());
    }
}
