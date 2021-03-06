package com.gameder.app.handlers.profiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeSet;

/**
 * Simple backup register
 *
 * Created by Vili
 */
public class ProfileRegister {

    private TreeSet<Profile> profileTreeSet;

    /**
     * Getting the profile treeset from a textfile.
     * @return treeset with profiles
     * @throws IOException
     */
    public TreeSet<Profile> getProfileRegister() throws IOException {
        try {
            FileInputStream fi = new FileInputStream(new File("profiles.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            profileTreeSet = (TreeSet) oi.readObject();
            fi.close();
            oi.close();
            System.out.println("File loaded");
            return profileTreeSet;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            return null;
        }
    }

    /**
     * Profile treeset updating/creating
     * @param ts
     * @throws IOException
     */
    public void saveProfileRegister(TreeSet<Profile> ts) throws IOException {
        try {
            FileOutputStream f = new FileOutputStream(new File("profiles.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(ts);
            o.close();
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
