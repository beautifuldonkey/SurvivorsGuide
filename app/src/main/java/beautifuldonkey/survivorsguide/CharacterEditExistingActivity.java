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

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_character_edit_existing);
    context = getApplicationContext();
    charToEdit = getIntent().getParcelableExtra(SgConstants.INTENT_EDIT_CHAR);
//
//    String[] existingProfessions = charToEdit.getProfessions().split(",");
//    firstProf = ProfessionList.getProfessionByName(existingProfessions[0]);
//    secondProf = ProfessionList.getProfessionByName(existingProfessions.length > 1 ? existingProfessions[1] : "");
//    thirdProf = ProfessionList.getProfessionByName(existingProfessions.length > 2 ? existingProfessions[2] : "");
//
//    spentBuild = Integer.valueOf(charToEdit.getRequiredBuild());
//
//    TextView charName = (TextView) findViewById(R.id.characterName);
//    charName.setText(charToEdit.getName());
//
//    charStrain = StrainList.getStrainByName(charToEdit.getStrain());
//    TextView charStrainText = (TextView) findViewById(R.id.characterStrain);
//    charStrainText.setText(charToEdit.getStrain());
//
//    charProfsText = (TextView) findViewById(R.id.characterProfessions);
//    charProfsText.setText(charToEdit.getProfessions());
//
//    TextView charBuildLabel = (TextView) findViewById(R.id.newCharacterBuildLabel);
//    charBuildLabel.setText("Build Req:");
//
//    charBuild = (TextView) findViewById(R.id.newCharacterBuild);
//    charBuild.setText(String.valueOf(spentBuild));
//
//    charInfection = (TextView) findViewById(R.id.newCharacterInfection);
//    charInfection.setText(charToEdit.getInfection());
//
//    charBody = (TextView) findViewById(R.id.newCharacterBody);
//    charBody.setText(charToEdit.getHealth());
//
//    charMind = (TextView) findViewById(R.id.newCharacterMind);
//    charMind.setText(charToEdit.getMind());
//
//    selectedSkills = SkillList.getSkillsByName(charToEdit.getSelectedSkills());
//
//    String[] profs = charToEdit.getProfessions().split(",");
//    charProfs = new ArrayList<>();
//    for (int i = 0; i < profs.length; i++) {
//      charProfs.add(ProfessionList.getProfessionByName(profs[i]));
//    }
//
//    availableSkills = CharacterManager.updateAvailableSkillList(
//        charProfs.get(0),
//        charProfs.size() > 1 ? charProfs.get(1) : null,
//        charProfs.size() > 2 ? charProfs.get(2) : null,
//        charStrain);
//
//    setupButtons();
//
//    final ListView displayedSkills = (ListView) findViewById(R.id.selectedSkills);
//    selectedSkillAdapter = AdapterManager.getCharacterSkillArrayAdapter(context, selectedSkills);
//    displayedSkills.setAdapter(selectedSkillAdapter);
//    displayedSkills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//      @Override
//      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Skill skillToRemove = selectedSkills.get(position);
//        if (skillToRemove.getCurrRank() == 1) {
//          selectedSkills.remove(position);
//        } else {
//          skillToRemove.setCurrRank(skillToRemove.getCurrRank() - 1);
//        }
//        selectedSkillAdapter.notifyDataSetChanged();
//        spentBuild -= skillToRemove.getBuildCost();
//        charBuild.setText(String.valueOf(spentBuild));
//      }
//    });

    final Spinner availSkills = (Spinner) findViewById(R.id.availableSkills);
    availSkillAdapter = AdapterManager.getCharacterSkillArrayAdapter(context, availableSkills);
    availSkills.setAdapter(availSkillAdapter);
    availSkills.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Skill skillToAdd = (Skill) availSkills.getItemAtPosition(position);
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
//          displayedSkills.setAdapter(selectedSkillAdapter);
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

        final List<Profession> professions = ProfessionList.getProfessionList();
        final String[] profNames = new String[professions.size()];
        final String[] profNamesWithPlaceholder = new String[professions.size() + 1];
        profNamesWithPlaceholder[0] = "Please Select";
        for (int i = 0; i < professions.size(); i++) {
          profNames[i] = professions.get(i).getName();
          profNamesWithPlaceholder[i + 1] = professions.get(i).getName();
        }
        final Spinner firstProfSpinner = (Spinner) charProfsPopup.findViewById(R.id.firstProfession);
        ArrayAdapter<String> firstProfAdapter = new ArrayAdapter<>(CharacterEditExistingActivity.this, R.layout.item_simple_spinner, profNames);
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

        Spinner secondProfSpinner = (Spinner) charProfsPopup.findViewById(R.id.secondProfession);
        ArrayAdapter<String> secondProfAdapter = new ArrayAdapter<>(context, R.layout.item_simple_spinner, profNamesWithPlaceholder);
        secondProfSpinner.setAdapter(secondProfAdapter);
        secondProfSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            secondProf = ProfessionList.getProfessionByName(profNamesWithPlaceholder[position]);
            updateProfessionsAndAvailSkills();
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {

          }
        });

        Spinner thirdProfSpinner = (Spinner) charProfsPopup.findViewById(R.id.thirdProfession);
        ArrayAdapter<String> thirdProfAdapter = new ArrayAdapter<>(context, R.layout.item_simple_spinner, profNamesWithPlaceholder);
        thirdProfSpinner.setAdapter(thirdProfAdapter);
        thirdProfSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            thirdProf = ProfessionList.getProfessionByName(profNamesWithPlaceholder[position]);
            updateProfessionsAndAvailSkills();
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {

          }
        });

      }
    });
  }

  private void updateProfessionsAndAvailSkills() {
//    String updatedProfessions = firstProf.getName();
//    if (secondProf != null) {
//      updatedProfessions += "," + secondProf.getName();
//    }
//    if (thirdProf != null) {
//      updatedProfessions += "," + thirdProf.getName();
//    }
//    charToEdit.setProfessions(updatedProfessions);
//
//    availableSkills.clear();
//    availableSkills = CharacterManager.updateAvailableSkillList(
//        firstProf,
//        secondProf != null ? secondProf : null,
//        thirdProf != null ? thirdProf : null,
//        charStrain);
//
//    availSkillAdapter.clear();
//    availSkillAdapter.addAll(availableSkills);
//    availSkillAdapter.notifyDataSetChanged();
//
//    charProfsText.setText(charToEdit.getProfessions());
  }

  private void setupButtons() {
//    Button btn_subInf = (Button) findViewById(R.id.btn_newCharLessInf);
//    btn_subInf.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        Integer currentInf = (Integer.parseInt(charInfection.getText().toString()));
//        if (currentInf > 0) {
//          currentInf = currentInf - 1;
//          charInfection.setText(String.valueOf(currentInf));
//        }
//      }
//    });
//
//    Button btn_addBody = (Button) findViewById(R.id.btn_newCharMoreBody);
//    btn_addBody.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        Integer currentBody = Integer.parseInt(charBody.getText().toString());
//        currentBody = currentBody + 1;
//        charBody.setText(String.valueOf(currentBody));
//        spentBuild += 1;
//        charBuild.setText(String.valueOf(spentBuild));
//      }
//    });
//
//    Button btn_subBody = (Button) findViewById(R.id.btn_newCharLessBody);
//    btn_subBody.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        Integer currentBody = Integer.parseInt(charBody.getText().toString());
//        if (currentBody > charStrain.getBody()) {
//          currentBody = currentBody - 1;
//          charBody.setText(String.valueOf(currentBody));
//          spentBuild -= 1;
//          charBuild.setText(String.valueOf(spentBuild));
//        }
//      }
//    });
//
//    Button btn_addMind = (Button) findViewById(R.id.btn_newCharMoreMind);
//    btn_addMind.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        Integer currentMind = Integer.parseInt(charMind.getText().toString());
//        currentMind = currentMind + 1;
//        charMind.setText(String.valueOf(currentMind));
//        spentBuild += 1;
//        charBuild.setText(String.valueOf(spentBuild));
//      }
//    });
//
//    Button btn_subMind = (Button) findViewById(R.id.btn_newCharLessMind);
//    btn_subMind.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        Integer currentMind = Integer.parseInt(charMind.getText().toString());
//        if (currentMind > charStrain.getMind()) {
//          currentMind = currentMind - 1;
//          charMind.setText(String.valueOf(currentMind));
//          spentBuild -= 1;
//          charBuild.setText(String.valueOf(spentBuild));
//        }
//      }
//    });
//
//    Button btn_save = (Button) findViewById(R.id.btn_save);
//    btn_save.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        String updatedCharSkills = "";
//        for (int i = 0; i < selectedSkills.size(); i++) {
//          updatedCharSkills += selectedSkills.get(i).getName() + ",";
//        }
//
//        charToEdit.setInfection(charInfection.getText().toString());
//        charToEdit.setHealth(charBody.getText().toString());
//        charToEdit.setMind(charMind.getText().toString());
//        charToEdit.setSelectedSkills(updatedCharSkills);
//
//        CharacterManager.saveCharacter(charToEdit, context);
//      }
//    });
  }
}