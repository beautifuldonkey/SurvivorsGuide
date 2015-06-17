package beautifuldonkey.survivorsguide.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jed on 6/16/2015.
 */
public class SkillList {

    private static List<Skill> skillList = new ArrayList();

    public static List<Skill> getSkillList(){ return skillList; }

    static {
        skillList.add(new Skill("Parry", 5, "Melee Nope"));
        skillList.add(new Skill("Avoid", 5, "Ranged Nope"));
    }
}
