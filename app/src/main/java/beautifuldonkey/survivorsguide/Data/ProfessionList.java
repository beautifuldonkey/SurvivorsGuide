package beautifuldonkey.survivorsguide.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * provides profession data & accessor methods
 * Created by Jed on 6/19/2015.
 */

public class ProfessionList {

    private static List<Profession> professionList = new ArrayList();

    public static List<Profession> getProfessionList(){ return professionList;}

    public static Profession getProfessionByName(String name){
        Profession foundProf = null;

        for(int i=0; i<professionList.size(); i++){
            if(professionList.get(i).getName().equals(name)){
                foundProf = professionList.get(i);
            }
        }

        return foundProf;
    }

    static{


        professionList.add(new Profession("Assassin","desc","Alert,Avoid,Backstab,Balance,Black Market Connections,Blinding,Choking Blow,Cover of Night,Disguise,Fade In A Crowd,Guild Member, Melee Weapon Small,Murder Most Foul,Parry,Throwing,Vanish","strainReqs"
        ,"3,3,3,3,6,3,3,3,3,3,6,3,6,3,3,3"));
        professionList.add(new Profession("Caravan Driver","desc","Bartender's Tongue,Bolt Action,Brawling,Charisma,Check Quality,Check Value,Feign Death,Income,Instruct,Melee Weapon Standard,Pistol Whip,Refuse,Teach,Trade Ties","strainReqs"
        ,"6,3,3,3,3,3,6,3,3,3,3,3,0,3"));
        professionList.add(new Profession("Charlatan","desc","Alert,Avoid,Beg For Life,Charisma,Cheat,Cure Toxins,Educated,Escape Bonds,Interrogate,Melee Weapon Small,Mind Resistance,Tie Binds,Torture,Unlock","strainReqs"
        ,"3,6,6,3,3,6,3,6,3,3,6,3,3,3"));
        professionList.add(new Profession("Cook","desc","Analyze Compound,Charisma,Disguise Contents,Educated,Healthy Feast,Income,Instruct,Literay,Nail,Prepare Meal,Rescue,Scrounge,Teach,Throwing","strainReqs"
        ,"3,6,3,3,3,3,3,3,3,3,3,6,0,3"));
        professionList.add(new Profession("Distiller","desc","Analyze Compound,Bartender's Tongue,Brawling,Brew Master,Brewing,Check Quality,Cure Toxins,Educated,Income,Literacy,Melee Weapon Large,Melee Weapon Standard,Scrounge,Teach","strainReqs"
        ,"3,6,3,6,6,3,3,6,3,3,3,3,3,0"));
        professionList.add(new Profession("Doctor","desc","Bolt Action,Check Status,Cure Toxins,Education,First Aide,Fix Limb,Income,Literacy,Mangle Limb,Medical Assistance,Medical Genius,Melee Weapon Small,Sever,Teach,Torture","strainReqs"
        ,"3,6,6,6,3,3,3,3,3,6,6,3,3,0,3"));
        professionList.add(new Profession("Engineer","desc","Barricade,Check Quality,Chop,Florentine,Force Barricade,Forging the Future,Income,Literacy,Melee Weapon Small,Patch Job,Repair,SCIENCE!,Smelt,Weld","strainReqs"
        ,"3,3,6,6,3,6,3,3,3,3,6,6,3,6"));
        professionList.add(new Profession("Entertainer","desc","Balance,Bartender's Tongue,Bolt Action,Bomb Awareness,Cheat,Check Value,Disarming Blow,Entertain,Head Shrink,Income,Lie,Melee Weapon Standard,Refuse,Throwing","strainReqs"
        ,"3,6,3,3,6,3,6,6,6,3,3,3,3,3"));
        professionList.add(new Profession("Farmer","desc","Alert,Analyze Creature,Animal Handler,Brawling,Brewing,Carry,Chase,Crop Tending,First Aide,Income,Melee Weapon Standard,Take Down,Throwing","strainReqs"
        ,"3,3,3,6,3,3,3,3,3,3,3,6,3"));
        professionList.add(new Profession("Fishmonger","desc","Alert,Analyze Creature,Avoid,Bow,Brawling,Cheat,Fishing,Lie,Melee Weapon, Two-Handed,Nail,Sailing,Throwing Javelins,Tie Binds","strainReqs"
        ,"3,3,6,3,3,3,6,3,3,3,3,3,3"));
        professionList.add(new Profession("Gambler","desc","Backstab,Bartender's Tongue,Black Market Connections,Brawling,Charisma,Cheat,Check Your Sleeves,Disarming Blow,Feign Death,Lie,Melee Weapon Small,Pick Pockets,Throwing,Unlock","strainReqs"
        ,"6,6,3,3,3,3,6,3,3,3,3,6,3,3"));
        professionList.add(new Profession("Gaurd", "Melee badass", "Barricade,Blind Fighting,Bounce,Break Shield,Break Weapon,Carry,Fearful Glare,Force Barricade,Interfere,Knock Down,Mangle Limb,Melee Weapon Standard,Parry,Shield,Wide Strike", "N/A"
        ,"3,6,6,6,6,3,3,3,3,6,6,3,3,3,6"));
        professionList.add(new Profession("Gun Slinger","desc","Blinding,Bolt Action,Challenge,Concentrated Fire,Destroy Shield,Destroy Weapon,Double-Tap,Fearful Glare,Gun Aficionado,Pistol Whip,Scatter Shot,Sniped Shot,Teach,Throwing","strainReqs"
        ,"6,3,3,6,6,6,3,3,6,3,3,6,0,3"));
        professionList.add(new Profession("Hook-up","desc","Attach,Bartender's Tongue,Black Market Connections,Building Tomorrow,Check Quality,Check Value,Fade In A Crowd,Income,Patch Job,Rescue,SCIENCE!,Scrounge,Trade Ties,Trap Making,Unlock","strainReqs"
        ,"3,6,6,6,3,3,3,6,3,3,6,6,3,6,3"));
        professionList.add(new Profession("Hunter","desc","Alert,Bow,Carry,Charge,Chase,Double-Tap,Frightening Force,Hunter's Mark,Melee Weapon Expert,Melee Weapon Large,Melee Weapon Small,Melee Weapon Standard,Nail,Throwing Javelins","strainReqs"
        ,"3,6,3,3,3,6,6,6,6,3,3,3,6,3"));
        professionList.add(new Profession("Jones","desc","Attach,Balance,Big Dig,Bolt-Action,Bomb Awareness,Brawling,Concentrated Fire, Disarming Shot,Double-Tap,Escape Bonds,Literacy,Pistol Whip,Scrounge,Teach,Unlock","strainReqs"
        ,"3,3,3,6,3,6,6,3,6,3,3,6,3,6,6"));
        professionList.add(new Profession("Mad Scientist","desc","Black Market Connection,Bomb Awareness,Building Tomorrow,First Aide,Income,Literacy,Melee Weapon Two-Handed,Mind Resistance,Patch Job,Repair,SCIENCE!,Scrounge,Teach,Torture","strainReqs"
        ,"6,3,3,3,3,6,3,6,6,3,6,3,6"));
        professionList.add(new Profession("Martial Artist","desc","Avoid,Balance,Bow,Brawling,Carry,Choking Blow,Escape Bonds,Iron Fists,Knockout,Literacy,Nerve Punch,Takedown,Wide Strike","strainReqs"
        ,"6,3,3,3,3,6,3,6,6,3,6,3,6"));
        professionList.add(new Profession("Merchant","desc","Analyze Compound,Barricade,Bartender's Tongue,Beg For Life,Black Market Connections,Carry,Charisma,Check Quality,Check Value,Check Your Sleeves,Disguise,Fade In A Crowd,Income,Lie","strainReqs"
        ,"3,6,6,6,6,3,3,3,6,3,6,3,3,3"));
        professionList.add(new Profession("Officer","desc","Bolt Action,Brawling,Break Armor,Challenge,Charge,Destroy Armor,Disarming Shot,Fearful Glare,Florentine,Frightening Force,Instruct,Literacy,Melee Weapon Large,Teach","strainReqs"
        ,"6,3,3,3,6,6,6,6,6,6,3,3,3,0"));
        professionList.add(new Profession("Politician","desc","Avoid,Backstab,Bartender's Tongue,Beg For Life,Charisma,Cheat,Check Your Sleeves,Edcuated,Entertain,Escape,Escape Bonds,Literacy,Melee Weapon Small,Income,Lie","strainReqs"
        ,"3,6,6,3,3,3,6,3,6,3,3,3,3,3,6"));
        professionList.add(new Profession("Priest","desc","Avoid,Barricade,Bless Weapon,Call The Almighty,Carry,Charisma,Educated,Escape,Faith Healing,Holy Rites,Interfere,Literacy,Mind Resistance,Pray For Justice,Refuse","strainReqs"
        ,"3,6,3,6,3,3,3,3,6,3,3,3,3,6,3"));
        professionList.add(new Profession("Primitive","desc","Analyze Creature,Avoid,Bounce,Bow,Brawling,Challenge,Chase,Chop,Mangle Limb,Melee Weapon Two-Handed,Melee Weapon Expert,Shield,Throwing,Tie Binds,Wide Strike","strainReqs"
        ,"3,6,6,3,3,6,3,3,6,3,3,3,3,3,6"));
        professionList.add(new Profession("Printer","desc","Bartender's Tongue,Black Market Connections,Bolt Action Charisma,Educated,Escape,Fade In A Crowd,Income,Instruct,Literacy,Mind Resistance,Teach,Transcribe","strainReqs"
        ,"3,3,3,6,3,6,3,3,3,3,3,0,3"));
        professionList.add(new Profession("Psionist","desc","Alert,Blind Fighting,Blinding,Chase,Double-Tap,Lie,Literacy,Melee Weapon Small,Mind Resistance,Psionic Basic Skill,Psionic Intermediate Skill,Psionic Advanced Skill,Refuse,Throwing","strainReqs"
        ,"6,6,6,3,6,3,3,3,3,3,6,6,3,3"));
        professionList.add(new Profession("Publican","desc","Bartender's Tongue,Beg For Life,Charisma,Check Quality,Check Your Sleeves,Deep Pockets,Entertain,First Aide,Income,Literacy,Medical Assistance,Melee Weapon Small,Pick Pockets,Trade Ties","strainReqs"
        ,"3,3,3,3,6,6,6,3,6,3,6,3,3,6"));
        professionList.add(new Profession("Pugilist","desc","Black Market Connections,Blind Fighting,Brawling,Challenge,Charge,First Aide,Income,Iron Fists,Knockout,Nerve Punch,Parry,Pick Pockets,Takedown,Teach,Torture","strainReqs"
        ,"6,6,3,6,3,3,3,6,6,3,3,6,3,0,6"));
        professionList.add(new Profession("Ring Leader","desc","Attach,Black Market Connections,Blinding,Bolt Action,Charisma,Cheat,Check Value,Chop,Disguise,Income,Mangle Limb,Melee Weapon Standard,Scatter Shot,Trap Making","strainReqs"
        ,"3,6,3,3,6,3,3,3,3,3,6,3,6,6"));
        professionList.add(new Profession("Sawbones","desc","Avoid,Black Market Connections,Brewing,Carry,Check Status,Cure Toxins,First Aide,Guild Member,Income,Interfere,Interrogate,Literacy,Mangle Limb,Medical Assistance,Melee Weapon Small,Rescue,Sever","strainReqs"
        ,"3,6,6,3,3,3,3,9,3,3,6,3,6,3,3,3,3"));
        professionList.add(new Profession("Scavenger","desc","Analyze Creature,Avoid,Barricade,Beg For Life,Brawling,Check Quality,Check Value,Chop,Cover of Night,Escape Bonds,Feign Death,Melee Weapon Two-Handed,Patch Job,Scrounge","strainReqs"
        ,"3,3,3,3,3,3,3,3,6,3,3,3,6,3"));
        professionList.add(new Profession("Scoundrel","desc","Attach,Backstab,Black Market Connections,Blinding,Bolt Action,Brawling,Charisma,Cheat,Choking Blow,Disarming Blow,Guild Member,Interrogate,Lie,Melee Weapon Small","strainReqs"
        ,"3,6,6,6,3,3,3,6,3,6,6,3,3,3"));
        professionList.add(new Profession("Sniper","desc","Alert,Attach,Balance,Bolt Action,Concentrated Fire,Cover of Night,Destroy Shield,Destroy Weapon,Disarming Shot,Guild Member,Gun Aficionado,Murder Most Foul,Sniped Shot,Vanish","strainReqs"
        ,"3,3,3,3,6,6,3,3,3,6,6,6,6,3"));
        professionList.add(new Profession("Soldier", "Melee badass", "Avoid,Break Shield,Charge,Double-Tap,Florentine,Force Barricade,Interfere,Melee Weapon Expert,Melee Weapon Large,Melee Weapon Standard,Nail,Sever,Shield,Throwing-Javelins", "N/A"
        ,"3,6,6,6,6,6,3,6,3,3,3,3,3,3"));
        professionList.add(new Profession("Spy","desc","Balance,Bartender's Tongue,Blinding,Chase,Cover of Night,Disguise,Escape,Escape Bonds,Fade In A Crowd,Feign Death,Guild Member,Income,Lie,Scrounge,Unlock","strainReqs"
        ,"3,6,3,3,6,6,3,3,6,3,6,3,3,6,3"));
        professionList.add(new Profession("Teacher","desc","Analyze Compound,Analyze Creature,Check Quality,Check Status,Check Your Sleeves,Educated,Feign Death,Head Shrink,Instruct,Literacy,Lore,Patch Job,Refuse,Teach","strainReqs"
        ,"3,3,3,3,3,3,6,6,3,3,3,3,6,0"));
        professionList.add(new Profession("Thief","desc","Avoid,Attach,Blinding,Black Market Connections,Disguise,Escape,Escape Bonds,Fade In A Crowd,Feign Death,Lie,Melee Weapon Small,Pick Pockets,Scrounge,Trap Making,Unlock","strainReqs"
        ,"6,3,6,6,6,3,6,6,3,3,3,6,3,6,3"));
        professionList.add(new Profession("Thug","desc","Barricade,Bolt Action,Brawling,Carry,Force Barricade,Frightening Force,Melee Weapon Expert,Melee Weapon Large,Melee Weapon Small,Melee Weapon Standard,Patch Job,Sever,Shield,Take Down","strainReqs"
        ,"3,6,3,3,3,6,3,3,3,3,3,6,3,3"));
        professionList.add(new Profession("Tinker","desc","Analyze Compound,Building Tomorrow,Check Quality,Chop,Educated,Improved Armor,Improved Pistol/Bow,Improved Weapon,Income,Literacy,Master Craftsman,Patch Job,Repair,SCIENCE!","strainReqs"
        ,"3,6,3,3,3,6,6,6,3,3,6,3,3,6"));


    }
}
