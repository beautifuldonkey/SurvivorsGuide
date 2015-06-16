package beautifuldonkey.survivorsguide.Data;

/**
 * Created by user on 6/15/2015.
 */
public class Strain {

    private String name;
    private int health;
    private int mind;
    private int infection;
    private String skills;

    public Strain (String strainName, int strainHealth, int strainMind, int strainInfection, String strainSkills){
        name = strainName;
        health = strainHealth;
        mind = strainMind;
        infection = strainInfection;
        skills = strainSkills;
    }
}
