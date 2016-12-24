package beautifuldonkey.survivorsguide;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import beautifuldonkey.survivorsguide.Data.PlayerCharacter;
import beautifuldonkey.survivorsguide.Data.Profession;
import beautifuldonkey.survivorsguide.Data.ProfessionList;
import beautifuldonkey.survivorsguide.Data.SgConstants;
import beautifuldonkey.survivorsguide.Data.Skill;
import beautifuldonkey.survivorsguide.Data.Strain;
import beautifuldonkey.survivorsguide.Data.StrainList;
import beautifuldonkey.survivorsguide.Manager.AdapterManager;
import beautifuldonkey.survivorsguide.Manager.ButtonManager;
import beautifuldonkey.survivorsguide.Manager.CharacterManager;


public class CharacterNewActivity extends AppCompatActivity {

  Profession charProfession;
  Profession secondCharProfession;
  Profession thirdCharProfession;
  Strain charStrain;
  ArrayAdapter<Skill> availSkillAdapter;
  ArrayAdapter<Skill> selectedSkillAdapter;
  String strainSkills = "";
  String secondProfSkills = "";
  List<Skill> selectedSkills = new ArrayList<>();
  List<Skill> availableSkills = new ArrayList<>();
  Spinner availSkills;
  CheckBox secondProfToggle;
  Integer spentBuild;
  TextView charBuild;
  TextView charInfection;
  TextView charBody;
  TextView charMind;
  List<Strain> strains;
  EditText charName;
  Context context;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_character_new);
    spentBuild = 0;

    context = getApplicationContext();
    charName = (EditText) findViewById(R.id.characterName);
    charBuild = (TextView) findViewById(R.id.newCharacterBuild);
    charInfection = (TextView) findViewById(R.id.newCharacterInfection);
    charBody = (TextView) findViewById(R.id.newCharacterBody);
    charMind = (TextView) findViewById(R.id.newCharacterMind);

    Button btn_subInf = (Button) findViewById(R.id.btn_newCharLessInf);
    btn_subInf.setVisibility(View.INVISIBLE);

    strains = StrainList.getStrainList();
    String[] strainNames = new String[strains.size()];
    for (int i = 0; i < strains.size(); i++) {
      strainNames[i] = strains.get(i).getName();
    }

    setupAttributeButtons();

    Button btn_charNameDone = (Button) findViewById(R.id.btn_charName_done);
    btn_charNameDone.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        InputMethodManager inputManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
      }
    });

    Button btn_save = (Button) findViewById(R.id.btn_save);
    btn_save.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        PlayerCharacter newCharacter = new PlayerCharacter("name", "health", "mind", "strain"
            , "infection", "professions", "strainSkills", "availBuild", "reqBuild");

        String professions = charProfession.getName();
        if (secondProfToggle.isChecked() && !secondCharProfession.getName().isEmpty()) {
          professions = professions + ',' + secondCharProfession.getName();
        }
        if (thirdCharProfession != null && !thirdCharProfession.getName().isEmpty()) {
          professions = professions + ',' + thirdCharProfession.getName();
        }

        String characterSkillsSelected = "";
        for (int i = 0; i < selectedSkills.size(); i++) {
          characterSkillsSelected += selectedSkills.get(i).getName() + ",";
        }
        newCharacter.setName(charName.getText().toString());
        newCharacter.setInfection(charInfection.getText().toString());
        newCharacter.setHealth(charBody.getText().toString());
        newCharacter.setMind(charMind.getText().toString());
        newCharacter.setStrain(charStrain.getName());
        newCharacter.setProfessions(professions);
        newCharacter.setSelectedSkills(characterSkillsSelected);
        newCharacter.setAvailBuild(charBuild.getText().toString());
        newCharacter.setRequiredBuild(String.valueOf(spentBuild));

        if(CharacterManager.saveCharacter(newCharacter, context)){
          Toast.makeText(context,"Character saved.",Toast.LENGTH_SHORT).show();
        }else{
          Toast.makeText(context,"Character save failed.",Toast.LENGTH_SHORT).show();
        }

      }
    });

    //
    //Strain drop down
    //
    Spinner strainDropDown = (Spinner) findViewById(R.id.strainDropDown);
    ArrayAdapter<String> strainAdapter = new ArrayAdapter<>(this, R.layout.item_simple_spinner, strainNames);
    strainDropDown.setAdapter(strainAdapter);
    strainDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        charStrain = strains.get(position);
        updateSkills();
      }
      @Override
      public void onNothingSelected(AdapterView<?> parent) { }
    });

    //
    //Profession Drop Down
    //
    final List<Profession> professions = ProfessionList.getProfessionList();
    String[] professionNames = new String[professions.size()];
    for (int i = 0; i < professions.size(); i++) {
      professionNames[i] = professions.get(i).getName();
    }
    Spinner profDropDown = (Spinner) findViewById(R.id.professionDropDown);
    ArrayAdapter<String> profAdapter = new ArrayAdapter<>(this, R.layout.item_simple_spinner, professionNames);
    profDropDown.setAdapter(profAdapter);
    profDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        charProfession = professions.get(position);
        updateSkills();
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
    });

    //
    // Second Profession Drop Down
    //
    final Spinner secondProfDropDown = (Spinner) findViewById(R.id.secondProfessionDropDown);
    final ArrayAdapter<String> secondProfAdapter = new ArrayAdapter<>(this, R.layout.item_simple_spinner, professionNames);
    secondProfDropDown.setAdapter(secondProfAdapter);
    secondProfDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        secondCharProfession = professions.get(position);
        updateSkills();
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
    });

    secondProfToggle = (CheckBox) findViewById(R.id.addSecondProfession);
    secondProfToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int layoutOption = 0;
        int visible = View.INVISIBLE;
        Integer availBuild = Integer.parseInt(charBuild.getText().toString());
        if (isChecked && availBuild >= 10) {
          availBuild = availBuild - 10;
          charBuild.setText(String.valueOf(availBuild));
          visible = View.VISIBLE;
          if (secondCharProfession != null) {
            secondProfSkills = secondCharProfession.getSkills();
          }
          layoutOption = R.id.secondProfessionDropDown;
        } else if (!isChecked) {
          availBuild = availBuild + 10;
          charBuild.setText(String.valueOf(availBuild));
          secondProfSkills = "";
          secondCharProfession = null;
          layoutOption = R.id.professionDropDown;
        }

        // checking screen size before changing position of second prof dropdown
        if (((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_NORMAL) ||
            (getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_SMALL) {
          RelativeLayout.LayoutParams secondProfParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
          availSkills.setLayoutParams(secondProfParams);
          if(layoutOption!=0){
            secondProfParams.addRule(RelativeLayout.BELOW, layoutOption);
          }
        }
        updateSkills();
        secondProfDropDown.setVisibility(visible);
      }
    });

    final ListView displayedSkills = (ListView) findViewById(R.id.selectedSkills);
    displayedSkills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Skill skillToRemove = selectedSkills.get(position);
        Integer currentBuild = Integer.parseInt(charBuild.getText().toString());
        if (skillToRemove.getCurrRank() == 1) {
          selectedSkills.remove(position);
        } else {
          skillToRemove.setCurrRank(skillToRemove.getCurrRank() - 1);
        }
        selectedSkillAdapter.notifyDataSetChanged();
        currentBuild = currentBuild + skillToRemove.getBuildCost();
        charBuild.setText(String.valueOf(currentBuild));
        spentBuild -= skillToRemove.getBuildCost();
      }
    });

    availSkills = (Spinner) findViewById(R.id.availableSkills);
    availSkillAdapter = AdapterManager.getCharacterSkillArrayAdapter(context, availableSkills);
    availSkills.setAdapter(availSkillAdapter);
    availSkills.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Skill skillToAdd = (Skill) availSkills.getItemAtPosition(position);
        Integer currentBuild = Integer.parseInt(charBuild.getText().toString());
        if (currentBuild >= skillToAdd.getBuildCost()) {
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
          currentBuild = currentBuild - skillToAdd.getBuildCost();
          charBuild.setText(String.valueOf(currentBuild));
          spentBuild += skillToAdd.getBuildCost();
        }

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

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_character_new, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  public void updateSkills(){
    strainSkills = charStrain.getSkills();
    availableSkills.clear();
    availableSkills = CharacterManager.updateAvailableSkillList(charProfession, secondCharProfession, thirdCharProfession, charStrain);
    availSkillAdapter.clear();
    availSkillAdapter.addAll(availableSkills);
    availSkillAdapter.notifyDataSetChanged();
    charBuild.setText(SgConstants.CHARACTER_INITIAL_BUILD);
    charInfection.setText(String.valueOf(charStrain.getInfection()));
    charBody.setText(String.valueOf(charStrain.getBody()));
    charMind.setText(String.valueOf(charStrain.getMind()));
    if (!selectedSkills.isEmpty()) {
      selectedSkills.clear();
      selectedSkillAdapter.notifyDataSetChanged();
    }
    spentBuild = 0;
    setupAttributeButtons();
  }

  /**
   * Sets up buttons used to adjust the character attributes
   */
  public void setupAttributeButtons(){
    ButtonManager btnMgr = new ButtonManager();

    if(charStrain == null){
      charStrain = strains.get(0);
    }

    btnMgr.characterAddBody(R.id.btn_newCharMoreBody,charBuild,charBody,this);
    btnMgr.characterSubtractBody(R.id.btn_newCharLessBody,charBuild,charBody,this,charStrain.getBody());
    btnMgr.characterAddMind(R.id.btn_newCharMoreMind,charBuild,charMind,this);
    btnMgr.characterSubtractMind(R.id.btn_newCharLessMind,charBuild,charMind,this,charStrain.getMind());
  }
}
