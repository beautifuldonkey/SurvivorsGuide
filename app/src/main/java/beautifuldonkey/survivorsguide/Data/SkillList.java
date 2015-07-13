package beautifuldonkey.survivorsguide.Data;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jed on 6/16/2015.
 */
public class SkillList {

    private static List<Skill> skillList = new ArrayList();

    public static List<Skill> getSkillList(){ return skillList; }

    public static List<Skill> getSkillsByName(String skillName){
        List<Skill> skills = new ArrayList();

        if(skillName.contains(",")){
            String [] skillNames = skillName.split(",");
            for(int i =0; i < skillNames.length; i++){
                for(int j=0; j<skillList.size();j++){
                    if(skillNames[i].equals(skillList.get(j).getName())){
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

        skillList.add(new Skill("Alert", 5, "description", false));
        skillList.add(new Skill("Analyze Compound", 5, "description", false));
        skillList.add(new Skill("Analyze Creature", 5, "description", false));
        skillList.add(new Skill("Animal Handler", 5, "description", false));
        skillList.add(new Skill("Attach", 5, "description", false));
        skillList.add(new Skill("Avoid", 5, "description", false));
        skillList.add(new Skill("Backstab", 5, "description", false));
        skillList.add(new Skill("Balance", 5, "description", false));
        skillList.add(new Skill("Bartender's Tongue", 5, "description", false));
        skillList.add(new Skill("Barricade", 5, "description", false));
        skillList.add(new Skill("Beg for Life", 5, "description", false));
        skillList.add(new Skill("Big Dig", 5, "description", false));
        skillList.add(new Skill("Black Market Connections", 5, "description", false));
        skillList.add(new Skill("Bless Weapon", 5, "description", false));
        skillList.add(new Skill("Blind Fighting", 5, "description", false));
        skillList.add(new Skill("Blinding", 5, "description", false));
        skillList.add(new Skill("Bolt Action", 5, "description", false));
        skillList.add(new Skill("Bomb Awareness", 5, "description", false));
        skillList.add(new Skill("Bounce", 5, "description", false));
        skillList.add(new Skill("Bow", 5, "description", false));
        skillList.add(new Skill("Brawling", 5, "description", false));
        skillList.add(new Skill("Break Armor", 5, "description", false));
        skillList.add(new Skill("Break Shield", 5, "description", false));
        skillList.add(new Skill("Break Weapon", 5, "description", false));
        skillList.add(new Skill("Brew Master", 5, "description", false));
        skillList.add(new Skill("Brewing", 5, "description", false));
        skillList.add(new Skill("Building Tomorrow", 5, "description", false));
        skillList.add(new Skill("Call The Almighty", 5, "description", false));
        skillList.add(new Skill("Carry", 5, "description", false));
        skillList.add(new Skill("Challenge", 5, "description", false));
        skillList.add(new Skill("Charge", 5, "description", false));
        skillList.add(new Skill("Charisma", 5, "description", false));
        skillList.add(new Skill("Chase", 5, "description", false));
        skillList.add(new Skill("Cheat", 5, "description", false));
        skillList.add(new Skill("Check Quality", 5, "description", false));
        skillList.add(new Skill("Check Status", 5, "description", false));
        skillList.add(new Skill("Check Value", 5, "description", false));
        skillList.add(new Skill("Check Your Sleeves", 5, "description", false));
        skillList.add(new Skill("Chocking Blow", 5, "description", false));
        skillList.add(new Skill("Chop", 5, "description", false));
        skillList.add(new Skill("Concentrated Fire", 5, "description", false));
        skillList.add(new Skill("Cover of Night", 5, "description", false));
        skillList.add(new Skill("Crop Tending", 5, "description", false));
        skillList.add(new Skill("Cure Toxins", 5, "description", false));
        skillList.add(new Skill("Deep Pockets", 5, "description", false));
        skillList.add(new Skill("Destroy Armor", 5, "description", false));
        skillList.add(new Skill("Destroy Shield", 5, "description", false));
        skillList.add(new Skill("Destroy Weapon", 5, "description", false));
        skillList.add(new Skill("Disarming Blow", 5, "description", false));
        skillList.add(new Skill("Disarming Shot", 5, "description", false));
        skillList.add(new Skill("Disguise", 5, "description", false));
        skillList.add(new Skill("Disguise Contents", 5, "description", false));
        skillList.add(new Skill("Double-Tap", 5, "description", false));
        skillList.add(new Skill("Educated", 5, "description", false));
        skillList.add(new Skill("Entertain", 5, "description", false));
        skillList.add(new Skill("Escape", 5, "description", false));
        skillList.add(new Skill("Escape Bonds", 5, "description", false));
        skillList.add(new Skill("Fade In A Crowd", 5, "description", false));
        skillList.add(new Skill("Faith Healing", 5, "description", false));
        skillList.add(new Skill("Fearful Glare", 5, "description", false));
        skillList.add(new Skill("Feign Death", 5, "description", false));
        skillList.add(new Skill("First Aide", 5, "description", false));
        skillList.add(new Skill("Fishing", 5, "description", false));
        skillList.add(new Skill("Fix Limb", 5, "description", false));
        skillList.add(new Skill("Florentine", 5, "description", false));
        skillList.add(new Skill("Force Barricade", 5, "description", false));
        skillList.add(new Skill("Forging the Future", 5, "description", false));
        skillList.add(new Skill("Frightening Force", 5, "description", false));
        skillList.add(new Skill("Guild Member", 5, "description", false));
        skillList.add(new Skill("Gun Aficionado", 5, "description", false));
        skillList.add(new Skill("Head Shrink", 5, "description", false));
        skillList.add(new Skill("Healthy Feast", 5, "description", false));
        skillList.add(new Skill("Holy Rites", 5, "description", false));
        skillList.add(new Skill("Hunter's Mark", 5, "description", false));
        skillList.add(new Skill("Improved Armor/Shield", 5, "description", false));
        skillList.add(new Skill("Improved Pistol/Bow", 5, "description", false));
        skillList.add(new Skill("Improved Weapon", 5, "description", false));
        skillList.add(new Skill("Income", 5, "description", false));
        skillList.add(new Skill("Instruct", 5, "description", false));
        skillList.add(new Skill("Interfere", 5, "description", false));
        skillList.add(new Skill("Interrogate", 5, "description", false));
        skillList.add(new Skill("Iron Fists", 5, "description", false));
        skillList.add(new Skill("Knock Down", 5, "description", false));
        skillList.add(new Skill("Knockout", 5, "description", false));
        skillList.add(new Skill("Lie", 5, "description", false));
        skillList.add(new Skill("Literacy", 5, "description", false));
        skillList.add(new Skill("Lore", 5, "description", false));
        skillList.add(new Skill("Mange Limb", 5, "description", false));
        skillList.add(new Skill("Master Craftsman", 5, "description", false));
        skillList.add(new Skill("Medical Assistance", 5, "description", false));
        skillList.add(new Skill("Medical Genius", 5, "description", false));
        skillList.add(new Skill("Melee Weapon Expert", 5, "description", false));
        skillList.add(new Skill("Melee Weapon Large", 5, "description", false));
        skillList.add(new Skill("Melee Weapon Small", 5, "description", false));
        skillList.add(new Skill("Melee Weapon Standard", 5, "description", false));
        skillList.add(new Skill("Melee Weapon Two-Handed", 5, "description", false));
        skillList.add(new Skill("Mind Resistance", 5, "description", false));
        skillList.add(new Skill("Murder Most Foul", 5, "description", false));
        skillList.add(new Skill("Nail", 5, "description", false));
        skillList.add(new Skill("Nerve Punch", 5, "description", false));
        skillList.add(new Skill("Parry", 5, "description", false));
        skillList.add(new Skill("Patch Job", 5, "description", false));
        skillList.add(new Skill("Pick Pockets", 5, "description", false));
        skillList.add(new Skill("Pistol Whip", 5, "description", false));
        skillList.add(new Skill("Prepare Meal", 5, "description", false));
        skillList.add(new Skill("Pray for Justice", 5, "description", false));
        skillList.add(new Skill("Psionic Skill: Basic", 5, "description", false));
        skillList.add(new Skill("Psionic Skill: Intermediate", 5, "description", false));
        skillList.add(new Skill("Psionic Skill: Advanced", 5, "description", false));
        skillList.add(new Skill("Refuse", 5, "description", false));
        skillList.add(new Skill("Repair", 5, "description", false));
        skillList.add(new Skill("Rescue", 5, "description", false));
        skillList.add(new Skill("Sailing", 5, "description", false));
        skillList.add(new Skill("Scatter Shot", 5, "description", false));
        skillList.add(new Skill("SCIENCE!", 5, "description", false));
        skillList.add(new Skill("Scrounge", 5, "description", false));
        skillList.add(new Skill("Sever", 5, "description", false));
        skillList.add(new Skill("Shield", 5, "description", false));
        skillList.add(new Skill("Smelt", 5, "description", false));
        skillList.add(new Skill("Sniped Shot", 5, "description", false));
        skillList.add(new Skill("Society Membership", 5, "description", false));
        skillList.add(new Skill("Take Down", 5, "description", false));
        skillList.add(new Skill("Teach", 5, "description", false));
        skillList.add(new Skill("Throwing", 5, "description", false));
        skillList.add(new Skill("Throwing, Javelins", 5, "description", false));
        skillList.add(new Skill("Tie Bonds", 5, "description", false));
        skillList.add(new Skill("Torture", 5, "description", false));
        skillList.add(new Skill("Trade Ties", 5, "description", false));
        skillList.add(new Skill("Transcribe", 5, "description", false));
        skillList.add(new Skill("Trap Making", 5, "description", false));
        skillList.add(new Skill("Unlock", 5, "description", false));
        skillList.add(new Skill("Vanish", 5, "description", false));
        skillList.add(new Skill("Weld", 5, "description", false));
        skillList.add(new Skill("Wide Strike", 5, "description", false));
    }
}
