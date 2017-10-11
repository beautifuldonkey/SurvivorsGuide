package beautifuldonkey.survivorsguide.Manager;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import beautifuldonkey.survivorsguide.BuildConfig;
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
  protected static JSONObject character = new JSONObject();

  /**
   * Provides list of available Skills based on Professions / Strains
   * @param primeProfession Profession to fetch associated Skills when evaluating availability
   * @param secondProfession Profession to fetch associated Skills when evaluating availability
   * @param thirdProfession Profession to fetch associated Skills when evaluating availability
   * @param charStrain Strain to fetch associated Skills when evaluating availability
   * @return List of Skills available to a character
   */
  public static List<Skill> updateAvailableSkillList(Profession primeProfession, Profession secondProfession, Profession thirdProfession, Strain charStrain) {

    List<Skill> incProfSkills;
    List<Skill> incSecondProfSkills;
    List<Skill> incThirdProfSkills;
    List<Skill> incStrainSkills = new ArrayList<>();
    List<Skill> allProfSkills = SkillList.getOpenSkills();
    List<Skill> newDisplayedSkills = new ArrayList<>();

    if (charStrain != null) {
      incStrainSkills = SkillList.getSkillsByName(charStrain.getSkills());
    }
    if (primeProfession != null) {
      incProfSkills = SkillList.getSkillsByName(primeProfession.getSkills());
      allProfSkills.addAll(incProfSkills);
    }
    if (secondProfession != null) {
      incSecondProfSkills = SkillList.getSkillsByName(secondProfession.getSkills());
      allProfSkills.addAll(incSecondProfSkills);
    }
    if (thirdProfession != null) {
      incThirdProfSkills = SkillList.getSkillsByName(thirdProfession.getSkills());
      allProfSkills.addAll(incThirdProfSkills);
    }

    for (int i = 0; i < incStrainSkills.size(); i++) {
      for (int k = 0; k < allProfSkills.size(); k++) {
        if (incStrainSkills.get(i).getName().equals(allProfSkills.get(k).getName())) {
          allProfSkills.remove(k);
        }
      }
    }

    List<Skill> skillsToRemove = new ArrayList<>();
    for (int i = 0; i < allProfSkills.size() - 1; i++) {
      for (int j = i + 1; j < allProfSkills.size(); j++) {
        if (allProfSkills.get(i).getName().equals(allProfSkills.get(j).getName())) {
          if (allProfSkills.get(i).getBuildCost() > allProfSkills.get(j).getBuildCost()) {
            allProfSkills.get(i).setBuildCost(allProfSkills.get(j).getBuildCost());
          }
          skillsToRemove.add(allProfSkills.get(j));
          break;
        }
      }
    }

    if (skillsToRemove.size() > 0) {
      allProfSkills.removeAll(skillsToRemove);
    }

    Skill emptySkill = new Skill();
    emptySkill.setName("Please Select");
    emptySkill.setIsStrain(false);
    newDisplayedSkills.add(emptySkill);

    if (incStrainSkills.size() > 0) {
      newDisplayedSkills.addAll(incStrainSkills);
    }

    if (allProfSkills.size() > 0) {
      newDisplayedSkills.addAll(allProfSkills);
    }

    return newDisplayedSkills;
  }
  /**
   * Fetches PlayerCharacter files
   * @param context Current application context
   * @return List of PlayerCharacter files
   */
  public static ArrayList<String> getCharacterFiles(Context context) {
    ArrayList<String> charFiles = new ArrayList<>();
    String[] files = context.fileList();
    if(files != null){
      for (String file : files) {
        if (!file.startsWith("rList") && !"instant-run".equals(file)) {
          charFiles.add(file);
        }
      }
    }
    return charFiles;
  }
  /**
   * Saves PlayerCharacter to file
   * @param myCharacter Character to be saved to a file
   * @param context Current application context
   * @return Truthy evaluation of saving
   */
  protected static boolean saveCharacter(PlayerCharacter myCharacter, Context context) {
    boolean saveSuccess = false;
    JSONArray data = buildCharacterJson(myCharacter);
    String text = data.toString();
    try {
      FileOutputStream fos = context.openFileOutput(myCharacter.getName(), android.content.Context.MODE_PRIVATE);
      fos.write(text.getBytes());
      fos.close();
      saveSuccess = true;
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return saveSuccess;
  }
  /**
   * Coverts PlayerCharacter into json to be saved
   * @param myCharacter PlayerCharacter to be converted for saving
   * @return converted PlayerCharacter as json
   */
  private static JSONArray buildCharacterJson(PlayerCharacter myCharacter){
    JSONArray data = new JSONArray();
    Gson gson = new Gson();
    try {
      character.put("name", myCharacter.getName());
      character.put("infection", myCharacter.getInfection());
      character.put("body", myCharacter.getHealth());
      character.put("mind", myCharacter.getMind());
      character.put("strain", myCharacter.getStrain());
      character.put("professions", gson.toJson( myCharacter.getProfessions()) );
      character.put("selectedSkills", gson.toJson( myCharacter.getSelectedSkills()) );
      character.put("availBuild", myCharacter.getAvailBuild());
      character.put("reqBuild", myCharacter.getRequiredBuild());
      character.put("version", BuildConfig.VERSION_CODE);
      data.put(character);
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return data;
  }
  /**
   * Deletes selected PlayerCharacter file
   * @param context Current application context
   * @param listPos Integer value of the file from file list to delete
   * @return Truthy evaluation of deletion
   */
  public static Boolean deleteCharacter(Context context, int listPos){
    ArrayList<String> charFiles = getCharacterFiles(context);
    return context.deleteFile(charFiles.get(listPos));
  }
  /**
   * Loads selected PlayerCharacter
   * @param position Integer value of the file from file list to load
   * @param context Current application context
   * @return Loaded character
   */
  public static PlayerCharacter loadCharacter(int position, Context context) {
    PlayerCharacter characterToLoad = null;
    String TAG = "LOAD_CHAR";
    Gson gson = new Gson();

    try {
      ArrayList<String> charFiles = getCharacterFiles(context);
      FileInputStream fis = context.openFileInput(charFiles.get(position));
      BufferedInputStream bis = new BufferedInputStream(fis);
      StringBuilder b = new StringBuilder();
      while (bis.available() != 0) {
        char c = (char) bis.read();
        b.append(c);
      }
      bis.close();
      fis.close();

      JSONArray data = new JSONArray(b.toString());

      String charName = "";
      String charStrain = "";
      List<Profession> charProfession = new ArrayList<>();
      String charInfection = "";
      String charBody = "";
      String charMind = "";
      List<Skill> charSkills = new ArrayList<>();
      String charAvailBuild = "";
      String charRequiredBuild = "";
      int version = 0;

      Type typeProfList = new TypeToken<List<Profession>>(){}.getType();
      Type typeSkillList = new TypeToken<List<Skill>>(){}.getType();

      for (int i = 0; i < data.length(); i++) {
        charName = data.getJSONObject(i).getString("name");
        charInfection = data.getJSONObject(i).getString("infection");
        charBody = data.getJSONObject(i).getString("body");
        charMind = data.getJSONObject(i).getString("mind");
        charStrain = data.getJSONObject(i).getString("strain");
        charProfession = gson.fromJson(data.getJSONObject(i).getString("professions"),typeProfList);
        charSkills = gson.fromJson(data.getJSONObject(i).getString("selectedSkills"),typeSkillList);
        charAvailBuild = data.getJSONObject(i).getString("availBuild");
        charRequiredBuild = data.getJSONObject(i).getString("reqBuild");
        if(data.getJSONObject(i).has("version")){
          version = data.getJSONObject(i).getInt("version");
        }
      }

      // Checking that the character is from a current version of the app
      if(version >= 16){
        characterToLoad = new PlayerCharacter(charName, charBody, charMind, charStrain,
            charInfection, charProfession, charSkills, charAvailBuild, charRequiredBuild);
      } else {
        Toast.makeText(context,"Selected character is from an older version of the app and is incompatible.",Toast.LENGTH_SHORT).show();
      }



    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return characterToLoad;
  }
  /**
   * Checks validity of PlayerCharacter
   * @param character PlayerCharacter to be validated
   * @return Truthy evaluation of received PlayerCharacter
   */
  protected static Boolean isCharacterValid(PlayerCharacter character){
    Boolean isValid = true;

    if(character != null){
      if(character.getName() == null || "".equals(character.getName())){
        isValid = false;
      }
      if(character.getStrain() == null || "".equals(character.getStrain())){
        isValid = false;
      }
      if(character.getProfessions() == null || character.getProfessions().size() == 0 || "".equals(character.getProfessions().get(0).getName())){
        isValid = false;
      }
      if(character.getMind() == null || "".equals(character.getMind())){
        isValid = false;
      }
      if(character.getHealth() == null || "".equals(character.getHealth())){
        isValid = false;
      }
    }else{
      isValid = false;
    }

    return isValid;
  }
}
