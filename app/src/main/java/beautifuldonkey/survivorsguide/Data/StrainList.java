package beautifuldonkey.survivorsguide.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * provides static list of strains and accessor functions
 * Created by Jed on 6/16/2015.
 */
public class StrainList {

  private static List<Strain> strainList = new ArrayList<>();

  public static List<Strain> getStrainList() {
    return strainList;
  }

  public static Strain getStrainByName(String name) {
    Strain foundStrain = null;
    for (int i = 0; i < strainList.size(); i++) {
      if (strainList.get(i).getName().equals(name)) {
        foundStrain = strainList.get(i);
        break;
      }
    }
    return foundStrain;
  }

  static {

    strainList.add(new Strain("Bay Walker", 8, 10, 4, "Analyze Creature,Double-Tap,First Aide,Instruct,Literacy,Parry",
        "Bay Walkers are fast learners and quickly pick up new concepts. They know exactly how to push the buttons of all Yorkers. Since they avoided most of the radiation in past generations they suffer double damage from all Toxic/Poison sources. They can never possess the following Professions: Sawbones, Primitive, or Thug."));
    strainList.add(new Strain("Diesel Jock", 10, 10, 3, "Balance,Bolt Action,Forging the Future,Patch Job,Trade Ties,Melee Weapon Standard",
        "With the circles Diesel Jocks travel in they can utilize Trade Ties to swap Herb for Scrap at the same level restrictions. Due to this constantly moving around the Income skill generates currency at two levels less than what they posses. They can never possess the following Professions: Farmer, Politician, or Publican."));
    strainList.add(new Strain("Full Dead", 20, 10, 1, "Big Dig,Check Quality,Income,Lie,Literacy,Torture",
        "Nearly zombies themselves, the Full Dead can eat other humanoids to regain health, and fade into a horde of zombies. They can hear the grave mind and are not impacted by most healing skills and consumed effects. Injected Brews and Faith Healing still help / harm."));
    strainList.add(new Strain("Genjian", 6, 6, 5, "Analyze Creature,Bow,Brawling,Lore: Mon Histories,Melee Weapon Standard,Sailing,Throwing",
        "These creatures are well traveled and have unique social skills as a result, which also benefits them in most forms of combat once an opponent they know the Lore of has been identified. They fear for their immortal soul and take steps to ensure they never server the grave mind, and will also fight to the death for family honor."));
    strainList.add(new Strain("Iron Slave", 7, 4, 4, "Brawling,Carry,Escape Bonds,Iron Fists,Refuse,Rescue,Scrounge",
        "All Iron Slaves have a distinctly red glow to them, can speed up projects for other builds, and start out being able to carry more than other Strains. They cannot ever use the following skills: Cover of Night, Disguise, Fade in a Crowd, or Vanish. They cannot start with the following professions: Caravan Driver, Distiller, Doctor, Gambler, Hook-up, Mad Scientist, Martial Artist, Psionist, Sniper, Spy, or Tinker."));
    strainList.add(new Strain("Lascarian", 10, 5, 5, "Alert,Blind Fighting,Chase,Chop,Force Barricade,Melee Weapon Small,Scrounge,Take Down",
        "Scavengers and survivors by nature, A Lascarian can regain health by consuming the flesh of dead humanoids. They are sensitive to light and cannot ever have the following professions: Charlatan, Entertainer, Gambler, Hook-Up, Merchant, Officer, Politician, or Ring Leader."));
    strainList.add(new Strain("Merican", 13, 10, 2, "Bolt-Action,Brawling,Melee Weapon Large,Melee Weapon Two-Handed,Throwing,Throwing Javelins",
        "Despite being incapable of knowing when they are intruding, Mericans know how to really enjoy a party with other Mericans in attendance. They can never have the following professions: Martial Artist, or Spy"));
    strainList.add(new Strain("Nation Of Accensor", 8, 8, 5, "Building Tomorrow,Challenge,Faith Healing,First Aide,Mind Resistance,Patch Job",
        "Capable of deep meditation that refuels themselves, Accensorites can also enter game baptized into a major faith. They adhere to a strict moral code and will put the well being of others from their faith ahead of their own."));
    strainList.add(new Strain("Natural One", 10, 6, 4, "Cure Toxins,Melee Weapon Large,Melee Weapon Small,Melee Weapon Standard,Melee Weapon Two-Handed,Throwing,Throwing Javelins",
        "Incredibly skilled warriors that deal extra damage with most weapon types, though all ranged skills that require technology are more difficult to learn. Anyone that does not belong to their tribal structure is not trusted. Can not start with the following professions: Mad Scientist, Engineer, or Gun Slinger"));
    strainList.add(new Strain("Pure Blood", 6, 12, 3, "Backstab,Bolt-Action,Charisma,Cheat,Check Value,Income,Literacy",
        "Pure Bloods can generate extra income. They are weak to radiation and have to pay extra for Charisma or Refuse (used against Charisma from another Pure Blood) cost double. "));
    strainList.add(new Strain("Reclaimer", 8, 13, 2, "Balance,Carry,Charge,Melee Weapon Standard,Hunters Mark,Avoid",
        "Along with the Skills available to their Strain, Reclaimers can also avoid Sunder or Mangle Limb. However they have trouble opening up to outsiders which causes Charisma and Entertain to cost extra when targeting non-Reclaimers"));
    strainList.add(new Strain("The Red Star", 6, 6, 6, "Avoid,Barricade,Bomb Awareness,Brewing,Fearful Glare,Frightening Force,Melee Weapon Large",
        "Members of the Red Star cells will not betray each other, regardless of skills used against them or death. They cannot posses currency and will not charge for services. They may not have the following professions: Caravan Driver, Charlatan, Entertainer, Gambler, or Priest. Additionally they can not benefit from faith powered Skills."));
    strainList.add(new Strain("Remnant", 5, 5, 6, "No Strain Skills",
        "Start with two professions instead of one but have no strain skills available. They must maintain membership with a faith or lose access to their second profession."));
    strainList.add(new Strain("Retrograde", 10, 10, 4, "Barricade,Cover of Night,Disguise,Escape Bonds,Feign Death,Melee Weapon Standard,Scrounge",""));
    strainList.add(new Strain("Rover", 8, 8, 4, "Bartender's Tongue,Check Your Sleeves,Head Shrink,Melee Weapon Small,Refuse,Scrounge",""));
    strainList.add(new Strain("Salt Wise", 13, 8, 3, "Sailing,Fishing,Lore: Aquatic,Melee Weapon Small,Guild Membership,Lie,Escape Bonds",""));
    strainList.add(new Strain("Semper Mort", 10, 10, 3, "Brawling,Charisma,Chase,Iron Fists,Nerve Punch,Tie Binds",""));
    strainList.add(new Strain("Solestros", 6, 6, 4, "Income,Deep Pockets,Literacy,Charisma,Balance,Melee Weapon Standard,Refuse",""));
    strainList.add(new Strain("Unborn of Teixiptla", 4, 4, 7, "Melee Weapon Two-Handed,Psionic Basic Skill,Throwing Javelins",""));
    strainList.add(new Strain("Vegasian", 5, 10, 5, "Backstab,Black Market Connections,Cheat,Entertain,Lie,Literacy",""));
    strainList.add(new Strain("Yorker", 15, 5, 4, "Barricade,Bomb Awareness,Chase,Entertain,Interfere,Melee Weapon Standard",""));
  }
}
