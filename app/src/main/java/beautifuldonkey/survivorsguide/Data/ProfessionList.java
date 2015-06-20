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
        professionList.add(new Profession("Soldier", "Melee badass", "Parry, Avoid", "N/A"));
        professionList.add(new Profession("Gaurd", "Melee badass", "Parry, Shield", "N/A"));
    }
}
