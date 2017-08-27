package beautifuldonkey.survivorsguide;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import beautifuldonkey.survivorsguide.Data.PlayerCharacter;
import beautifuldonkey.survivorsguide.Data.Profession;
import beautifuldonkey.survivorsguide.Data.ProfessionList;
import beautifuldonkey.survivorsguide.Data.SgConstants;
import beautifuldonkey.survivorsguide.Data.Skill;
import beautifuldonkey.survivorsguide.Data.SkillList;
import beautifuldonkey.survivorsguide.Data.Strain;
import beautifuldonkey.survivorsguide.Data.StrainList;
import beautifuldonkey.survivorsguide.Manager.AdapterManager;
import beautifuldonkey.survivorsguide.Manager.ButtonManager;
import beautifuldonkey.survivorsguide.Manager.CharacterManager;

public class CharacterEditExistingActivity extends AppCompatActivity {

  ArrayAdapter<Skill> selectedSkillAdapter;
  ArrayAdapter<Skill> availSkillAdapter;
  List<Skill> selectedSkills;
  List<Skill> availableSkills;
  List<Profession> charProfs;
  TextView charMind;
  TextView charBody;
  TextView charProfsText;
  TextView charBuild;
  TextView charInfection;
  PlayerCharacter charToEdit;
  Profession firstProf;
  Profession secondProf;
  Profession thirdProf;
  Strain charStrain;
  Integer spentBuild;
  Context context;
  List<Profession> professions;
  String[] profNames;
  String[] profNamesWithPlaceholder;

