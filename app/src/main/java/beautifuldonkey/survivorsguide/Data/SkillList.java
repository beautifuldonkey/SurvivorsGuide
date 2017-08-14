package beautifuldonkey.survivorsguide.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * provides a list of available skills & accessor methods
 * Created by Jed on 6/16/2015.
 */
public class SkillList {

  private static List<Skill> skillList = new ArrayList<>();
  private static List<Skill> openSkillList = new ArrayList<>();

  /**
   * Provides access to the open skill list
   * @return list of skills available to all characters
   */
  public static List<Skill> getOpenSkills(){
    if(openSkillList.size()==0){
      String openSkillNames = "Avoid,Barricade,Bolt Action,Brawling,Check Quality,Check Value,First Aide,Force Barricade,Literacy,Lore,Melee Weapon Small,Melee Weapon Standard,Melee Weapon Two-Handed,Parry,Pistol Whip,Shield,Society Membership,Teach,Throwing,Throwing Javelins,Tie Bonds";
      String openSkillCosts = "9,9,9,9,9,9,9,9,6,6,6,6,6,6,9,6,0,1,6,6,6";
      openSkillList = getSkillsByNameSetCost(openSkillNames,openSkillCosts);
    }
    return openSkillList;
  }
  /**
   * Provides the complete skill list
   * @return complete list of skills
   */
  public static List<Skill> getSkillList() {
    return skillList;
  }
  /**
   * Retrieves skills that match received comma separated names
   * @param skills string of comma separated names
   * @return list of skills that matched received names
   */
  public static List<Skill> getSkillsByName(String skills) {
    List<Skill> list = new ArrayList<>();

    if (skills!=null && skills.contains(",")) {
      String[] skillNames = skills.split(",");
      for (String skillName : skillNames) {
        System.out.println("Finding: "+skillName);
        list.add(searchSkillList(skillList,0,skillList.size(),skillName));
        System.out.println("Found: "+skillName);
      }
    }else if(skills!=null && skills.length()>0){
      System.out.println("Finding: "+skills);
      list.add(searchSkillList(skillList,0,skillList.size(),skills));
      System.out.println("Found: "+skills);
    }

    return list;
  }

  /**
   * Retrieves skills that match comma separated name names and applies build cost
   * @param skillName string of comma separated names
   * @param skillCost string of comma separated costs
   * @return list of skills that matched received names & cost the received values
   */
  public static List<Skill> getSkillsByNameSetCost(String skillName, String skillCost) {
    List<Skill> skills = new ArrayList<>();

    if (skillName.contains(",")) {
      String[] skillNames = skillName.split(",");
      String[] skillCosts = skillCost.split(",");
      for (int i = 0; i < skillNames.length; i++) {
        System.out.println("Finding: "+skillNames[i]);
        Skill foundSkill = searchSkillList(skillList,0,skillList.size(),skillNames[i]);
        foundSkill.setBuildCost(Integer.valueOf(skillCosts[i]));
        skills.add(foundSkill);
        System.out.println("Found: "+skillNames[i]);
      }
    } else if(skillName!=null && skillName.length()>0){
      System.out.println("Finding: "+skillName);
      Skill foundSkill = searchSkillList(skillList,0,skillList.size(),skillName);
      foundSkill.setBuildCost(Integer.valueOf(skillCost));
      skills.add(foundSkill);
      System.out.println("Found: "+skillName);
    }

    return skills;
  }

  private static Skill searchSkillList(List<Skill> skills, int start, int end, String name){
    if(name.equals("No Strain Skills")){
      Skill remSkill = new Skill();
      remSkill.setName("No Strain Skills");
      return remSkill;
    }

    int mid = (start + end) / 2;

    if(name.contains("Lore")){
      name = "Lore";
    }

    if(skills.get(mid).getName().equals(name)){
      return skills.get(mid);
    }

    if(name.toLowerCase().compareTo(skills.get(mid).getName().toLowerCase()) < 0){
      return searchSkillList(skills,start,mid-1,name);
    }else{
      return searchSkillList(skills,mid+1,end,name);
    }
  }

