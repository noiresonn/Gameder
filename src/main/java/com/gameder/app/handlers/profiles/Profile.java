package com.gameder.app.handlers.profiles;

public class Profile implements Comparable<Profile>{
    private final String name;
    private final String img;
    private int preference;
    private boolean like;

    public Profile(String name, String img, int preference, boolean like) {
        this.name = name;
        this.img = img;
        this.preference = preference;
        this.like = like;
    }

    public String getName() {
        return this.name;
    }

    public String getImg() {
        return this.img;
    }

    public int getPreference() {
        return this.preference;
    }

    public boolean getLike() { return this.like;}

    @Override
    public int compareTo(Profile p) {
        if(this.getPreference() < p.getPreference()) {
            return  -1;
        } else if (this.getPreference() > p.getPreference()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return this.name + " , " + this.img + " , " + this.preference;
    }

}
