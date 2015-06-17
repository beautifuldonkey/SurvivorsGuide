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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMind() {
        return mind;
    }

    public void setMind(int mind) {
        this.mind = mind;
    }

    public int getInfection() {
        return infection;
    }

    public void setInfection(int infection) {
        this.infection = infection;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
