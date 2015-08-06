package beautifuldonkey.survivorsguide.Manager;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileOutputStream;

import beautifuldonkey.survivorsguide.Data.PlayerCharacter;
import beautifuldonkey.survivorsguide.Data.Skill;

/**
 * Manager for common character functions
 * Created by jaw_m on 8/4/2015.
 */
public class CharacterManager {

    public static boolean saveCharacter (PlayerCharacter myCharacter, Context context){

        boolean saveSuccess = false;
        JSONArray data = new JSONArray();
        JSONObject character;
        String charProfSkills = "";
        String charStrainSkills = "";
        String characterName = myCharacter.getName();
//        for(int i=0; i<selectedSkills.size(); i++){
//            Skill skill = selectedSkills.get(i);
//            if(skill.getIsStrain()){
//                charStrainSkills = skill.getName()+",";
//            }else{
//                charProfSkills = skill.getName()+",";
//            }
//        }

        character = new JSONObject();
        try {
            character.put("name", characterName);
            character.put("body", myCharacter.getHealth());
            character.put("mind", myCharacter.getMind());
            character.put("strain", myCharacter.getStrain());
            character.put("professions", myCharacter.getProfessions());
//            character.put("profSkills", charProfSkills);
//            character.put("strainSkills", charStrainSkills);
            data.put(character);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String text = data.toString();

        try {
            FileOutputStream fos = context.openFileOutput(characterName, context.MODE_PRIVATE);
            fos.write(text.getBytes());
            fos.close();
            saveSuccess = true;
            Log.d("FILEWRITTEN", "File written to local storage!\n" + data.toString());
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return saveSuccess;
    }
}
