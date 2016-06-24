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

    strainList.add(new Strain("Bay Walker", 8, 10, 4, "Analyze Creature,Double Tap,First Aide,Instruct,Literacy,Parry"));
    strainList.add(new Strain("Diesel Jock", 10, 10, 3, "Balance,Bolt Action,Forging the Future,Patch Job,Trade Ties,Melee Weapon Standard"));
    strainList.add(new Strain("Full Dead", 20, 10, 1, "Big Dig,Check Quality,Income,Lie,Literacy,Torture"));
    strainList.add(new Strain("Genjian", 6, 6, 5, "Analyze Creature,Bow,Brawling,Lore: Mon Histories,Melee Weapon Standard,Sailing,Throwing"));
    strainList.add(new Strain("Iron Slave", 7, 4, 4, "Brawling,Carry,Escape Bonds,Iron Fists,Refuse,Rescue,Scrounge"));
    strainList.add(new Strain("Lacarian", 10, 5, 5, "Alert,Blind Fighting,Chase,Chop,Force Barricade,Melee Weapon Small,Scrounge,Take Down"));
    strainList.add(new Strain("Merican", 13, 10, 2, "Bolt-Action,Brawling,Melee Weapon Large,Melee Weapon Two-Handed,Throwing,Throwing Javelins"));
    strainList.add(new Strain("Nation Of Accensor", 8, 8, 5, "Building Tomorrow,Challenge,Faith Healing,First Aide,Mind Resistance,Patch Job"));
    strainList.add(new Strain("Natural One", 10, 6, 4, "Cure Toxins,Melee Weapon Large,Melee Weapon Small,Melee Weapon Standard,Melee Weapon Two-Handed,Throwing,Throwing Javelins"));
    strainList.add(new Strain("Pure Blood", 6, 12, 3, "Backstab,Bolt-Action,Charisma,Cheat,Check Value,Income,Literacy"));
    strainList.add(new Strain("Reclaimer", 8, 13, 2, "Balance,Carry,Charge,Melee Weapon Standard,Hunters Mark,Avoid"));
    strainList.add(new Strain("The Red Star", 6, 6, 6, "Avoid,Barricade,Bomb Awareness,Brewing,Fearful Glare,Frightening Force,Melee Weapon Large"));
    strainList.add(new Strain("Remnant", 5, 5, 6, "No Strain Skills"));
    strainList.add(new Strain("Retrograde", 10, 10, 4, "Barricade,Cover of Night,Disguise,Escape Bonds,Feign Death,Melee Weapon Standard,Scrounge"));
    strainList.add(new Strain("Rover", 8, 8, 4, "Bartender's Tongue,Check Your Sleeves,Head Shrink,Melee Weapon Small,Refuse,Scrounge"));
    strainList.add(new Strain("Salt Wise", 13, 8, 3, "Sailing,Fishing,Lore: Aquatic,Melee Weapon Small,Guild Membership,Lie,Escape Bonds"));
    strainList.add(new Strain("Semper Mort", 10, 10, 3, "Brawling,Charisma,Chase,Iron Fists,Nerve Punch,Tie Binds"));
    strainList.add(new Strain("Solestros", 6, 6, 4, "Income,Deep Pockets,Literacy,Charisma,Balance,Melee Weapon Standard,Refuse"));
    strainList.add(new Strain("Unborn of Teixiptla", 4, 4, 7, "Melee Weapon Two-Handed,Psionic Basic Skill,Throwing Javelins"));
    strainList.add(new Strain("Vegasian", 5, 10, 5, "Backstab,Black Market Connections,Cheat,Entertain,Lie,Literacy"));
    strainList.add(new Strain("Yorker", 15, 5, 4, "Barricade,Bomb Awareness,Chase,Entertain,Interfere,Melee Weapon Standard"));
  }
}
