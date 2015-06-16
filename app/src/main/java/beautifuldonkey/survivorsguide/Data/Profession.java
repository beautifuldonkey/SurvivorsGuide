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
        name = profName;
        description = profDesc;
        skills = profSkills;
        strainReqs = profStrainReqs;
    }
}
