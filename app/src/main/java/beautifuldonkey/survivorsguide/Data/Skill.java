package beautifuldonkey.survivorsguide.Data;

/**
 * Created by user on 6/15/2015.
 */
public class Skill {

    private String name;
    private int mpCost;
    private String description;

    public Skill (String skillName, int cost, String desc){
        this.name = skillName;
        this.mpCost = cost;
        this.description = desc;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMpCost() {
        return mpCost;
    }

    public void setMpCost(int mpCost) {
        this.mpCost = mpCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
