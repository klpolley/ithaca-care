package com.example.icwc.volunteerapp;

/**
 * Created by katherine on 2/11/18.
 */

public class Organization {

    //properties for organization
    protected String name;
    protected String interest;
    protected String target;
    protected String duration;
    protected int match;

    //concstructor
    public Organization(String nameIn, String interestIn, String targetIn, String durationIn){
        name=nameIn;
        interest=interestIn;
        target=targetIn;
        duration=durationIn;
        match=0;
    }

    //getters
    public String getName(){
        return name;
    }

    public String getInterest(){
        return interest;
    }

    public String getTarget(){
        return target;
    }

    public String getDuration(){
        return duration;
    }

    public int getMatch(){
        return match;
    }

    public void resetMatch(){
        match=0;
    }

    public void addMatch(){
        match=match+33;
    }

    public void checkMatch(){
        if (match==99){
            match=100;
        }
    }

}