  ButtonManager btnMgr;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_character_edit_existing);
    context = getApplicationContext();
    charToEdit = getIntent().getParcelableExtra(SgConstants.INTENT_EDIT_CHAR);
    btnMgr = new ButtonManager();

    String[] existingProfessions = new String[2];
    String existingProfessionsString = "";

    for(int i=0; i<charToEdit.getProfessions().size()-1; i++){
      if(charToEdit.getProfessions().get(i) != null && charToEdit.getProfessions().get(i).getName() != null){
        existingProfessionsString += charToEdit.getProfessions().get(i).getName() + ", ";
        existingProfessions[i] = charToEdit.getProfessions().get(i).getName();
      }
    }

    firstProf = charToEdit.getProfessions().get(0);

    if(charToEdit.getProfessions().size() > 1){
      secondProf = charToEdit.getProfessions().get(1);
    }

    if(charToEdit.getProfessions().size() > 2){
      thirdProf = charToEdit.getProfessions().get(2);
    }

    spentBuild = Integer.valueOf(charToEdit.getRequiredBuild());

    TextView charName = (TextView) findViewById(R.id.characterName);
    charName.setText(charToEdit.getName());

    charStrain = StrainList.getStrainByName(charToEdit.getStrain());
    TextView charStrainText = (TextView) findViewById(R.id.characterStrain);
    charStrainText.setText(charToEdit.getStrain());

    charProfsText = (TextView) findViewById(R.id.characterProfessions);
    charProfsText.setText(existingProfessionsString);

    TextView charBuildLabel = (TextView) findViewById(R.id.newCharacterBuildLabel);
    charBuildLabel.setText("Build Req:");

    charBuild = (TextView) findViewById(R.id.newCharacterBuild);
    charBuild.setText(String.valueOf(spentBuild));

    charInfection = (TextView) findViewById(R.id.newCharacterInfection);
    charInfection.setText(charToEdit.getInfection());

    charBody = (TextView) findViewById(R.id.newCharacterBody);
    charBody.setText(charToEdit.getHealth());

    charMind = (TextView) findViewById(R.id.newCharacterMind);
    charMind.setText(charToEdit.getMind());

    selectedSkills = charToEdit.getSelectedSkills();
    charProfs = charToEdit.getProfessions();

    availableSkills = CharacterManager.updateAvailableSkillList(
        charProfs.get(0),
        charProfs.size() > 1 ? charProfs.get(1) : null,
        charProfs.size() > 2 ? charProfs.get(2) : null,
        charStrain);

    setupButtons();

    final ListView displayedSkills = (ListView) findViewById(R.id.selectedSkills);
    selectedSkillAdapter = AdapterManager.getCharacterSkillArrayAdapter(context, selectedSkills);
    displayedSkills.setAdapter(selectedSkillAdapter);
    displayedSkills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Skill skillToRemove = selectedSkills.get(position);
        if (skillToRemove.getCurrRank() == 1) {
          selectedSkills.remove(position);
        } else {
          skillToRemove.setCurrRank(skillToRemove.getCurrRank() - 1);
        }
        selectedSkillAdapter.notifyDataSetChanged();
        spentBuild -= skillToRemove.getBuildCost();
        charBuild.setText(String.valueOf(spentBuild));
      }
    });

    final Spinner availSkills = (Spinner) findViewById(R.id.availableSkills);
    availSkillAdapter = AdapterManager.getCharacterSkillArrayAdapter(context, availableSkills);
    availSkills.setAdapter(availSkillAdapter);
    availSkills.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Skill skillToAdd = (Skill) availSkills.getItemAtPosition(position);
        if(skillToAdd.getName().equals("Please Select")){
          return;
        }
        if (selectedSkills.contains(skillToAdd)) {
          for (int i = 0; i < selectedSkills.size(); i++) {
            if (selectedSkills.get(i).getName().equals(skillToAdd.getName())) {
              Skill existingSkill = selectedSkills.get(i);
              if (existingSkill.getAvailRank() > existingSkill.getCurrRank()) {
                existingSkill.setCurrRank(existingSkill.getCurrRank() + 1);
              }
            }
          }
        } else {
          selectedSkills.add(skillToAdd);
        }
        spentBuild += skillToAdd.getBuildCost();
        charBuild.setText(String.valueOf(spentBuild));

        if (selectedSkillAdapter == null) {
          selectedSkillAdapter = AdapterManager.getCharacterSkillArrayAdapter(context, selectedSkills);
          displayedSkills.setAdapter(selectedSkillAdapter);
        } else {
          selectedSkillAdapter.notifyDataSetChanged();
        }
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
    });

    charProfsText.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View charProfsPopup = inflater.inflate(R.layout.popup_char_profs, null, false);
        Dialog dialog = new Dialog(CharacterEditExistingActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(charProfsPopup);
        dialog.show();

        int firstProfSelection = 0;
        int secondProfSelection = 0;
        int thirdProfSelection = 0;

        professions = ProfessionList.getProfessionList();
        List<Profession> professionsWithPlaceholder = ProfessionList.getProfessionList();
        Profession emptyProfession = new Profession();
        emptyProfession.setName("Please Select");
        professionsWithPlaceholder.add(0,emptyProfession);
        profNames = new String[professions.size()];
        profNamesWithPlaceholder = new String[professions.size() + 1];
        profNamesWithPlaceholder[0] = "Please Select";
        for (int i = 0; i < professions.size(); i++) {
          if(charProfs.get(0).getName().equals(professions.get(i).getName())){
            firstProfSelection = i;
          }else if(charProfs.get(1) != null && charProfs.get(1).getName().equals(professions.get(i).getName())){
            secondProfSelection = i;
          }else if(charProfs.get(2) != null && charProfs.get(2).getName().equals(professions.get(i).getName())){
            thirdProfSelection = i;
          }
          profNames[i] = professions.get(i).getName();
          profNamesWithPlaceholder[i + 1] = professions.get(i).getName();
        }

        Spinner firstProfSpinner = (Spinner) charProfsPopup.findViewById(R.id.firstProfession);
        ArrayAdapter<Profession> firstProfAdapter = AdapterManager.getSimpleProfessionAdapter(context,professions);
        firstProfSpinner.setAdapter(firstProfAdapter);
        firstProfSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            firstProf = ProfessionList.getProfessionByName(profNames[position]);
            updateProfessionsAndAvailSkills();
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {

          }
        });
        firstProfSpinner.setSelection(firstProfSelection);

        Spinner secondProfSpinner = (Spinner) charProfsPopup.findViewById(R.id.secondProfession);
        ArrayAdapter<Profession> secondProfAdapter = AdapterManager.getSimpleProfessionAdapter(context, professionsWithPlaceholder);
        secondProfSpinner.setAdapter(secondProfAdapter);
        secondProfSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            secondProf = ProfessionList.getProfessionByName(profNamesWithPlaceholder[position+1]);
            updateProfessionsAndAvailSkills();
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {

          }
        });
        secondProfSpinner.setSelection(secondProfSelection);

        Spinner thirdProfSpinner = (Spinner) charProfsPopup.findViewById(R.id.thirdProfession);
        ArrayAdapter<Profession> thirdProfAdapter = AdapterManager.getSimpleProfessionAdapter(context, professionsWithPlaceholder);
        thirdProfSpinner.setAdapter(thirdProfAdapter);
        thirdProfSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            thirdProf = ProfessionList.getProfessionByName(profNamesWithPlaceholder[position+1]);
            updateProfessionsAndAvailSkills();
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {

          }
        });
        thirdProfSpinner.setSelection(thirdProfSelection);

      }
    });
  }

  private void updateProfessionsAndAvailSkills() {
    List<Profession> updatedProfessions = new ArrayList<>();

    updatedProfessions.add(firstProf);
    String updatedProfessionsString = firstProf.getName();
    if (secondProf != null && secondProf.getName() != null && !"Please Select".equals(secondProf.getName())) {
      updatedProfessionsString += ", " + secondProf.getName();
      updatedProfessions.add(secondProf);
    }
    if (thirdProf != null && thirdProf.getName() != null && !"Please Select".equals(thirdProf.getName()) ) {
      updatedProfessionsString += ", " + thirdProf.getName();
      updatedProfessions.add(thirdProf);
    }

    charToEdit.setProfessions(updatedProfessions);
    charProfsText.setText(updatedProfessionsString);

    availableSkills.clear();
    availableSkills = CharacterManager.updateAvailableSkillList(
        firstProf,
        secondProf != null ? secondProf : null,
        thirdProf != null ? thirdProf : null,
        charStrain);

    availSkillAdapter.clear();
    availSkillAdapter.addAll(availableSkills);
    availSkillAdapter.notifyDataSetChanged();
  }

  private void setupButtons() {
    Button btn_subInf = (Button) findViewById(R.id.btn_newCharLessInf);
    btn_subInf.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Integer currentInf = (Integer.parseInt(charInfection.getText().toString()));
        if (currentInf > 0) {
          currentInf = currentInf - 1;
          charInfection.setText(String.valueOf(currentInf));
        }
      }
    });

    btnMgr.characterAddBody(R.id.btn_newCharMoreBody,charBuild,charBody,this,SgConstants.BTN_EDIT_ADD_BODY);
    btnMgr.characterSubtractBody(R.id.btn_newCharLessBody,charBuild,charBody,this,charStrain.getBody(),SgConstants.BTN_EDIT_SUB_BODY);
    btnMgr.characterAddMind(R.id.btn_newCharMoreMind,charBuild,charMind,this,SgConstants.BTN_EDIT_ADD_MIND);
    btnMgr.characterSubtractMind(R.id.btn_newCharLessMind,charBuild,charMind,this,charStrain.getMind(),SgConstants.BTN_EDIT_SUB_MIND);

    Button btn_save = (Button) findViewById(R.id.btn_save);
    btn_save.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String updatedCharSkills = "";
        for (int i = 0; i < selectedSkills.size(); i++) {
          updatedCharSkills += selectedSkills.get(i).getName() + ",";
        }

        charToEdit.setInfection(charInfection.getText().toString());
        charToEdit.setHealth(charBody.getText().toString());
        charToEdit.setMind(charMind.getText().toString());
        int spentBuild = 0;
        for(int i =0; i < selectedSkills.size(); i++){
          spentBuild += selectedSkills.get(i).getBuildCost();
        }
        spentBuild += Integer.valueOf(charBody.getText().toString()) - charStrain.getBody();
        spentBuild += Integer.valueOf(charMind.getText().toString()) - charStrain.getMind();
        charToEdit.setRequiredBuild(String.valueOf(spentBuild));
        btnMgr.handleSaving(context,charToEdit);
      }
    });
  }
}