  static {
    skillList.add(new Skill("Alert", 5, "Counters all stealth skills.", false, 3, 1, 1));
    skillList.add(new Skill("Analyze Compound", 1, "Counters disguise contents.", false, 3, 1, 1));
    skillList.add(new Skill("Analyze Creature", 1, "Countered by Disguise. To use point and " +
        "say: Analyze Creature, what are you? Relevant details given per MP.", false, 3, 1, 5));
    skillList.add(new Skill("Animal Handler", 0, "Usable at home game only. During check " +
        "in a character can receive one of: Scrap/Produce/Named Herb for each level" +
        "possessed.", false, 3, 1, 1));
    skillList.add(new Skill("Attach", 5, "Countered by Bomb Awareness. Allows a character to " +
        "mount and prime an existing Trap to go off. Can also be used to disarm visible " +
        "traps.", false, 3, 1, 1));
    skillList.add(new Skill("Avoid", 5, "Counters Concentrated Fire, Destroy Shield, Destroy " +
        "Weapon, Disarming Shot, Scatter Shot, Sniped Shot, Knockout, and any other " +
        "successful ranted targeted attacks. Ineffective against area of effect skills.",
        false, 3, 1, 1));
    skillList.add(new Skill("Backstab", 5, "When striking an enemy from behind with a small " +
        "melee weapon, say: Backstab, X Body! The strike will slip past all armor and " +
        "damage Body directly.", false, 3, 1, 1));
    skillList.add(new Skill("Balance", 5, "Counters Knockdown and Take Down. Can also be " +
        "used to provide additional 1 foot width to a narrow path for 10 paces or 1 min. " +
        "at a cost of 1 Mind.", false, 3, 1, 1));
    skillList.add(new Skill("Barricade", 5, "Countered by Force Barricade. For every 2 Mind " +
        "and 2 Min. of roleplay a Barricade with a crafts level equal to every 2 Mind " +
        "spent is created. Crafting process may be repeated to add to this level.",
        false, 3, 1, 1));
    skillList.add(new Skill("Bartender's Tongue", 0, "Usable at home game only. Allows a " +
        "character to come into game with additional knowledge.", false, 3, 1, 1));
    skillList.add(new Skill("Beg For Life", 1, "Counters Killing Blows, can be countered by " +
        "Refuse. Unusable if under the effects of Choking Blow. Prevents any Killing " +
        "Blows from being called and lasts 2 min. or until the user takes any action " +
        "other than groveling.", false, 3, 1, 1));
    skillList.add(new Skill("Big Dig", 0, "Usable at home game only. Most often used at " +
        "check in, but may also be used to represent archaeological prowess during " +
        "certain events.", false, 3, 1, 5));
    skillList.add(new Skill("Black Market Connections", 0, "Grants the character knowledge " +
        "of the Black Market meeting location while at their home game and attendance " +
        "privileges while traveling. Services include: fencing hot items, launder money, " +
        "sell forbidden goods, and work connections.", false, 3, 1, 1));
    skillList.add(new Skill("Bless Weapon", 5, "Allows a player to bless a melee, brawling, " +
        "ranged, or firearm weapon so that it gains the Blessed trait for the duration " +
        "of one day (until midnight).", false, 3, 1, 1));
    skillList.add(new Skill("Blind Fighting", 1, "Counters Blinding, Gizmos, and situation " +
        "effects that would make you blind. To use say Blind Fighting and spend 1 Mind.",
        false, 3, 1, 1));
    skillList.add(new Skill("Blinding", 5, "Countered by Blind Fighting and Parry if blow is " +
        "dealt from the front. Attack deals 0 damage and prevents the use of Skills or " +
        "other actions for 10 seconds.", false, 3, 1, 1));
    skillList.add(new Skill("Bolt Action", 0, "Allows the player to wield a single firearm.",
        false, 3, 1, 1));
    skillList.add(new Skill("Bomb Awareness", 5, "Counters Attach to an extent. Allows " +
        "player to take back an action that triggered a trap.", false, 3, 1, 1));
    skillList.add(new Skill("Bounce", 1, "Counters ranged attacks that successfully target a " +
        "shield or weapon.", false, 3, 1, 1));
    skillList.add(new Skill("Bow", 0, "Allows the player to wield a simple bow and arrow.",
        false, 3, 1, 1));
    skillList.add(new Skill("Brawling", 0, "Allows the player to wield 2 small size melee " +
        "boffers, colored white, to represent fists. Damage is still taken when " +
        "blocking, however Florentine is not required and cannot be disarmed or broken " +
        "like other weapons. Only Iron Fists allows player to block with Brawling " +
        "without taking damage.", false, 3, 1, 1));
    skillList.add(new Skill("Break Armor", 10, "Can be countered by Parry if strike is from " +
        "the front. Renders targets armor useless until repaired.", false, 3, 1, 1));
    skillList.add(new Skill("Break Shield", 5, "Countered by Parry. Attack does 0 damage " +
        "and renders the shield useless until repaired.", false, 3, 1, 1));
    skillList.add(new Skill("Break Weapon", 5, "Can be countered by Parry if strike is from " +
        "the front. Renders the weapon useless until repaired.", false, 3, 1, 1));
    skillList.add(new Skill("Brew Master", 2, "Allows player to get more potency out of " +
        "their Brews. While Brewing a player may spend 2 Mind, 1 Rare Herb, and 10 min. " +
        "roleplay up to 5 times to increase the Brew's crafts level by 1. Each level " +
        "increase allows the brewer to choose to increase the duration by 5 min (not to " +
        "exceed an hour) or all numerical effects by 1.", false, 3, 1, 1));
    skillList.add(new Skill("Brewing", 2, "Allows player to distill powerful liquids from " +
        "Herbs that have a variety of effects. Spend 2 Mind and 20 min. at a still " +
        "roleplaying brewing the crafter may turn in the required Herb cards to " +
        "Logistics to be traded in for a new Item card.", false, 3, 1, 1));
    skillList.add(new Skill("Building Tomorrow", 3, "Allows player to take Scrap and build " +
        "new items. All items start with a crafts level 1 and have a five year " +
        "expiration date unless otherwise specified.", false, 3, 1, 1));
    skillList.add(new Skill("Call The Almighty", 10, "By calling upon divine intervention " +
        "you become a conduit of your deity capable of miraculous healing powers. By " +
        "placing both hands on a wounded target and spending 10 Mind the target is " +
        "completely healed. Not usable on self.", false, 3, 1, 1));
    skillList.add(new Skill("Carry", 1, "Allows player to lift and carry large weights for " +
        "short periods of time. Cannot be used if a leg is under the effects of Mangle " +
        "and one arm must be functional. For every 1 Mind the character's strength is " +
        "increased by one.", false, 3, 1, 1));
    skillList.add(new Skill("Challenge", 5, "Countered by Refuse and Choking Blow (if used " +
        "first). Causes target to attack only you unless attacked by others.",
        false, 3, 1, 1));
    skillList.add(new Skill("Charge", 5, "Countered by Parry if the strike is from the front.",
        false, 3, 1, 1));
    skillList.add(new Skill("Charisma", 1, "Countered by Refuse or Choking Blow (if used " +
        "first). In order to use you must talk to the target for at least 5 minutes. " +
        "After that time you can spend 1 Mind and declare Charisma which causes the " +
        "target to become temporarily enthralled.", false, 3, 1, 1));
    skillList.add(new Skill("Chase", 5, "Counters Escape and Rescue. When used successfully " +
        "neither you or the target move anywhere and the scene continues.", false, 3, 1, 1));
    skillList.add(new Skill("Cheat", 5, "Countered by Check Your Sleeves. When used the " +
        "player automatically wins a single hand of cards or die roll.", false, 3, 1, 1));
    skillList.add(new Skill("Check Quality", 1, "Allows player to know exactly how much " +
        "damage a weapon can do, how much damage armor can take along with the crafts " +
        "level of the item.", false, 3, 1, 1));
    skillList.add(new Skill("Check Status", 1, "Counters Feign Death. After a minute of " +
        "roleplay this skill can be used to gain information about the targets current " +
        "status including: health, drug/poison/injuries/diseases/derangement's.",
        false, 3, 1, 1));
    skillList.add(new Skill("Check Value", 1, "Allows player to spend 1 Mind to appraise an " +
        "item's true monetary value as listed on the card.", false, 3, 1, 1));
    skillList.add(new Skill("Check Your Sleeves", 1, "Counters Cheat. Does not imply that " +
        "you have caught the cheater but that they were unable to sneak loaded dice or " +
        "marked cards into the game.", false, 3, 1, 1));
    skillList.add(new Skill("Choking Blow", 5, "Allows player to strike the front or back " +
        "of the torso with a small melee, thrown, or brawling weapon. If successful the " +
        "target cannot speak for 2 min.", false, 3, 1, 1));
    skillList.add(new Skill("Chop", 1, "Allows player to spend 1 Mind to trade a broken item " +
        "for 1 Basic Scrap, can be used on NPC weapons or shields. Requires 10 seconds " +
        "of active roleplay.", false, 3, 1, 1));
    skillList.add(new Skill("Concentrated Fire", 1, "Countered by Avoid or Bounce. Allows a " +
        "ranged shot to be counted as striking a specific part of a target, regardless " +
        "of where the target is actually struck though the target must still actually " +
        "be struck by the attack.", false, 3, 1, 1));
    skillList.add(new Skill("Cover of Night", 5, "Counter by Alert. Once the sun has " +
        "completely set and you're away from other sources of bright light you may " +
        "travel completely unseen so long as the invisible symbol is up. Use of skills " +
        "ends the effect as does speaking, opening doors, picking things up, and " +
        "entering brightly lit areas.", false, 3, 1, 1));
    skillList.add(new Skill("Crop Tending", 5, "Allows access to valuable plants either " +
        "growing in a field or hidden in places around town which can be harvested over " +
        "the duration of the weekend.", false, 3, 1, 1));
    skillList.add(new Skill("Cure Toxins", 5, "Allows player to to purge the targets blood " +
        "of all toxins. The process takes 10 min., is considered to be quite painful, " +
        "and causes 1 damage to the target upon completion.", false, 3, 1, 1));
    skillList.add(new Skill("Deep Pockets", 0, "Usable at home game only. Allows player " +
        "access to steady suppliers of Herb.", false, 3, 1, 1));
    skillList.add(new Skill("Destroy Armor", 10, "Countered by Avoid or Bounce. With a " +
        "successful ranged attack armor is rendered useless until repaired.", false, 3, 1, 1));
    skillList.add(new Skill("Destroy Shield", 5, "Countered by Avoid or Bounce. With a " +
        "successful ranged attack a shield is rendered useless until repaired.",
        false, 3, 1, 1));
    skillList.add(new Skill("Destroy Weapon", 5, "Countered by Avoid or Bounce. With a " +
        "successful ranged attack a weapon is rendered useless until repaired.",
        false, 3, 1, 1));
    skillList.add(new Skill("Disarming Blow", 5, "Countered by Parr if the strike was made " +
        "from the front. After landing a successful melee strike the target weapon is " +
        "dropped for 5 seconds (Two-handed become 1 handed for duration).", false, 3, 1, 1));
    skillList.add(new Skill("Disarming Shot", 5, "Countered by Avoid or Bounce. With a " +
        "successful ranged attack a weapon is dropped for 5 seconds.", false, 3, 1, 1));
    skillList.add(new Skill("Disguise", 5, "Counters Analyze Creature, countered by Tie " +
        "Binds. After undergoing a full costume change and wearing a mask / heavy makeup " +
        "a player may take on the the appearance and physical mannerisms of another for " +
        "30 min.", false, 3, 1, 1));
    skillList.add(new Skill("Disguise Contents", 5, "Counter by Analyze Compound. Allows a " +
        "Cook to slip a compound into a prepared Meal.", false, 3, 1, 1));
    skillList.add(new Skill("Double-Tap", 1, "Allows player to execute a Killing Blow which " +
        "negates any ability a creature may have that would cause it to get up again " +
        "after receiving a Killing Blow.", false, 3, 1, 1));
    skillList.add(new Skill("Educated", 0, "Allows player to reduce crafts time of: Building " +
        "A Better Tomorrow, Transcribe, and Brewing by 10 min. Medical Genius is reduced " +
        "to 2 min. Additionally a player may spend 10 Mind and 30 min. once per event " +
        "and ask ST staff 3 questions regarding a possessed Lore skill.", false, 3, 1, 1));
    skillList.add(new Skill("Entertain", 1, "Allows player to provide a Private Showing in " +
        "which their chosen talent is performed, at the conclusion targets regain 10 " +
        "Mind. Usable and receivable once per twelves. Private Showings require a " +
        "minimum of 30 minutes of uninterrupted roleplay, additional targets increase " +
        "roleplay time by 5 minutes and costs 5 additional Mind.", false, 3, 1, 1));
    skillList.add(new Skill("Escape", 5, "Countered by Chase, and cannot be used if under " +
        "the effects of Nail, have a Mangled leg or Tie Bonds. Allows the player to " +
        "declare Escape while spending 5 Mind and take 20 paces from combat, during " +
        "which time the player cannot be targeted or pursued.", false, 3, 1, 1));
    skillList.add(new Skill("Escape Bonds", 5, "Counters Tie Bonds. Each crafts level of the " +
        "binding item increases Mind expenditure by 5.", false, 3, 1, 1));
    skillList.add(new Skill("Fade In A Crowd", 5, "Countered by Alert. Requires at least 6 " +
        "other people in a four foot radius while the player is unhindered and does not " +
        "interact with the environment to remain in effect. Allows player to travel " +
        "unseen.", false, 3, 1, 1));
    skillList.add(new Skill("Faith Healing", 1, "By spending 5 min. pray, player may place " +
        "both hands on a wounded target and heal the target's wounds. After 5 min. of " +
        "roleplay the target is healed 2 Health for every 1 Mind spent. The player " +
        "healing may not move while using this skill.", false, 3, 1, 1));
    skillList.add(new Skill("Fearful Glare", 5, "Countered by Refuse. Allows player to glare " +
        "at an opponent so effectively while spending 5 Mind and calling FEAR, cannot " +
        "attack me, 5 minutes and pointing at the target.", false, 3, 1, 1));
    skillList.add(new Skill("Feign Death", 1, "Countered by Check Status. Allows player to " +
        "fall to the ground immediately after taking a hit from an opponent, spending 1 " +
        "Mind and roleplaying death. Taking action ends the effect.", false, 3, 1, 1));
    skillList.add(new Skill("First Aide", 0, "Allows player to spend 2 min roleplaying " +
        "stabilizing a target which halts the targets Bleed Out count and/or awaken an " +
        "unconscious target.", false, 3, 1, 1));
    skillList.add(new Skill("Fishing", 5, "Allows user to spend 5 Mind and roleplay for 30 " +
        "min. fishing a natural waterway. After the time Logistics will provide Named " +
        "Consumables, a pole of some kind is required and the player must remain within " +
        "10 paces.", false, 3, 1, 1));
    skillList.add(new Skill("Fix Limb", 5, "Allows player to roleplay fixing a mangled limb " +
        "uninterrupted for 10 min. after which time the effect is removed.", false, 3, 1, 1));
    skillList.add(new Skill("Florentine", 0, "Allows the user to fight with two weapons at " +
        "once, weapons must be of standard size or smaller.", false, 3, 1, 1));
    skillList.add(new Skill("Force Barricade", 1, "Counters Barricade. For every strike " +
        "against a Barricade while spending 1 Mind and declaring Force Barricade a " +
        "crafts level of the Barricade is destroyed.", false, 3, 1, 1));
    skillList.add(new Skill("Forging the Future", 10, "Allows player to take Scrap and build " +
        "large projects called Augments, such as fortifications. Requires player to " +
        "spend 10 Mind and roleplay for 1 hour, 30 min. at a Forge and 30 min. at the " +
        "target structure. After the roleplay Logistics will provide the structure item " +
        "card.", false, 3, 1, 1));
    skillList.add(new Skill("Frightening Force", 10, "Countered by Parry if delivered from " +
        "the front. Strike is terrifying to all that witness it, deals 30 damage for a " +
        "single melee swing.", false, 3, 1, 1));
    skillList.add(new Skill("Guild Member", 0, "Allows player contact with Murder " +
        "Incorporated.", false, 3, 1, 1));
    skillList.add(new Skill("Gun Aficionado", 5, "Countered by Avoid or Bounce. Allows " +
        "player to spend 5 Mind and deal 15 points of damage with a single firearm " +
        "attack.", false, 3, 1, 1));
    skillList.add(new Skill("Head Shrink", 10, "Allows player to remove a temporary " +
        "derangement from a target (not yourself) after spending 10 Mind and 10 min. of " +
        "roleplay. Permanent derangement's may be removed by spending 20 Mind and 30 " +
        "min. of roleplay.", false, 3, 1, 1));
    skillList.add(new Skill("Healthy Feast", 0, "Allows player to prepare more potent Meals.",
        false, 3, 1, 1));
    skillList.add(new Skill("Holy Rites", 0, "Required to be performed by priests of " +
        "accepted faiths.", false, 3, 1, 1));
    skillList.add(new Skill("Hunter's Mark", 15, "Allows player to mark a target for the " +
        "next 10 min. by striking with a white packet. While the effect lasts Chase, " +
        "Alert, and Sniped Shot may be used on the target for 1 Mind.", false, 3, 1, 1));
    skillList.add(new Skill("Improved Armor/Shield", 5, "Allows a character to improve an " +
        "existing armor or shield by 1 crafts level up to crafts level 5.", false, 3, 1, 1));
    skillList.add(new Skill("Improved Pistol/Bow", 5, "Allows a character to improve an " +
        "existing shooter, thrown, bow, javelin by 1 crafts level up to crafts level 5.",
        false, 3, 1, 1));
    skillList.add(new Skill("Improved Weapon", 5, "Allows a character to improve an " +
        "existing weapon by 1 crafts level up to crafts level 5.", false, 3, 1, 1));
    skillList.add(new Skill("Income", 0, "Usable at home game only. Provides a player with " +
        "fixed amount of local currency at check in.", false, 3, 1, 5));
    skillList.add(new Skill("Instruct", 1, "Allows a player to teach a known skill to a " +
        "group of people.", false, 3, 1, 1));
    skillList.add(new Skill("Interfere", 0, "Allows player to declare Interfere! and " +
        "immediately take the damage or effect the target would have taken provided they " +
        "are within arm's reach.", false, 3, 1, 1));
    skillList.add(new Skill("Interrogate", 5, "Countered by Lie. Allows a player to declare " +
        "Interrogate after spending 5 Mind and 5 min. of roleplaying questioning, the " +
        "target is then forced to answer a direct question.", false, 3, 1, 1));
    skillList.add(new Skill("Iron Fists", 5, "Allows player with Brawling skill to no longer " +
        "take damage when blocking.", false, 3, 1, 1));
    skillList.add(new Skill("Knock Down", 5, "Countered by Balance and Avoid. Allows a " +
        "player to step forward with a shield and declare Knock Down against a target " +
        "within melee range.", false, 3, 1, 1));
    skillList.add(new Skill("Knockout", 5, "Countered by Avoid and First Aide. Players that " +
        "make a successful strike to the rear torso and declaring Knockout, out cold 5 " +
        "minutes or until wounded! render the target unconscious.", false, 3, 1, 1));
    skillList.add(new Skill("Lie", 5, "Counters Interrogate and certain pscionic Skills. " +
        "Allows a player to spend 5 Mind to tell an undetectable Lie.", false, 3, 1, 1));
    skillList.add(new Skill("Literacy", 0, "Allows player the basic skills to read and write.",
        false, 3, 1, 1));
    skillList.add(new Skill("Lore", 0, "Shows that a player has an understanding of a subject."
        , false, 3, 1, 1));
    skillList.add(new Skill("Mangle Limb", 5, "Countered by Parry if struck from the front. " +
        "Allows player to strike the target limb after declaring Mangle Limb!, if " +
        "successful the limb is rendered useless.", false, 3, 1, 1));
    skillList.add(new Skill("Master Craftsman", 0, "Allows player to improve crafts level 5 " +
        "weapons and armor to crafts level 10.", false, 3, 1, 1));
    skillList.add(new Skill("Medical Assistance", 1, "Allows player to heal a target at a " +
        "rate of 3 Health per 1 Mind spent, 5 min. of uninterrupted roleplay is required."
        , false, 3, 1, 1));
    skillList.add(new Skill("Medical Genius", 1, "Allows player to heal a target at a " +
        "rate of 10 Health per 1 Mind spent, 5 min. of uninterrupted roleplay is required."
        , false, 3, 1, 1));
    skillList.add(new Skill("Melee Weapon Expert", 5, "Allows a player to add 2 damage per 5 " +
        "Mind spend up to a maximum of 20 damage. Requires 30 seconds of preparation " +
        "before activating, effect lasts 5 min.", false, 3, 1, 1));
    skillList.add(new Skill("Melee Weapon Large", 0, "Allows player to wield a melee weapon " +
        "no smaller than 36 in. and no larger than 53 in.", false, 3, 1, 1));
    skillList.add(new Skill("Melee Weapon Small", 0, "Allows player to wield a melee weapon " +
        "no smaller than 12 in. and no larger than 21 in.", false, 3, 1, 1));
    skillList.add(new Skill("Melee Weapon Standard", 0, "Allows player to wield a melee " +
        "weapon no smaller than 18 in. and no larger than 39 in.", false, 3, 1, 1));
    skillList.add(new Skill("Melee Weapon Two-Handed", 0, "Allows player to wield a melee " +
        "weapon no smaller than 50 in. and no larger than 63 in.", false, 3, 1, 1));
    skillList.add(new Skill("Mind Resistance", 10, "Counters psionic abilities or attacks, " +
        "and Torture. Not usable during Bleed Out.", false, 3, 1, 1));
    skillList.add(new Skill("Murder Most Foul", 10, "Allows player to call Murder! and make " +
        "a successful melee strike while spending 10 Mind, the strike does 10 damage. " +
        "If the target skips Bleed Out if the strike begins the process.", false, 3, 1, 1));
    skillList.add(new Skill("Nail", 5, "Countered by Avoid and Bounce. Allows player to " +
        "impale a target using a Bow or Javelin, if successful the target is rendered " +
        "immobile for 5 min.", false, 3, 1, 1));
    skillList.add(new Skill("Nerve Punch", 5, "Countered by Parry if strike was made from " +
        "the front. Successful strikes cause target to drop items held in both hands."
        , false, 3, 1, 1));
    skillList.add(new Skill("Parry", 5, "Counters all melee and brawling strikes delivered " +
        "from the front.", false, 3, 1, 1));
    skillList.add(new Skill("Patch Job", 1, "Allows player to quickly repair Broken, " +
        "Destroyed or Melted items without a Workbench. By spending 1 Mind and 30 " +
        "seconds the crafts level is reduced by 1 and repaired.", false, 3, 1, 1));
    skillList.add(new Skill("Pick Pockets", 1, "Allows player to steal a held item from a " +
        "target, must register attempt with ST staff.", false, 3, 1, 1));
    skillList.add(new Skill("Pistol Whip", 0, "Allows player to make an effective melee " +
        "strike with a firearm. Players carry a small melee weapon to represent this " +
        "ability, only Parry may be used while wielding a melee weapon in this manner.",
        false, 3, 1, 1));
    skillList.add(new Skill("Pray For Justice", 5, "Countered by Avoid if used as a ranged " +
        "attack. Causes the time for Faith Healing to be reduced to 2 min. allows the " +
        "player to call for vengeance from their deity causing 10 Blessed damage or to " +
        "Bless a weapon adding 10 Blessed (type) damage for the next 3 strikes."
        , false, 3, 1, 1));
    skillList.add(new Skill("Prepare Meal", 5, "Allows player to create Meals from Herbs and " +
        "Produce by spending 5 Mind and 30 min of roleplay at a Kitchen.", false, 3, 1, 1));
    skillList.add(new Skill("Psionic Skill: Advanced", 15, "Defended against with Mind Resist. " +
        "Allows a Psionicist to permanently add one Advanced skill from the Psionics " +
        "Skill List.", false, 3, 1, 1));
    skillList.add(new Skill("Psionic Skill: Basic", 5, "Defended against with Mind Resist. " +
        "Allows a Psionicist to permanently add one Basic skill from the Psionics Skill " +
        "List.", false, 3, 1, 1));
    skillList.add(new Skill("Psionic Skill: Intermediate", 10, "Defended against with Mind Resist. " +
        "Allows a Psionicist to permanently add one Intermediate skill from the Psionics " +
        "Skill List.", false, 3, 1, 1));
    skillList.add(new Skill("Refuse", 1, "Counters Beg for Life, Challenge, Charisma, " +
        "Entertain, and Fear. Does not protect against psionic powers.", false, 3, 1, 1));
    skillList.add(new Skill("Repair", 1, "Allows player to repair a Broken, Destroyed, or " +
        "Melted item, also restores lost Armor Points to armor. Spend 1 Mind and 10 min " +
        "per Crafts Level at a Workbench roleplaying repairing the item.", false, 3, 1, 1));
    skillList.add(new Skill("Rescue", 5, "Countered by Chase. Cannot use this skill while " +
        "under the effects of Nail, Mangled Leg, or Tie Bonds. Must have one none " +
        "Mangled Arm. Allows player to declare Rescue! and grab another player and take " +
        "10 paces away from combat.", false, 3, 1, 1));
    skillList.add(new Skill("Sailing", 0, "Represents access to shipping lanes and ports of " +
        "call, allowing player to swap materials for cash and operate boats."
        , false, 3, 1, 1));
    skillList.add(new Skill("Scatter Shot", 5, "Countered by Avoid and Bounce. Allows player " +
        "to strike up to 6 targets with single ranged attack.", false, 3, 1, 1));
    skillList.add(new Skill("SCIENCE!", 1, "Represents greater understanding of scientific " +
        "reasoning.", false, 3, 1, 1));
    skillList.add(new Skill("Scrounge", 1, "Allows player to pick up Scrounge cards from the " +
        "ground.", false, 3, 1, 1));
    skillList.add(new Skill("Sever", 5, "Countered by Parry if strike is delivered from the " +
        "front. By declaring Sever, spending 5 Mind and landing a successful melee " +
        "strike 15 damage is dealt.", false, 3, 1, 1));
    skillList.add(new Skill("Shield", 0, "Allows player to wield a shield.", false, 3, 1, 1));
    skillList.add(new Skill("Smelt", 1, "Allows player to break down Scrap into components."
        , false, 3, 1, 1));
    skillList.add(new Skill("Sniped Shot", 5, "Countered by Avoid and Bounce. Allows player " +
        "to make a single ranged shot without the need to actually make the attack."
        , false, 3, 1, 1));
    skillList.add(new Skill("Society Membership", 1, "Allows player to become a member of a " +
        "closed group.", false, 3, 1, 1));
    skillList.add(new Skill("Take Down", 5, "Countered by Balance and Parry. Allows player " +
        "to make a successful Brawling or 2-Handed strike which knocks the target off " +
        "their feet.", false, 3, 1, 1));
    skillList.add(new Skill("Teach", 0, "Allows player to teach a known Skill or Profession " +
        "to a single student. Requires 5 min of roleplay per experience point the " +
        "student spends to a maximum of 30 min.", false, 3, 1, 1));
    skillList.add(new Skill("Throwing", 0, "Allows player to use throwing weapons under 12 " +
        "in. in size.", false, 3, 1, 1));
    skillList.add(new Skill("Throwing Javelins", 0, "Allows player to use throwing javelins " +
        "between 12 and 50 in. in size.", false, 3, 1, 1));
    skillList.add(new Skill("Tie Bonds", 1, "Countered by Escape Bonds. Allows player to tie " +
        "a bond on willing, Bleeding Out or unconscious targets.", false, 3, 1, 1));
    skillList.add(new Skill("Torture", 5, "Countered by Mind Resist. Allows player to " +
        "forcefully extract information from a target, 10 min of roleplaying is required " +
        "after which the target must answer a single question truthfully and completely."
        , false, 3, 1, 1));
    skillList.add(new Skill("Trade Ties", 0, "Represents access to bartering connections, " +
        "allowing player to swap certain resources.", false, 3, 1, 1));
    skillList.add(new Skill("Transcribe", 5, "Allows player to copy Blueprint, Plan, Recipe, " +
        "or other single page document by spending 5 Mind and 30 min. roleplay."
        , false, 3, 1, 1));
    skillList.add(new Skill("Trap Making", 2, "Allows player to take Scrap and build various " +
        "Traps. Requires 2 Mind and 20 min roleplaying at a Workbench.", false, 3, 1, 1));
    skillList.add(new Skill("Unlock", 1, "Allows player to bypass Lock Gizmos. Requires 1 " +
        "Mind per crafts level, and 1 min. plus an additional minute per crafts level " +
        "roleplay time.", false, 3, 1, 1));
    skillList.add(new Skill("Vanish", 5, "Countered by Alert. Allows player to become " +
        "invisible if they have 80% environmental cover and are unobserved while using " +
        "the Skill.", false, 3, 1, 1));
    skillList.add(new Skill("Weld", 5, "Allows player to combine Scrap into more useful " +
        "components. Requires player to spend 5 Mind and 10 min. roleplaying welding " +
        "materials at a Forge.", false, 3, 1, 1));
    skillList.add(new Skill("Wide Strike", 10, "Countered by Parry. Allows player to spend " +
        "10 Mind and declare Wide Strike and gesture at up to 6 targets within weapon's " +
        "reach that take the damage unless countered. ", false, 3, 1, 1));
  }
}