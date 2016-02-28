package beautifuldonkey.survivorsguide.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * provides a list of available skills & accessor methods
 * Created by Jed on 6/16/2015.
 */
public class SkillList {

    private static List<Skill> skillList = new ArrayList<>();

    public static List<Skill> getSkillList(){ return skillList; }

    public static List<Skill> getSkillsByName(String skillName){
        List<Skill> skills = new ArrayList<>();

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
                if(skillName.equals(skillList.get(j).getName())){
                    skills.add(skillList.get(j));
                }
            }
        }

        return skills;
    }

    static {

        /**
         * Skill{
         * name
         * mpCost
         * desc
         * isStrain
         * buildCost
         * currRank
         * availRank
         * }
         */

        skillList.add(new Skill("Alert", 5, "Counters all stealth skills.",false,3,1,1));
        skillList.add(new Skill("Analyze Compound", 1, "Counters disguise contents.",false,3,1,1));
        skillList.add(new Skill("Analyze Creature", 1, "Countered by Disguise. To use point and " +
                "say: Analyze Creature, what are you? Relevant details given per MP.",false,3,1,5));
        skillList.add(new Skill("Animal Handler", 0, "Usable at home game only. During check " +
                "in a character can receive one of: Scrap/Produce/Named Herb for each level" +
                "possessed.", false,3,1,1));
        skillList.add(new Skill("Attach", 5, "Countered by Bomb Awareness. Allows a character to " +
                "mount and prime an existing Trap to go off. Can also be used to disarm visible " +
                "traps.", false,3,1,1));
        skillList.add(new Skill("Avoid", 5, "Counters Concentrated Fire, Destroy Shield, Destroy " +
                "Weapon, Disarming Shot, Scatter Shot, Sniped Shot, Knockout, and any other " +
                "successful ranted targeted attacks. Ineffective against area of effect skills.",
                false,3,1,1));
        skillList.add(new Skill("Backstab", 5, "When striking an enemy from behind with a small " +
                "melee weapon, say: Backstab, X Body! The strike will slip past all armor and " +
                "damage Body directly.", false,3,1,1));
        skillList.add(new Skill("Balance", 5, "Counters Knockdown and Take Down. Can also be " +
                "used to provide additional 1 foot width to a narrow path for 10 paces or 1 min. " +
                "at a cost of 1 Mind.", false,3,1,1));
        skillList.add(new Skill("Bartender's Tongue", 0, "Usable at home game only. Allows a " +
                "character to come into game with additional knowledge.", false,3,1,1));
        skillList.add(new Skill("Barricade", 5, "Countered by Force Barricade. For every 2 Mind " +
                "and 2 Min. of roleplay a Barricade with a crafts level equal to every 2 Mind " +
                "spent is created. Crafting process may be repeated to add to this level.",
                false,3,1,1));
        skillList.add(new Skill("Beg for Life", 1, "Counters Killing Blows, can be countered by " +
                "Refuse. Unusable if under the effects of Choking Blow. Prevents any Killing " +
                "Blows from being called and lasts 2 min. or until the user takes any action " +
                "other than groveling.", false,3,1,1));
        skillList.add(new Skill("Big Dig", 0, "Usable at home game only. Most often used at " +
                "check in, but may also be used to represent archaeological prowess during " +
                "certain events.", false,3,1,5));
        skillList.add(new Skill("Black Market Connections", 0, "Grants the character knowledge " +
                "of the Black Market meeting location while at their home game and attendance " +
                "privileges while traveling. Services include: fencing hot items, launder money, " +
                "sell forbidden goods, and work connections.", false,3,1,1));
        skillList.add(new Skill("Bless Weapon", 5, "Allows a player to bless a melee, brawling, " +
                "ranged, or firearm weapon so that it gains the Blessed trait for the duration " +
                "of one day (until midnight).", false,3,1,1));
        skillList.add(new Skill("Blind Fighting", 1, "Counters Blinding, Gizmos, and situation " +
                "effects that would make you blind. To use say Blind Fighting and spend 1 Mind.",
                false,3,1,1));
        skillList.add(new Skill("Blinding", 5, "Countered by Blind Fighting and Parry if blow is " +
                "dealt from the front. Attack deals 0 damage and prevents the use of Skills or " +
                "other actions for 10 seconds.", false,3,1,1));
        skillList.add(new Skill("Bolt Action", 0, "Allows the player to wield a single firearm.",
                false,3,1,1));
        skillList.add(new Skill("Bomb Awareness", 5, "Counters Attach to an extent. Allows " +
                "player to take back an action that triggered a trap.", false,3,1,1));
        skillList.add(new Skill("Bounce", 1, "Counters ranged attacks that successfully target a " +
                "shield or weapon.", false,3,1,1));
        skillList.add(new Skill("Bow", 0, "Allows the player to wield a simple bow and arrow.",
                false,3,1,1));
        skillList.add(new Skill("Brawling", 0, "Allows the player to wield 2 small size melee " +
                "boffers, colored white, to represent fists. Damage is still taken when " +
                "blocking, however Florentine is not required and cannot be disarmed or broken " +
                "like other weapons. Only Iron Fists allows player to block with Brawling " +
                "without taking damage.", false,3,1,1));
        skillList.add(new Skill("Break Armor", 10, "Can be countered by Parry if strike is from " +
                "the front. Renders targets armor useless until repaired.", false,3,1,1));
        skillList.add(new Skill("Break Shield", 5, "Countered by Parry. Attack does 0 damage " +
                "and renders the shield useless until repaired.", false,3,1,1));
        skillList.add(new Skill("Break Weapon", 5, "Can be countered by Parry if strike is from " +
                "the front. Renders the weapon useless until repaired.", false,3,1,1));
        skillList.add(new Skill("Brew Master", 2, "Allows player to get more potency out of " +
                "their Brews. While Brewing a player may spend 2 Mind, 1 Rare Herb, and 10 min. " +
                "roleplay up to 5 times to increase the Brew's crafts level by 1. Each level " +
                "increase allows the brewer to choose to increase the duration by 5 min (not to " +
                "exceed an hour) or all numerical effects by 1.", false,3,1,1));
        skillList.add(new Skill("Brewing", 2, "Allows player to distill powerful liquids from " +
                "Herbs that have a variety of effects. Spend 2 Mind and 20 min. at a still " +
                "roleplaying brewing the crafter may turn in the required Herb cards to " +
                "Logistics to be traded in for a new Item card.", false,3,1,1));
        skillList.add(new Skill("Building Tomorrow", 3, "Allows player to take Scrap and build " +
                "new items. All items start with a crafts level 1 and have a five year " +
                "expiration date unless otherwise specified.", false,3,1,1));
        skillList.add(new Skill("Call The Almighty", 10, "By calling upon divine intervention " +
                "you become a conduit of your deity capable of miraculous healing powers. By " +
                "placing both hands on a wounded target and spending 10 Mind the target is " +
                "completely healed. Not usable on self.", false,3,1,1));
        skillList.add(new Skill("Carry", 1, "Allows player to lift and carry large weights for " +
                "short periods of time. Cannot be used if a leg is under the effects of Mangle " +
                "and one arm must be functional. For every 1 Mind the character's strength is " +
                "increased by one.", false,3,1,1));
        skillList.add(new Skill("Challenge", 5, "Countered by Refuse and Choking Blow (if used " +
                "first). Causes target to attack only you unless attacked by others.",
                false,3,1,1));
        skillList.add(new Skill("Charge", 5, "Countered by Parry if the strike is from the front.",
                false,3,1,1));
        skillList.add(new Skill("Charisma", 1, "Countered by Refuse or Choking Blow (if used " +
                "first). In order to use you must talk to the target for at least 5 minutes. " +
                "After that time you can spend 1 Mind and declare Charisma which causes the " +
                "target to become temporarily enthralled.", false,3,1,1));
        skillList.add(new Skill("Chase", 5, "Counters Escape and Rescue. When used successfully " +
                "neither you or the target move anywhere and the scene continues.", false,3,1,1));
        skillList.add(new Skill("Cheat", 5, "Countered by Check Your Sleeves. When used the " +
                "player automatically wins a single hand of cards or die roll.", false,3,1,1));
        skillList.add(new Skill("Check Quality", 1, "Allows player to know exactly how much " +
                "damage a weapon can do, how much damage armor can take along with the crafts " +
                "level of the item.", false,3,1,1));
        skillList.add(new Skill("Check Status", 1, "Counters Feign Death. After a minute of " +
                "roleplay this skill can be used to gain information about the targets current " +
                "status including: health, drug/poison/injuries/diseases/derangement's.",
                false,3,1,1));
        skillList.add(new Skill("Check Value", 1, "Allows player to spend 1 Mind to appraise an " +
                "item's true monetary value as listed on the card.", false,3,1,1));
        skillList.add(new Skill("Check Your Sleeves", 1, "Counters Cheat. Does not imply that " +
                "you have caught the cheater but that they were unable to sneak loaded dice or " +
                "marked cards into the game.", false,3,1,1));
        skillList.add(new Skill("Chocking Blow", 5, "Allows player to strike the front or back " +
                "of the torso with a small melee, thrown, or brawling weapon. If successful the " +
                "target cannot speak for 2 min.", false,3,1,1));
        skillList.add(new Skill("Chop", 1, "Allows player to spend 1 Mind to trade a broken item " +
                "for 1 Basic Scrap, can be used on NPC weapons or shields. Requires 10 seconds " +
                "of active roleplay.", false,3,1,1));
        skillList.add(new Skill("Concentrated Fire", 1, "Countered by Avoid or Bounce. Allows a " +
                "ranged shot to be counted as striking a specific part of a target, regardless " +
                "of where the target is actually struck though the target must still actually " +
                "be struck by the attack.", false,3,1,1));
        skillList.add(new Skill("Cover of Night", 5, "Counter by Alert. Once the sun has " +
                "completely set and you're away from other sources of bright light you may " +
                "travel completely unseen so long as the invisible symbol is up. Use of skills " +
                "ends the effect as does speaking, opening doors, picking things up, and " +
                "entering brightly lit areas.", false,3,1,1));
        skillList.add(new Skill("Crop Tending", 5, "Allows access to valuable plants either " +
                "growing in a field or hidden in places around town which can be harvested over " +
                "the duration of the weekend.", false,3,1,1));
        skillList.add(new Skill("Cure Toxins", 5, "Allows player to to purge the targets blood " +
                "of all toxins. The process takes 10 min., is considered to be quite painful, " +
                "and causes 1 damage to the target upon completion.", false,3,1,1));
        skillList.add(new Skill("Deep Pockets", 0, "Usable at home game only. Allows player " +
                "access to steady suppliers of Herb.", false,3,1,1));
        skillList.add(new Skill("Destroy Armor", 10, "Countered by Avoid or Bounce. With a " +
                "successful ranged attack armor is rendered useless until repaired.", false,3,1,1));
        skillList.add(new Skill("Destroy Shield", 5, "Countered by Avoid or Bounce. With a " +
                "successful ranged attack a shield is rendered useless until repaired.",
                false,3,1,1));
        skillList.add(new Skill("Destroy Weapon", 5, "Countered by Avoid or Bounce. With a " +
                "successful ranged attack a weapon is rendered useless until repaired.",
                false,3,1,1));
        skillList.add(new Skill("Disarming Blow", 5, "Countered by Parr if the strike was made " +
                "from the front. After landing a successful melee strike the target weapon is " +
                "dropped for 5 seconds (Two-handed become 1 handed for duration).", false,3,1,1));
        skillList.add(new Skill("Disarming Shot", 5, "Countered by Avoid or Bounce. With a " +
                "successful ranged attack a weapon is dropped for 5 seconds.", false,3,1,1));
        skillList.add(new Skill("Disguise", 5, "Counters Analyze Creature, countered by Tie " +
                "Binds. After undergoing a full costume change and wearing a mask / heavy makeup " +
                "a player may take on the the appearance and physical mannerisms of another for " +
                "30 min.", false,3,1,1));
        skillList.add(new Skill("Disguise Contents", 5, "Counter by Analyze Compound. Allows a " +
                "Cook to slip a compound into a prepared Meal.", false,3,1,1));
        skillList.add(new Skill("Double-Tap", 1, "Allows player to execute a Killing Blow which " +
                "negates any ability a creature may have that would cause it to get up again " +
                "after receiving a Killing Blow.", false,3,1,1));
        skillList.add(new Skill("Educated", 5, "description", false,3,1,1));
        skillList.add(new Skill("Entertain", 5, "description", false,3,1,1));
        skillList.add(new Skill("Escape", 5, "description", false,3,1,1));
        skillList.add(new Skill("Escape Bonds", 5, "description", false,3,1,1));
        skillList.add(new Skill("Fade In A Crowd", 5, "description", false,3,1,1));
        skillList.add(new Skill("Faith Healing", 5, "description", false,3,1,1));
        skillList.add(new Skill("Fearful Glare", 5, "description", false,3,1,1));
        skillList.add(new Skill("Feign Death", 5, "description", false,3,1,1));
        skillList.add(new Skill("First Aide", 5, "description", false,3,1,1));
        skillList.add(new Skill("Fishing", 5, "description", false,3,1,1));
        skillList.add(new Skill("Fix Limb", 5, "description", false,3,1,1));
        skillList.add(new Skill("Florentine", 5, "description", false,3,1,1));
        skillList.add(new Skill("Force Barricade", 5, "description", false,3,1,1));
        skillList.add(new Skill("Forging the Future", 5, "description", false,3,1,1));
        skillList.add(new Skill("Frightening Force", 5, "description", false,3,1,1));
        skillList.add(new Skill("Guild Member", 5, "description", false,3,1,1));
        skillList.add(new Skill("Gun Aficionado", 5, "description", false,3,1,1));
        skillList.add(new Skill("Head Shrink", 5, "description", false,3,1,1));
        skillList.add(new Skill("Healthy Feast", 5, "description", false,3,1,1));
        skillList.add(new Skill("Holy Rites", 5, "description", false,3,1,1));
        skillList.add(new Skill("Hunter's Mark", 5, "description", false,3,1,1));
        skillList.add(new Skill("Improved Armor/Shield", 5, "description", false,3,1,1));
        skillList.add(new Skill("Improved Pistol/Bow", 5, "description", false,3,1,1));
        skillList.add(new Skill("Improved Weapon", 5, "description", false,3,1,1));
        skillList.add(new Skill("Income", 5, "description", false,3,1,5));
        skillList.add(new Skill("Instruct", 5, "description", false,3,1,1));
        skillList.add(new Skill("Interfere", 5, "description", false,3,1,1));
        skillList.add(new Skill("Interrogate", 5, "description", false,3,1,1));
        skillList.add(new Skill("Iron Fists", 5, "description", false,3,1,1));
        skillList.add(new Skill("Knock Down", 5, "description", false,3,1,1));
        skillList.add(new Skill("Knockout", 5, "description", false,3,1,1));
        skillList.add(new Skill("Lie", 5, "description", false,3,1,1));
        skillList.add(new Skill("Literacy", 5, "description", false,3,1,1));
        skillList.add(new Skill("Lore", 5, "description", false,3,1,1));
        skillList.add(new Skill("Mange Limb", 5, "description", false,3,1,1));
        skillList.add(new Skill("Master Craftsman", 5, "description", false,3,1,1));
        skillList.add(new Skill("Medical Assistance", 5, "description", false,3,1,1));
        skillList.add(new Skill("Medical Genius", 5, "description", false,3,1,1));
        skillList.add(new Skill("Melee Weapon Expert", 5, "description", false,3,1,1));
        skillList.add(new Skill("Melee Weapon Large", 5, "description", false,3,1,1));
        skillList.add(new Skill("Melee Weapon Small", 5, "description", false,3,1,1));
        skillList.add(new Skill("Melee Weapon Standard", 5, "description", false,3,1,1));
        skillList.add(new Skill("Melee Weapon Two-Handed", 5, "description", false,3,1,1));
        skillList.add(new Skill("Mind Resistance", 5, "description", false,3,1,1));
        skillList.add(new Skill("Murder Most Foul", 5, "description", false,3,1,1));
        skillList.add(new Skill("Nail", 5, "description", false,3,1,1));
        skillList.add(new Skill("Nerve Punch", 5, "description", false,3,1,1));
        skillList.add(new Skill("Parry", 5, "description", false,3,1,1));
        skillList.add(new Skill("Patch Job", 5, "description", false,3,1,1));
        skillList.add(new Skill("Pick Pockets", 5, "description", false,3,1,1));
        skillList.add(new Skill("Pistol Whip", 5, "description", false,3,1,1));
        skillList.add(new Skill("Prepare Meal", 5, "description", false,3,1,1));
        skillList.add(new Skill("Pray for Justice", 5, "description", false,3,1,1));
        skillList.add(new Skill("Psionic Skill: Basic", 5, "description", false,3,1,1));
        skillList.add(new Skill("Psionic Skill: Intermediate", 5, "description", false,3,1,1));
        skillList.add(new Skill("Psionic Skill: Advanced", 5, "description", false,3,1,1));
        skillList.add(new Skill("Refuse", 5, "description", false,3,1,1));
        skillList.add(new Skill("Repair", 5, "description", false,3,1,1));
        skillList.add(new Skill("Rescue", 5, "description", false,3,1,1));
        skillList.add(new Skill("Sailing", 5, "description", false,3,1,1));
        skillList.add(new Skill("Scatter Shot", 5, "description", false,3,1,1));
        skillList.add(new Skill("SCIENCE!", 5, "description", false,3,1,1));
        skillList.add(new Skill("Scrounge", 5, "description", false,3,1,1));
        skillList.add(new Skill("Sever", 5, "description", false,3,1,1));
        skillList.add(new Skill("Shield", 5, "description", false,3,1,1));
        skillList.add(new Skill("Smelt", 5, "description", false,3,1,1));
        skillList.add(new Skill("Sniped Shot", 5, "description", false,3,1,1));
        skillList.add(new Skill("Society Membership", 5, "description", false,3,1,1));
        skillList.add(new Skill("Take Down", 5, "description", false,3,1,1));
        skillList.add(new Skill("Teach", 5, "description", false,3,1,1));
        skillList.add(new Skill("Throwing", 5, "description", false,3,1,1));
        skillList.add(new Skill("Throwing-Javelins", 5, "description", false,3,1,1));
        skillList.add(new Skill("Tie Bonds", 5, "description", false,3,1,1));
        skillList.add(new Skill("Torture", 5, "description", false,3,1,1));
        skillList.add(new Skill("Trade Ties", 5, "description", false,3,1,1));
        skillList.add(new Skill("Transcribe", 5, "description", false,3,1,1));
        skillList.add(new Skill("Trap Making", 5, "description", false,3,1,1));
        skillList.add(new Skill("Unlock", 5, "description", false,3,1,1));
        skillList.add(new Skill("Vanish", 5, "description", false,3,1,1));
        skillList.add(new Skill("Weld", 5, "description", false,3,1,1));
        skillList.add(new Skill("Wide Strike", 5, "description", false,3,1,1));
    }
}
