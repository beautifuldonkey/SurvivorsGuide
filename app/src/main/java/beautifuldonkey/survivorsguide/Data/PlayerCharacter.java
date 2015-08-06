package beautifuldonkey.survivorsguide.Data;

import java.util.List;

/**
 * Defines Character JSON structure saved to internal storage
 * Created by user on 6/15/2015.
 */
public class PlayerCharacter {

    private String name;
    private String health;
    private String mind;
    private String strain;
    private String infection;
    private String professions;
    private String profSkills;
    private String strainSkills;

    public PlayerCharacter (String charName, String charHealth, String charMind, String charStrain
            , String charInfection, String charProfs, String profSkills, String strainSkills){
        this.name = charName;
        this.health = charHealth;
        this.mind = charMind;
        this.strain = charStrain;
        this.infection = charInfection;
        this.professions = charProfs;
        this.profSkills = profSkills;
        this.strainSkills = strainSkills;
    }

    public String getInfection() {
        return infection;
    }

    public void setInfection(String infection) {
        this.infection = infection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getMind() {
        return mind;
    }

    public void setMind(String mind) {
        this.mind = mind;
    }

    public String getStrain() {
        return strain;
    }

    public void setStrain(String strain) {
        this.strain = strain;
    }

    public String getProfessions() {
        return professions;
    }

    public void setProfessions(String professions) {
        this.professions = professions;
    }

    public String getProfSkills() {
        return profSkills;
    }

    public void setProfSkills(String profSkills) {
        this.profSkills = profSkills;
    }

    public String getStrainSkills() {
        return strainSkills;
    }

    public void setStrainSkills(String strainSkills) {
        this.strainSkills = strainSkills;
    }
}
