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

        professionList.add(new Profession("Assassin","Play an Assassin if you want to play a " +
                "dedicated contract killer."
                ,"Alert,Avoid,Backstab,Balance,Black Market Connections,Blinding,Choking Blow," +
                "Cover of Night,Disguise,Fade In A Crowd,Guild Member,Melee Weapon Small,Murder " +
                "Most Foul,Parry,Throwing,Vanish","strainReqs"
        ,"3,3,3,3,6,3,3,3,3,3,6,3,6,3,3,3"));
        professionList.add(new Profession("Caravan Driver","Play a Caravan Driver if you want to " +
                "play a hardened merchant prince of the road."
                ,"Bartender's Tongue,Bolt Action,Brawling,Charisma,Check Quality,Check Value," +
                "Feign Death,Income,Instruct,Melee Weapon Standard,Pistol Whip,Refuse,Teach," +
                "Trade Ties","strainReqs"
        ,"6,3,3,3,3,3,6,3,3,3,3,3,0,3"));
        professionList.add(new Profession("Charlatan","Play a Charlatan if you enjoy playing a " +
                "silver-tongued huckster."
                ,"Alert,Avoid,Beg For Life,Charisma,Cheat,Cure Toxins,Educated,Escape Bonds," +
                "Interrogate,Melee Weapon Small,Mind Resistance,Tie Bonds,Torture,Unlock"
                ,"strainReqs"
        ,"3,6,6,3,3,6,3,6,3,3,6,3,3,3"));
        professionList.add(new Profession("Cook","Play a Cook if you enjoy playing a crafter " +
                "whose food keeps other survivors at peak performance."
                ,"Analyze Compound,Charisma,Disguise Contents,Educated,Healthy Feast,Income," +
                "Instruct,Literacy,Nail,Prepare Meal,Rescue,Scrounge,Teach,Throwing","strainReqs"
        ,"3,6,3,3,3,3,3,3,3,3,3,6,0,3"));
        professionList.add(new Profession("Distiller","Play a Distiller if you enjoy playing a " +
                "crafter whose brews restore, relax and enhance your fellow survivors."
                ,"Analyze Compound,Bartender's Tongue,Brawling,Brew Master,Brewing,Check Quality," +
                "Cure Toxins,Educated,Income,Literacy,Melee Weapon Large,Melee Weapon Standard," +
                "Scrounge,Teach","strainReqs"
        ,"3,6,3,6,6,3,3,6,3,3,3,3,3,0"));
        professionList.add(new Profession("Doctor","Play a Doctor if you want to be a versatile " +
                "and powerful healer."
                ,"Bolt Action,Check Status,Cure Toxins,Educated,First Aide,Fix Limb,Income," +
                "Literacy,Mangle Limb,Medical Assistance,Medical Genius,Melee Weapon Small,Sever," +
                "Teach,Torture","strainReqs"
        ,"3,6,6,6,3,3,3,3,3,6,6,3,3,0,3"));
        professionList.add(new Profession("Engineer","Play an Engineer if you want to play a " +
                "crafter who reinforces strongholds and builds structures that offer powerful " +
                "benefits to large groups of people. "
                ,"Barricade,Check Quality,Chop,Florentine,Force Barricade,Forging the Future," +
                "Income,Literacy,Melee Weapon Small,Patch Job,Repair,SCIENCE!,Smelt,Weld"
                ,"strainReqs"
        ,"3,3,6,6,3,6,3,3,3,3,6,6,3,6"));
        professionList.add(new Profession("Entertainer","Play an Entertainer if you want to " +
                "bring some art and passion to a burning world."
                ,"Balance,Bartender's Tongue,Bolt Action,Bomb Awareness,Cheat,Check Value," +
                "Disarming Blow,Entertain,Head Shrink,Income,Lie,Melee Weapon Standard,Refuse," +
                "Throwing","strainReqs"
        ,"3,6,3,3,6,3,6,6,6,3,3,3,3,3"));
        professionList.add(new Profession("Farmer","Play a Farmer if you want to play a combat-" +
                "ready gatherer who provides very valuable and perishable commodities."
                ,"Alert,Analyze Creature,Animal Handler,Brawling,Brewing,Carry,Chase,Crop " +
                "Tending,First Aide,Income,Melee Weapon Standard,Take Down,Throwing","strainReqs"
        ,"3,3,3,6,3,3,3,3,3,3,3,6,3"));
        professionList.add(new Profession("Fishmonger","Play a Fishmonger if you want to be a " +
                "tough, exotic trader who brings fish for market and raw materials to keep the " +
                "town running."
                ,"Alert,Analyze Creature,Avoid,Bow,Brawling,Cheat,Fishing,Lie,Melee Weapon " +
                "Two-Handed,Nail,Sailing,Throwing Javelins,Tie Binds","strainReqs"
        ,"3,3,6,3,3,3,6,3,3,3,3,3,3"));
        professionList.add(new Profession("Gambler","Play a Gambler if you enjoy taking " +
                "outlandish risks and don't mind using dirty tricks to beat the odds."
                ,"Backstab,Bartender's Tongue,Black Market Connections,Brawling,Charisma,Cheat," +
                "Check Your Sleeves,Disarming Blow,Feign Death,Lie,Melee Weapon Small,Pick " +
                "Pockets,Throwing,Unlock","strainReqs"
        ,"6,6,3,3,3,3,6,3,3,3,3,6,3,3"));
        professionList.add(new Profession("Guard", "Play a Guard if you want to play a stalwart " +
                "protector and powerful defensive combatant."
                ,"Barricade,Blind Fighting,Bounce,Break Shield,Break Weapon,Carry,Fearful Glare," +
                "Force Barricade,Interfere,Knock Down,Mangle Limb,Melee Weapon Standard,Parry," +
                "Shield,Wide Strike", "N/A"
        ,"3,6,6,6,6,3,3,3,3,6,6,3,3,3,6"));
        professionList.add(new Profession("Gun Slinger","Play a Gun Slinger if you want to be an " +
                "absolute badass with a gun in your hand."
                ,"Blinding,Bolt Action,Challenge,Concentrated Fire,Destroy Shield,Destroy Weapon," +
                "Double-Tap,Fearful Glare,Gun Aficionado,Pistol Whip,Scatter Shot,Sniped Shot," +
                "Teach,Throwing","strainReqs"
        ,"6,3,3,6,6,6,3,3,6,3,3,6,0,3"));
        professionList.add(new Profession("Hook-up","Play a Hook-up if you like the guy who " +
                "knows a guy."
                ,"Attach,Bartender's Tongue,Black Market Connections,Building Tomorrow,Check " +
                "Quality,Check Value,Fade In A Crowd,Income,Patch Job,Rescue,SCIENCE!,Scrounge," +
                "Trade Ties,Trap Making,Unlock","strainReqs"
        ,"3,6,6,6,3,3,3,6,3,3,6,6,3,6,3"));
        professionList.add(new Profession("Hunter","Play a Hunter if you like being a tracker " +
                "and a master of primitive weaponry."
                ,"Alert,Bow,Carry,Charge,Chase,Double-Tap,Frightening Force,Hunter's Mark,Melee " +
                "Weapon Expert,Melee Weapon Large,Melee Weapon Small,Melee Weapon Standard,Nail," +
                "Throwing Javelins","strainReqs"
        ,"3,6,3,3,3,6,6,6,6,3,3,3,6,3"));
        professionList.add(new Profession("Jones","Play a Jones if you like being an action " +
                "archaeologist, relic in one hand and pistol in the other."
                ,"Attach,Balance,Big Dig,Bolt Action,Bomb Awareness,Brawling,Concentrated Fire," +
                "Disarming Shot,Double-Tap,Escape Bonds,Literacy,Pistol Whip,Scrounge,Teach,Unlock"
                ,"strainReqs"
        ,"3,3,3,6,3,6,6,3,6,3,3,6,3,6,6"));
        professionList.add(new Profession("Mad Scientist","Play a Mad Scientist if you enjoy " +
                "playing a slightly shady craftsman."
                ,"Black Market Connections,Bomb Awareness,Building Tomorrow,First Aide,Income," +
                "Literacy,Melee Weapon Two-Handed,Mind Resistance,Patch Job,Repair,SCIENCE!," +
                "Scrounge,Teach,Torture","strainReqs"
        ,"6,6,6,3,6,3,3,6,3,3,6,3,0,3"));
        professionList.add(new Profession("Martial Artist","Play a Martial Artist if you enjoy " +
                "being able to use a combination of brawling attacks and exotic special moves to " +
                "destroy your enemies."
                ,"Avoid,Balance,Bow,Brawling,Carry,Choking Blow,Escape Bonds,Iron Fists,Knockout," +
                "Literacy,Nerve Punch,Take Down,Wide Strike","strainReqs"
        ,"6,3,3,3,3,6,3,6,6,3,6,3,6"));
        professionList.add(new Profession("Merchant","Play a Merchant if you like being the one " +
                "who always has a stack of goods to sell and a taller stack of money from doing it."
                ,"Analyze Compound,Barricade,Bartender's Tongue,Beg For Life,Black Market " +
                "Connections,Carry,Charisma,Check Quality,Check Value,Check Your Sleeves," +
                "Disguise,Fade In A Crowd,Income,Lie","strainReqs"
        ,"3,6,6,6,6,3,3,3,6,3,6,3,3,3"));
        professionList.add(new Profession("Officer","Play an Officer if you want to take charge " +
                "of tactical situations while still being able to throw down alongside the troops."
                ,"Bolt Action,Brawling,Break Armor,Challenge,Charge,Destroy Armor,Disarming Shot," +
                "Fearful Glare,Florentine,Frightening Force,Instruct,Literacy,Melee Weapon Large," +
                "Teach","strainReqs"
        ,"6,3,3,3,6,6,6,6,6,6,3,3,3,0"));
        professionList.add(new Profession("Politician","Play a Politician if you like being a " +
                "key player in personal and political intrigue."
                ,"Avoid,Backstab,Bartender's Tongue,Beg For Life,Charisma,Cheat,Check Your " +
                "Sleeves,Educated,Entertain,Escape,Escape Bonds,Literacy,Melee Weapon Small," +
                "Income,Lie","strainReqs"
        ,"3,6,6,3,3,3,6,3,6,3,3,3,3,3,6"));
        professionList.add(new Profession("Priest","Play a priest if you want to play a powerful " +
                "spiritual leader with the ability to perform amazing miracles."
                ,"Avoid,Barricade,Bless Weapon,Call The Almighty,Carry,Charisma,Educated,Escape," +
                "Faith Healing,Holy Rites,Interfere,Literacy,Mind Resistance,Pray For Justice," +
                "Refuse","strainReqs"
        ,"3,6,3,6,3,3,3,3,6,3,3,3,3,6,3"));
        professionList.add(new Profession("Primitive","Play a Primitive if you want to play the " +
                "savage warrior who's deadly with all manner of primitive weapons."
                ,"Analyze Creature,Avoid,Bounce,Bow,Brawling,Challenge,Chase,Chop,Mangle Limb," +
                "Melee Weapon Two-Handed,Melee Weapon Expert,Shield,Throwing,Tie Bonds,Wide " +
                "Strike","strainReqs"
        ,"3,6,6,3,3,6,3,3,6,3,3,3,3,3,6"));
        professionList.add(new Profession("Printer","Play a Printer if you want to play a " +
                "well-connected craftsman who provides a vital service for every other crafter " +
                "in town."
                ,"Bartender's Tongue,Black Market Connections,Bolt Action,Charisma,Educated," +
                "Escape,Fade In A Crowd,Income,Instruct,Literacy,Mind Resistance,Teach," +
                "Transcribe","strainReqs"
        ,"3,3,3,6,3,6,3,3,3,3,3,0,3"));
        professionList.add(new Profession("Psionist","Play a Psionist if you want to play a " +
                "dangerous freak with seriously badass psychic powers."
                ,"Alert,Blind Fighting,Blinding,Chase,Double-Tap,Lie,Literacy,Melee Weapon Small," +
                "Mind Resistance,Psionic Skill: Basic,Psionic Skill: Intermediate,Psionic Skill: Advanced" +
                ",Refuse,Throwing","strainReqs"
        ,"6,6,6,3,6,3,3,3,3,3,6,6,3,3"));
        professionList.add(new Profession("Publican","Play a Publican if you want to be the " +
                "proprietor of a pleasure business in a grim world."
                ,"Bartender's Tongue,Beg For Life,Charisma,Check Quality,Check Your Sleeves,Deep " +
                "Pockets,Entertain,First Aide,Income,Literacy,Medical Assistance,Melee Weapon " +
                "Small,Pick Pockets,Trade Ties","strainReqs"
        ,"3,3,3,3,6,6,6,3,6,3,6,3,3,6"));
        professionList.add(new Profession("Pugilist","Play a Pugilist if you want to play " +
                "tough-as-nails bare-knuckle brawler, perhaps with a few shady connections on " +
                "the side."
                ,"Black Market Connections,Blind Fighting,Brawling,Challenge,Charge,First Aide," +
                "Income,Iron Fists,Knockout,Nerve Punch,Parry,Pick Pockets,Take Down,Teach," +
                "Torture","strainReqs"
        ,"6,6,3,6,3,3,3,6,6,3,3,6,3,0,6"));
        professionList.add(new Profession("Ring Leader","Play a Ring Leader if you want to be a " +
                "tough leader who's not afraid to get their hands dirty."
                ,"Attach,Black Market Connections,Blinding,Bolt Action,Charisma,Cheat,Check " +
                "Value,Chop,Disguise,Income,Mangle Limb,Melee Weapon Standard,Scatter Shot,Trap " +
                "Making","strainReqs"
        ,"3,6,3,3,6,3,3,3,3,3,6,3,6,6"));
        professionList.add(new Profession("Sawbones","Play a Sawbones if you want to be a true " +
                "combat medic with a lot of tricks up your sleeve."
                ,"Avoid,Black Market Connections,Brewing,Carry,Check Status,Cure Toxins,First " +
                "Aide,Guild Member,Income,Interfere,Interrogate,Literacy,Mangle Limb,Medical " +
                "Assistance,Melee Weapon Small,Rescue,Sever","strainReqs"
        ,"3,6,6,3,3,3,3,9,3,3,6,3,6,3,3,3,3"));
        professionList.add(new Profession("Scavenger","Play a Scavenger if you want to be " +
                "capable of pulling valuable raw materials out of just about any situation."
                ,"Analyze Creature,Avoid,Barricade,Beg For Life,Brawling,Check Quality,Check " +
                "Value,Chop,Cover of Night,Escape Bonds,Feign Death,Melee Weapon Two-Handed," +
                "Patch Job,Scrounge","strainReqs"
        ,"3,3,3,3,3,3,3,3,6,3,3,3,6,3"));
        professionList.add(new Profession("Scoundrel","Play a Scoundrel if you want to be a " +
                "criminal jack-of-all-trades."
                ,"Attach,Backstab,Black Market Connections,Blinding,Bolt Action,Brawling," +
                "Charisma,Cheat,Choking Blow,Disarming Blow,Guild Member,Interrogate,Lie,Melee " +
                "Weapon Small","strainReqs"
        ,"3,6,6,6,3,3,3,6,3,6,6,3,3,3"));
        professionList.add(new Profession("Sniper","Play a Sniper if you want to fire that " +
                "amazing shot from ambush, drop your enemy and disappear before anyone knows " +
                "what happened."
                ,"Alert,Attach,Balance,Bolt Action,Concentrated Fire,Cover of Night,Destroy " +
                "Shield,Destroy Weapon,Disarming Shot,Guild Member,Gun Aficionado,Murder Most " +
                "Foul,Sniped Shot,Vanish","strainReqs"
        ,"3,3,3,3,6,6,3,3,3,6,6,6,6,3"));
        professionList.add(new Profession("Soldier", "Play a Soldier if you want to be a well-" +
                "balanced melee bad-ass, equally at home with two weapons as you are with a " +
                "weapon and shield."
                ,"Avoid,Break Shield,Charge,Double-Tap,Florentine,Force Barricade,Interfere," +
                "Melee Weapon Expert,Melee Weapon Large,Melee Weapon Standard,Nail,Sever,Shield," +
                "Throwing-Javelins", "N/A"
        ,"3,6,6,6,6,6,3,6,3,3,3,3,3,3"));
        professionList.add(new Profession("Spy","Play a Spy if you enjoy the challenge of " +
                "learning secrets you're not meant to know."
                ,"Balance,Bartender's Tongue,Blinding,Chase,Cover of Night,Disguise,Escape," +
                "Escape Bonds,Fade In A Crowd,Feign Death,Guild Member,Income,Lie,Scrounge," +
                "Unlock","strainReqs"
        ,"3,6,3,3,6,6,3,3,6,3,6,3,3,6,3"));
        professionList.add(new Profession("Teacher","Play a Teacher if you want to have answers " +
                "to the most difficult questions, and the tools to find out whatever you don't " +
                "already know."
                ,"Analyze Compound,Analyze Creature,Check Quality,Check Status,Check Your " +
                "Sleeves,Educated,Feign Death,Head Shrink,Instruct,Literacy,Lore,Patch Job," +
                "Refuse,Teach","strainReqs"
        ,"3,3,3,3,3,3,6,6,3,3,3,3,6,0"));
        professionList.add(new Profession("Thief","Play a Thief if you want to be able to look " +
                "at most any item and say, yea that could be mine no problem."
                ,"Avoid,Attach,Blinding,Black Market Connections,Disguise,Escape,Escape Bonds," +
                "Fade In A Crowd,Feign Death,Lie,Melee Weapon Small,Pick Pockets,Scrounge,Trap " +
                "Making,Unlock","strainReqs"
        ,"6,3,6,6,6,3,6,6,3,3,3,6,3,6,3"));
        professionList.add(new Profession("Thug","Play a Thug if you want to be a serious melee " +
                "fighter who's not afraid to kick down a door to get to your target."
                ,"Barricade,Bolt Action,Brawling,Carry,Force Barricade,Frightening Force,Melee " +
                "Weapon Expert,Melee Weapon Large,Melee Weapon Small,Melee Weapon Standard," +
                "Patch Job,Sever,Shield,Take Down","strainReqs"
        ,"3,6,3,3,3,6,3,3,3,3,3,6,3,3"));
        professionList.add(new Profession("Tinker","Play a Tinker if you want to be the best " +
                "around at building, repairing and improving weapons, armor and other essential " +
                "items."
                ,"Analyze Compound,Building Tomorrow,Check Quality,Chop,Educated,Improved Armor/Shield," +
                "Improved Pistol/Bow,Improved Weapon,Income,Literacy,Master Craftsman,Patch Job," +
                "Repair,SCIENCE!","strainReqs"
        ,"3,6,3,3,3,6,6,6,3,3,6,3,3,6"));
    }
}