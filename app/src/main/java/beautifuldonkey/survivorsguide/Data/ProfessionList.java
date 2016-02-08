package beautifuldonkey.survivorsguide.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * provides profession data & accessor methods
 * Created by Jed on 6/19/2015.
 */

//TODO write test to check validity of data
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
        professionList.add(new Profession("Engineer","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Entertainer","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Farmer","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Fishmonger","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Gambler","desc","skillz","strainReqs","skillCost"));

        professionList.add(new Profession("Gaurd", "Melee badass", "Barricade,Blind Fighting,Bounce,Break Shield,Break Weapon,Carry,Fearful Glare,Force Barricade,Interfere,Knock Down,Mangle Limb,Melee Weapon Standard,Parry,Shield,Wide Strike", "N/A"
        ,"3,6,6,6,6,3,3,3,3,6,6,3,3,3,6"));

        professionList.add(new Profession("Gun Slinger","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Hook-up","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Hunter","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Jones","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Mad Scientist","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Martial Artist","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Merchant","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Officer","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Politician","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Priest","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Primitive","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Printer","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Psionist","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Publican","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Pugilist","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Ring Leader","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Sawbones","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Scavenger","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Sniper","desc","skillz","strainReqs","skillCost"));

        professionList.add(new Profession("Soldier", "Melee badass", "Avoid,Break Shield,Charge,Double-Tap,Florentine,Force Barricade,Interfere,Melee Weapon Expert,Melee Weapon Large,Melee Weapon Standard,Nail,Sever,Shield,Throwing-Javelins", "N/A"
        ,"3,6,6,6,6,6,3,6,3,3,3,3,3,3"));

        professionList.add(new Profession("Spy","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Teacher","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Thief","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Thug","desc","skillz","strainReqs","skillCost"));
        professionList.add(new Profession("Tinker","desc","skillz","strainReqs","skillCost"));


    }
}
