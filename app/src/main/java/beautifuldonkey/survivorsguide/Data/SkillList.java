package beautifuldonkey.survivorsguide.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jed on 6/16/2015.
 */
public class SkillList {

    private static List<Skill> skillList = new ArrayList();

    public static List<Skill> getSkillList(){ return skillList; }

    public List<Skill> getSkillsByName(String skillName){
        List<Skill> skills = new ArrayList();

        if(skillName.contains(",")){
            String [] skillNames = skillName.split(",");
            for(int i =0; i < skillNames.length; i++){
                for(int j=0; j<skillList.size();j++){
                    if(skillNames[i] == skillList.get(j).getName()){
                        skills.add(skillList.get(j));
                    }
                }
            }
        }else{
            for(int j=0; j<skillList.size();j++){
                if(skillName == skillList.get(j).getName()){
                    skills.add(skillList.get(j));
                }
            }
        }

        return skills;
    }

    static {
        skillList.add(new Skill("Parry", 5, "Melee Nope"));
        skillList.add(new Skill("Avoid", 5, "Ranged Nope"));
    }
}
