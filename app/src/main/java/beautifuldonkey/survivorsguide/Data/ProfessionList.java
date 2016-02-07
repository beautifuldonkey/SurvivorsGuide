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
        professionList.add(new Profession("Soldier", "Melee badass", "Avoid,Break Shield,Charge,Double-Tap,Florentine,Force Barricade,Interfere,Melee Weapon Expert,Melee Weapon Large,Melee Weapon Standard,Nail,Sever,Shield,Throwing-Javelins", "N/A"
        ,"3,6,6,6,6,6,3,6,3,3,3,3,3,3"));
        professionList.add(new Profession("Gaurd", "Melee badass", "Barricade,Blind Fighting,Bounce,Break Shield,Break Weapon,Carry,Fearful Glare,Force Barricade,Interfere,Knock Down,Mangle Limb,Melee Weapon Standard,Parry,Shield,Wide Strike", "N/A"
        ,"3,6,6,6,6,3,3,3,3,6,6,3,3,3,6"));
    }
}
