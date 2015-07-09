package beautifuldonkey.survivorsguide.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jed on 6/16/2015.
 */
public class StrainList {

    private static List<Strain> strainList = new ArrayList<>();

    public static List<Strain> getStrainList() { return strainList;}

    static{

        strainList.add(new Strain("Bay Walker", 8, 10, 4, "Analyze Creature,Double Tap,First Aide,Instruct,Literacy,Parry"));
        strainList.add(new Strain("Diesel Jock", 10, 10, 3, "Balance, Bolt Action, Forging the Future, Patch Job, Trade Ties, Melee Standard"));
        strainList.add(new Strain("Full Dead", 20, 10, 1, "some Skillz"));
        strainList.add(new Strain("Genjian", 6, 6, 5, "some Skillz"));
        strainList.add(new Strain("Iron Slave", 7, 4, 4, "some Skillz"));
        strainList.add(new Strain("Lacarian", 10, 5, 5, "some Skillz"));
        strainList.add(new Strain("Merican", 13, 10, 2, "some Skillz"));
        strainList.add(new Strain("Nation Of Accensor", 8, 8, 5, "some Skillz"));
        strainList.add(new Strain("Natural One", 10, 6, 4, "some Skillz"));
        strainList.add(new Strain("Pure Blood", 6, 12, 3, "some Skillz"));
        strainList.add(new Strain("Reclaimer", 8, 13, 2, "some Skillz"));
        strainList.add(new Strain("The Red Star", 6, 6, 6, "some Skillz"));
        strainList.add(new Strain("Remnant", 5, 5, 6, "some Skillz"));
        strainList.add(new Strain("Retrograde", 10, 10, 4, "some Skillz"));
        strainList.add(new Strain("Rover", 8, 8, 4, "some Skillz"));
        strainList.add(new Strain("Salt Wise", 13, 8, 3, "some Skillz"));
        strainList.add(new Strain("Semper Mort", 10, 10, 3, "some Skillz"));
        strainList.add(new Strain("Solestor", 6, 6, 4, "some Skillz"));
        strainList.add(new Strain("Unborn of Teixiptla", 4, 4, 7, "some Skillz"));
        strainList.add(new Strain("Vegasian", 5, 10, 5, "some Skillz"));
        strainList.add(new Strain("Yorker", 15, 5, 4, "some Skillz"));
    }
}
