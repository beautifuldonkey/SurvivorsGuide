package beautifuldonkey.survivorsguide.Data;

import java.util.List;

/**
 * Created by user on 6/15/2015.
 */
public class Character {

    private String name;
    private int health;
    private int mind;
    private String strain;
    private List<Profession> professions;
    private List<Skill> skills;

    public Character (String charName, int charHealth, int charMind, String charStrain, List<Profession> charProfs, List<Skill> charSkills){
        name = charName;
        health = charHealth;
        mind = charMind;
        strain = charStrain;
        professions = charProfs;
        skills = charSkills;
    }
}
