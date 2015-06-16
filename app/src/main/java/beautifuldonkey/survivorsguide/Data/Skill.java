package beautifuldonkey.survivorsguide.Data;

/**
 * Created by user on 6/15/2015.
 */
public class Skill {

    private String name;
    private int mpCost;
    private String description;

    public Skill (String skillName, int cost, String desc){
        name = skillName;
        mpCost = cost;
        description = desc;
    }
}
