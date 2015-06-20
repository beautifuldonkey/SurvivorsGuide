package beautifuldonkey.survivorsguide.Data;

/**
 * Created by user on 6/15/2015.
 */
public class Profession {

    private String name;
    private String description;
    private String skills;
    private String strainReqs;

    public Profession (String profName, String profDesc, String profSkills, String profStrainReqs){
        this.name = profName;
        this.description = profDesc;
        this.skills = profSkills;
        this.strainReqs = profStrainReqs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getStrainReqs() {
        return strainReqs;
    }

    public void setStrainReqs(String strainReqs) {
        this.strainReqs = strainReqs;
    }
}
