package beautifuldonkey.survivorsguide.Manager;

import android.content.Context;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import beautifuldonkey.survivorsguide.Data.PlayerCharacter;
import beautifuldonkey.survivorsguide.Data.Skill;
import beautifuldonkey.survivorsguide.R;

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
            int charBody = 0;
            int charMind = 0;
            String charStrainSkills = "";
            String charProfSkills = "";
            for (int i = 0; i < data.length(); i++) {

                charName = data.getJSONObject(i).getString("name");
                //charInfection = data.getJSONObject(i).getInt("infection");
                charBody = data.getJSONObject(i).getInt("body");
                charMind = data.getJSONObject(i).getInt("mind");
                charStrain = data.getJSONObject(i).getString("strain");
                charProfession = data.getJSONObject(i).getString("professions");
            }
            Log.d("READCHAR", "built string now building character");

            characterToLoad = new PlayerCharacter(charName, String.valueOf(charBody), String.valueOf(charMind),
                    charStrain, charInfection, charProfession, charProfSkills, charStrainSkills);

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return characterToLoad;
    }
}
