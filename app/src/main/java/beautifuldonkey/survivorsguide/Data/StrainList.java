package beautifuldonkey.survivorsguide.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jed on 6/16/2015.
 */
public class StrainList {

    private static List<Strain> strainList = new ArrayList();

    public static List<Strain> getStrainList() { return strainList;}

    static{
        strainList.add(new Strain("Natural One", 10, 6, 4, "some Skillz"));
        strainList.add(new Strain("Bay Walkers", 8, 10, 4, "some Skillz"));
    }
}
