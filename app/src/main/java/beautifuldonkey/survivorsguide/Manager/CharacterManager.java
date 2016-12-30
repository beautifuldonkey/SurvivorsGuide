package beautifuldonkey.survivorsguide.Manager;

import android.content.Context;
import android.util.Log;

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

  public static List<Skill> updateAvailableSkillList(Profession primeProfession, Profession secondProfession, Profession thirdProfession, Strain charStrain) {

    Log.d("CHARMNGER", "BEGIN UPDATE AVAIL SKILL LIST");
    List<Skill> incProfSkills;
    List<Skill> incSecondProfSkills;
    List<Skill> incThirdProfSkills;
    List<Skill> incStrainSkills = new ArrayList<>();
    List<Skill> allProfSkills = new ArrayList<>();
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
    Log.d("CHARMNGER", "SET STRAIN & PROFS");
    for (int i = 0; i < incStrainSkills.size(); i++) {
      for (int k = 0; k < allProfSkills.size(); k++) {
        if (incStrainSkills.get(i).getName().equals(allProfSkills.get(k).getName())) {
          allProfSkills.remove(k);
        }
      }
    }
    Log.d("CHARMNGER", "COMPARED STRAIN SKILLS TO PROF SKILLS");
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

    Log.d("CHARMNGER", "COMPARED PROF SKILLS TO SELF");
    if (incStrainSkills.size() > 0) {
      newDisplayedSkills.addAll(incStrainSkills);
    }

    if (allProfSkills.size() > 0) {
      newDisplayedSkills.addAll(allProfSkills);
    }

    return newDisplayedSkills;
  }

  public static ArrayList<String> getCharacterFiles(Context context) {
    ArrayList<String> charFiles = new ArrayList<>();
    String[] files = context.fileList();
    for (String file : files) {
      if (!file.startsWith("rList") && !"instant-run".equals(file)) {
        charFiles.add(file);
      }
    }
    return charFiles;
  }

  public static boolean saveCharacter(PlayerCharacter myCharacter, Context context) {

    boolean saveSuccess = false;
    JSONArray data = new JSONArray();
    JSONObject character = new JSONObject();
    Gson gson = new Gson();

    String TAG = "SAVE_CHAR";

    Log.d(TAG, "saving character, displaying friendly output:");
    Log.d(TAG, "Name: " + myCharacter.getName());
    Log.d(TAG, "Body: " + myCharacter.getHealth());
    Log.d(TAG, "Mind: " + myCharacter.getMind());
    Log.d(TAG, "Inf: " + myCharacter.getInfection());
    Log.d(TAG, "Strain: " + myCharacter.getStrain());
    Log.d(TAG, "Profs: " + myCharacter.getProfessions());
    Log.d(TAG, "Build: " + myCharacter.getAvailBuild());
    Log.d(TAG, "Skills-----------------------");
    Log.d(TAG, "skills: " + myCharacter.getSelectedSkills());

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
      data.put(character);
    } catch (JSONException e) {
      e.printStackTrace();
    }

    String text = data.toString();

    try {
      FileOutputStream fos = context.openFileOutput(myCharacter.getName(), android.content.Context.MODE_PRIVATE);
      fos.write(text.getBytes());
      fos.close();
      saveSuccess = true;
      Log.d(TAG, "File written to local storage!\n" + data.toString());
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return saveSuccess;
  }

  public static PlayerCharacter loadCharacter(int position, Context context) {
    PlayerCharacter characterToLoad = null;
    String TAG = "LOAD_CHAR";
    Gson gson = new Gson();

    try {
      ArrayList<String> charFiles = getCharacterFiles(context);
      FileInputStream fis = context.openFileInput(charFiles.get(position));
      BufferedInputStream bis = new BufferedInputStream(fis);
      StringBuilder b = new StringBuilder();
      Log.d(TAG, "file opened & buffers created");
      while (bis.available() != 0) {
        char c = (char) bis.read();
        b.append(c);
      }
      bis.close();
      fis.close();
      Log.d(TAG, "buffers closed");

      JSONArray data = new JSONArray(b.toString());

      Log.d(TAG, "building string");
      String charName = "";
      String charStrain = "";
      List<Profession> charProfession = new ArrayList<>();
      String charInfection = "";
      String charBody = "";
      String charMind = "";
      List<Skill> charSkills = new ArrayList<>();

      String charAvailBuild = "";
      String charRequiredBuild = "";

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
      }
      Log.d(TAG, "built string now building character");

      characterToLoad = new PlayerCharacter(charName, charBody, charMind, charStrain,
          charInfection, charProfession, charSkills, charAvailBuild, charRequiredBuild);

      Log.d(TAG, "character built, displaying friendly output:");
      Log.d(TAG, "Name: " + characterToLoad.getName());
      Log.d(TAG, "Body: " + characterToLoad.getHealth());
      Log.d(TAG, "Mind: " + characterToLoad.getMind());
      Log.d(TAG, "Inf: " + characterToLoad.getInfection());
      Log.d(TAG, "Strain: " + characterToLoad.getStrain());
      Log.d(TAG, "Profs: " + characterToLoad.getProfessions());
      Log.d(TAG, "Avail Build: " + characterToLoad.getAvailBuild());
      Log.d(TAG, "Req Build: " + characterToLoad.getRequiredBuild());
      Log.d(TAG, "Skills-----------------------");
      Log.d(TAG, "skills: " + characterToLoad.getSelectedSkills());

    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return characterToLoad;
  }
}
