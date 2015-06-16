package beautifuldonkey.survivorsguide.Data;

/**
 * Created by user on 6/15/2015.
 */
public class Character {

    private String name;
    private int health;
    private int mind;
    private String strain;
    private String professions;
    private String skills;

    public Character (String charName, int charHealth, int charMind, String charStrain, String charProfs, String charSkills){
        name = charName;
        health = charHealth;
        mind = charMind;
        strain = charStrain;
        professions = charProfs;
        skills = charSkills;
    }
}
