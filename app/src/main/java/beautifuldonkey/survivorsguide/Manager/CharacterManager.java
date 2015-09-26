package beautifuldonkey.survivorsguide.Manager;

import android.content.Context;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import beautifuldonkey.survivorsguide.Data.PlayerCharacter;
import beautifuldonkey.survivorsguide.Data.Profession;
import beautifuldonkey.survivorsguide.Data.Skill;
import beautifuldonkey.survivorsguide.Data.SkillList;
import beautifuldonkey.survivorsguide.Data.Strain;



/**
 * Manager for common character functions
 * Created by jaw_m on 8/4/2015.
 */
public class CharacterManager {

    public static List<Skill> updateAvailableSkillList(Profession primeProfession, Profession secondProfession, Profession thirdProfession, Strain charStrain){

        Log.d("CHARMNGER", "BEGIN UPDATE AVAIL SKILL LIST");
        List<Skill> incProfSkills;
        List<Skill> incSecondProfSkills;
        List<Skill> incThirdProfSkills;
        List<Skill> incStrainSkills = new ArrayList<>();
        List<Skill> allProfSkills = new ArrayList<>();
        List<Skill> newDisplayedSkills = new ArrayList<>();

        if(charStrain!=null){
            incStrainSkills = SkillList.getSkillsByName(charStrain.getSkills());
        }
        if (primeProfession!=null){
            incProfSkills = SkillList.getSkillsByName(primeProfession.getSkills());
            allProfSkills.addAll(incProfSkills);
        }
        if(secondProfession!=null){
            incSecondProfSkills = SkillList.getSkillsByName(secondProfession.getSkills());
            allProfSkills.addAll(incSecondProfSkills);
        }
        if(thirdProfession!=null){
            incThirdProfSkills = SkillList.getSkillsByName(thirdProfession.getSkills());
            allProfSkills.addAll(incThirdProfSkills);
        }
        Log.d("CHARMNGER", "SET STRAIN & PROFS");
        for(int i=0; i<incStrainSkills.size(); i++){
            for(int k=0; k<allProfSkills.size(); k++){
                if(incStrainSkills.get(i).getName().equals(allProfSkills.get(k).getName())){
                    allProfSkills.remove(k);
                }
            }
        }
        Log.d("CHARMNGER", "COMPARED STRAIN SKILLS TO PROF SKILLS");
        List<Skill> skillsToRemove = new ArrayList<>();
        for(int i=0; i<allProfSkills.size()-1; i++){
            for (int j=i+1; j<allProfSkills.size(); j++){
                if(allProfSkills.get(i).getName().equals(allProfSkills.get(j).getName())){
                    if(allProfSkills.get(i).getBuildCost()>allProfSkills.get(j).getBuildCost()){
                        allProfSkills.get(i).setBuildCost(allProfSkills.get(j).getBuildCost());
                    }
                    skillsToRemove.add(allProfSkills.get(j));
                    break;
                }
            }
        }
        if(skillsToRemove.size()>0){
            allProfSkills.removeAll(skillsToRemove);
        }

        Log.d("CHARMNGER", "COMPARED PROF SKILLS TO SELF");
        if(incStrainSkills.size()>0){
            newDisplayedSkills.addAll(incStrainSkills);
        }

        if(allProfSkills.size()>0){
            newDisplayedSkills.addAll(allProfSkills);
        }

        return newDisplayedSkills;
    }

    public static boolean saveCharacter (PlayerCharacter myCharacter, Context context){

        boolean saveSuccess = false;
        JSONArray data = new JSONArray();
        JSONObject character;
        String characterName = myCharacter.getName();

        character = new JSONObject();
        try {
            character.put("name", characterName);
            character.put("body", myCharacter.getHealth());
            character.put("mind", myCharacter.getMind());
            character.put("strain", myCharacter.getStrain());
            character.put("professions", myCharacter.getProfessions());
            character.put("profSkills", myCharacter.getProfSkills());
            character.put("strainSkills", myCharacter.getStrainSkills());
            data.put(character);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String text = data.toString();

        try {
            FileOutputStream fos = context.openFileOutput(characterName, android.content.Context.MODE_PRIVATE);
            fos.write(text.getBytes());
            fos.close();
            saveSuccess = true;
            Log.d("FILEWRITTEN", "File written to local storage!\n" + data.toString());
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return saveSuccess;
    }

    public static PlayerCharacter loadCharacter (int position, Context context){
        PlayerCharacter characterToLoad = null;

        try {
            String[] files = context.fileList();
            FileInputStream fis = context.openFileInput(files[position]);
            BufferedInputStream bis = new BufferedInputStream(fis);
            StringBuffer b = new StringBuffer();
            Log.d("READCHAR", "file opened & buffers created");
            while (bis.available() != 0) {
                char c = (char) bis.read();
                b.append(c);
            }
            bis.close();
            fis.close();
            Log.d("READCHAR", "buffers closed");

            JSONArray data = new JSONArray(b.toString());

            Log.d("READCHAR", "building string");
            StringBuffer charBuffer = new StringBuffer();
            String charName = "";
            String charStrain = "";
            String charProfession = "";
            String charInfection = "";
            String charBody = "";
            String charMind = "";
            String charStrainSkills = "";
            String charProfSkills = "";
            for (int i = 0; i < data.length(); i++) {

                charName = data.getJSONObject(i).getString("name");
//                charInfection = data.getJSONObject(i).getString("infection");
//                charBody = data.getJSONObject(i).getString("body");
//                charMind = data.getJSONObject(i).getString("mind");
//                charStrain = data.getJSONObject(i).getString("strain");
//                charProfession = data.getJSONObject(i).getString("professions");
            }
            Log.d("READCHAR", "built string now building character");

            characterToLoad = new PlayerCharacter(charName, charBody, charMind,
                    charStrain, charInfection, charProfession, charProfSkills, charStrainSkills);

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return characterToLoad;
    }
}
