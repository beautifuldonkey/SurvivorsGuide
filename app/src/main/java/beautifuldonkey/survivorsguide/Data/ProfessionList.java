package beautifuldonkey.survivorsguide.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jed on 6/19/2015.
 */
public class ProfessionList {

    private static List<Profession> professionList = new ArrayList();

    public static List<Profession> getProfessionList(){ return professionList;}

    static{
        professionList.add(new Profession("Soldier", "Melee badass", "Avoid,Break Shield,Charge,Double-Tap,Florentine,Force Barricade,Interfere,Melee Weapon Expert,Melee Weapon Large,Melee Weapon Standard,Nail,Sever,Shield,Throwing-Javelins", "N/A"));
        professionList.add(new Profession("Gaurd", "Melee badass", "Barricade,Blind Fighting,Bounce,Break Shield,Break Weapon,Carry,Fearful Glare,Force Barricade,Interfere,Knock Down,Mangle Limb,Melee Weapon Standard,Parry,Shield,Wide Strike", "N/A"));
    }
}
