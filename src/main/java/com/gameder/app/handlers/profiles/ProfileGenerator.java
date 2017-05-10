
package com.gameder.app.handlers.profiles;

import com.gameder.app.preferences.Preferences;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Vili
 */
public class ProfileGenerator {

    /**
     *  Profile generator which gives a random name, email, matching status, description and generated picture for it.
     */
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

    /**
     * Awesome description generator with multiple different sentences and values.
     *
     * @return description
     */
    public static String getRandomDescription() {
        Random rand = new Random();
        int x = rand.nextInt(3);
        x += 3;
        String desc = "";
        ArrayList<Integer> sentences  = new ArrayList<>();
        String[] names = {
                "Clement", "Dylan", "Alexis", "Robert", "Zane", "Miguel", "Maximo", "Jeffery", "Derrick", "Vance", "Mervin",
                "Erwin", "Columbus", "Jason", "Cole", "Keven", "Michel", "Rubin", "Ian", "Dino", "Alishia", "Kyoko",
                "Mackenzie", "Seema", "Nannette", "Juliette", "Sade", "Latanya", "Bettyann", "Ignacia", "Deadra", "Gladys",
                "Brinda", "Erma", "Myrta", "Monserrate", "Nicolle", "Deloise", "Larissa", "Eneida",
        };
        String[] games = {
                "Dota", "Hearthstone", "GTA V", "CS:GO", "League of Legends", "Rust", "Garry's Mod", "World of Tanks",
                "CS:S", "CS 1.6", "Rocket League", "Football Manager", "World of Warcraft", "Minecraft", "Overwatch",
        };

        String[] ranks = {
                "Silver I", "Silver II", "Silver III", "Silver IV", "Silver Elite", "Silver Elite Master", "Gold Nova 1",
                "Gold Nova II", "Gold Nova III", "Gold Nova Master", "Master Guardian I", "Master Guardian II",
                "Master Guardian Elite", "Legendary Eagle", "Legendary Eagle Master", "Supreme Master First Class",
                "The Global Elite",
        };

        String[] countries = {
                "Finland", "Russia", "UK", "US", "North Korea", "Japan", "China", "Germany", "Sweden", "Norway", "Mongolia",
                "Brazil", "Mexico", "Estonia", "Israel", "Egypt", "South Africa", "Venezuela", "Philippines",
        };

        String[] foods = {
                "burgers", "pizza", "macaroni and ketchup", "spaghetti", "beer", "reindeer meat", "gulyash",
                "mämmi", "peanut butter", "peasoup", "noodles",
        };

        String[] hobbies = {
                "football", "icehockey", "drinking hard liquors", "running", "baseball", "basketball", "gaming", "reading",
                "coding", "hiking", "fishing",
        };

        for(int i = 0; i < x; i++) {
            while(true) {
                int xx = rand.nextInt(6);
                if(!sentences.contains(xx)) {
                    sentences.add(xx);
                    break;
                }
            }
        }

        for (Integer sentence : sentences) {
            int i = sentence;
            if (i == 0) {
                desc += "My name is " + names[rand.nextInt(names.length)] + ". ";
            } else if (i == 1) {
                int age = rand.nextInt(28) + 12;
                desc += "I'm " + age + " years old. ";
            } else if (i == 2) {
                desc += "I like to play ";
                String game = games[rand.nextInt(games.length)];
                desc += game + ". ";
                if (game.equals("CS:GO")) {
                    desc += "My rank is " + ranks[rand.nextInt(ranks.length)] + ". ";
                }
            } else if (i == 3) {
                desc += "I live in " + countries[rand.nextInt(countries.length)] + ". ";
            } else if (i == 4) {
                desc += "My favourite food is " + foods[rand.nextInt(foods.length)] + ". ";
            } else if (i == 5) {
                desc += "My hobby is " + hobbies[rand.nextInt(hobbies.length)] + ". ";
            }

        }

        return desc;
    }

    public static Profile getRandomProfile() {
        return new Profile(getRandomName(), getRandomImg(),getRandomMail(), Preferences.getRandomPreferences(),getRandomBoolean(), getRandomDescription());
    }
}
