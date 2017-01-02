package beautifuldonkey.survivorsguide.Manager;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import beautifuldonkey.survivorsguide.Data.PlayerCharacter;
import beautifuldonkey.survivorsguide.Data.SgConstants;

/**
 * Provides character attribute buttons
 */

public class ButtonManager {

  private TextView charBuild;
  private TextView charBody;
  private TextView charMind;
  private int minBody;
  private int minMind;
  private int addMindCondition;
  private int subMindCondition;
  private int addBodyCondition;
  private int subBodyCondition;

  /**
   * Sets up button that will add body to a character
   * @param id id of the button element
   * @param build TextView for character build
   * @param body TextView for character body
   * @param activity Activity setting up the button
   */
  public void characterAddBody(int id, TextView build, TextView body, Activity activity, int incCondition){
    charBuild = build;
    charBody = body;
    addBodyCondition = incCondition;

    Button button = (Button) activity.findViewById(id);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Integer currentBuild = Integer.parseInt(charBuild.getText().toString());
        Integer currentStatValue = Integer.parseInt(charBody.getText().toString());
        if (currentBuild > 0) {
          currentStatValue += 1;
          currentBuild = handleBuild(currentBuild, addBodyCondition);
          charBody.setText(String.valueOf(currentStatValue));
          charBuild.setText(String.valueOf(currentBuild));
        }
      }
    });
  }

  /**
   * Sets up button that will add mind to a character
   * @param id id of the button element
   * @param build TextView for character build
   * @param mind TextView for character mind
   * @param activity Activity setting up the button
   */
  public void characterAddMind(int id, TextView build, TextView mind, Activity activity, int incCondition){
    charBuild = build;
    charMind = mind;
    addMindCondition = incCondition;

    Button button = (Button) activity.findViewById(id);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Integer currentBuild = Integer.parseInt(charBuild.getText().toString());
        Integer currentStatValue = Integer.parseInt(charMind.getText().toString());
        if (currentBuild > 0) {
          currentStatValue += 1;
          currentBuild = handleBuild(currentBuild, addMindCondition);
          charMind.setText(String.valueOf(currentStatValue));
          charBuild.setText(String.valueOf(currentBuild));
        }
      }
    });
  }

  /**
   * Sets up button that will remove body from a character
   * @param id id of the button element
   * @param build TextView for character build
   * @param body TextView for character body
   * @param activity Activity setting up the button
   * @param minVal Minimum value based on character strain
   */
  public void characterSubtractBody(int id, TextView build, TextView body, Activity activity, int minVal, int incCondition){
    charBuild = build;
    charBody = body;
    minBody = minVal;
    subBodyCondition = incCondition;

    Button button = (Button) activity.findViewById(id);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Integer currentBuild = Integer.parseInt(charBuild.getText().toString());
        Integer currentStatValue = Integer.parseInt(charBody.getText().toString());
        if (currentStatValue > minBody) {
          currentStatValue -= 1;
          currentBuild = handleBuild(currentBuild, subBodyCondition);
          charBody.setText(String.valueOf(currentStatValue));
          charBuild.setText(String.valueOf(currentBuild));
        }
      }
    });
  }

  /**
   * Sets up button that will remove mind from a character
   * @param id id of the button element
   * @param build TextView for character build
   * @param mind TextView for character mind
   * @param activity Activity setting up the button
   * @param minVal Minimum value based on character strain
   */
  public void characterSubtractMind(int id, TextView build, TextView mind, Activity activity, int minVal, int incCondition){
    charBuild = build;
    charMind = mind;
    minMind = minVal;
    subMindCondition = incCondition;

    Button button = (Button) activity.findViewById(id);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Integer currentBuild = Integer.parseInt(charBuild.getText().toString());
        Integer currentStatValue = Integer.parseInt(charMind.getText().toString());
        if (currentStatValue > minMind) {
          currentStatValue -= 1;
          currentBuild = handleBuild(currentBuild,subMindCondition);
          charMind.setText(String.valueOf(currentStatValue));
          charBuild.setText(String.valueOf(currentBuild));
        }
      }
    });
  }

  private int handleBuild(int build, int btnCase){
    if (btnCase == SgConstants.BTN_NEW_ADD_BODY || btnCase == SgConstants.BTN_NEW_ADD_MIND) {
      build -= 1;
    } else if(btnCase == SgConstants.BTN_NEW_SUB_BODY || btnCase == SgConstants.BTN_NEW_SUB_MIND){
      build += 1;
    } else if(btnCase == SgConstants.BTN_EDIT_ADD_BODY || btnCase == SgConstants.BTN_EDIT_ADD_MIND){
      build += 1;
    } else if(btnCase == SgConstants.BTN_EDIT_SUB_BODY || btnCase == SgConstants.BTN_EDIT_SUB_MIND){
      build -= 1;
    }

    return build;
  }

  public void characterSave(Context context, PlayerCharacter charObj){
    Boolean isValid = true;

    if(charObj == null){
      isValid = false;
    }

    if(isValid){
      try{
        CharacterManager.saveCharacter(charObj, context);
        Toast.makeText(context,"Character saved.",Toast.LENGTH_SHORT).show();
      }catch (Exception ex){
        Toast.makeText(context,"Character save failed.",Toast.LENGTH_SHORT).show();
      }

    }else{
      //TODO improve error message to call out missing info
      Toast.makeText(context,"Character is not valid.",Toast.LENGTH_SHORT).show();
    }

//    TODO change this to validation, expect a full PlayerCharacter object
//
//
//    String characterSkillsSelected = "";
//    for (int i = 0; i < selectedSkills.size(); i++) {
//      characterSkillsSelected += selectedSkills.get(i).getName() + ",";
//    }
//
//    newCharacter.setInfection(charInfection.getText().toString());
//    newCharacter.setHealth(charBody.getText().toString());
//    newCharacter.setMind(charMind.getText().toString());
//    newCharacter.setStrain(charStrain.getName());
//    newCharacter.setSelectedSkills(characterSkillsSelected);
//    newCharacter.setAvailBuild(charBuild.getText().toString());
//    newCharacter.setRequiredBuild(String.valueOf(spentBuild));

//    if(CharacterManager.saveCharacter(newCharacter, context)){
//
//    }else{
//
//    }
  }

}
