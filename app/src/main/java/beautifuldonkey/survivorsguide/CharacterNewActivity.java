package beautifuldonkey.survivorsguide;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
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
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import beautifuldonkey.survivorsguide.Data.PlayerCharacter;
import beautifuldonkey.survivorsguide.Data.Profession;
import beautifuldonkey.survivorsguide.Data.ProfessionList;
import beautifuldonkey.survivorsguide.Data.Skill;
import beautifuldonkey.survivorsguide.Data.Strain;
import beautifuldonkey.survivorsguide.Data.StrainList;
import beautifuldonkey.survivorsguide.Manager.CharacterManager;


public class CharacterNewActivity extends AppCompatActivity {

    Profession charProfession;
    Profession secondCharProfession;
    Profession thirdCharProfession;
    Strain charStrain;
    ArrayAdapter<Skill> availSkillAdapter;
    ArrayAdapter<Skill> selectedSkillAdapter;
    String strainSkills = "";
    String profSkills = "";
    String secondProfSkills = "";
    List<Skill> selectedSkills = new ArrayList<>();
    List<Skill> availableSkills = new ArrayList<>();
    Spinner availSkills;
    CheckBox secondProfToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_new);
        final Context context = getApplicationContext();

        final EditText charName = (EditText) findViewById(R.id.characterName);
        charName.setText("Enter character name");
        charName.setTextColor(Color.BLACK);

        final TextView charBuild = (TextView) findViewById(R.id.newCharacterBuild);
        final TextView charInfection = (TextView) findViewById(R.id.newCharacterInfection);
        final TextView charBody = (TextView) findViewById(R.id.newCharacterBody);
        final TextView charMind = (TextView) findViewById(R.id.newCharacterMind);

        Button btn_addBody = (Button) findViewById(R.id.btn_newCharMoreBody);
        btn_addBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer currentBuild = Integer.parseInt(charBuild.getText().toString());
                Integer currentBody = Integer.parseInt(charBody.getText().toString());
                if(currentBuild>0){
                    currentBody = currentBody + 1;
                    charBody.setText(String.valueOf(currentBody));
                    currentBuild = currentBuild-1;
                    charBuild.setText(String.valueOf(currentBuild));
                }
            }
        });

        Button btn_subBody = (Button) findViewById(R.id.btn_newCharLessBody);
        btn_subBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer currentBuild = Integer.parseInt(charBuild.getText().toString());
                Integer currentBody = Integer.parseInt(charBody.getText().toString());
                if(currentBody>charStrain.getBody()){
                    currentBody = currentBody - 1;
                    charBody.setText(String.valueOf(currentBody));
                    currentBuild = currentBuild+1;
                    charBuild.setText(String.valueOf(currentBuild));
                }
            }
        });

        Button btn_addMind = (Button) findViewById(R.id.btn_newCharMoreMind);
        btn_addMind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer currentBuild = Integer.parseInt(charBuild.getText().toString());
                Integer currentMind = Integer.parseInt(charMind.getText().toString());
                if(currentBuild>0){
                    currentMind = currentMind+1;
                    charMind.setText(String.valueOf(currentMind));
                    currentBuild = currentBuild-1;
                    charBuild.setText(String.valueOf(currentBuild));
                }
            }
        });

        Button btn_subMind = (Button) findViewById(R.id.btn_newCharLessMind);
        btn_subMind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer currentBuild = Integer.parseInt(charBuild.getText().toString());
                Integer currentMind = Integer.parseInt(charMind.getText().toString());
                if(currentMind>charStrain.getMind()){
                    currentMind = currentMind-1;
                    charMind.setText(String.valueOf(currentMind));
                    currentBuild = currentBuild+1;
                    charBuild.setText(String.valueOf(currentBuild));
                }
            }
        });

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
                PlayerCharacter newCharacter = new PlayerCharacter("name","health","mind","strain","infection","professions","profSkills","strainSkills", "build");

                String professions = charProfession.getName();
                if(secondProfToggle.isChecked() && !secondCharProfession.getName().isEmpty()){
                    professions = professions + ',' + secondCharProfession.getName();
                }
                if(thirdCharProfession != null && !thirdCharProfession.getName().isEmpty()){
                    professions = professions + ',' + thirdCharProfession.getName();
                }
                newCharacter.setName(charName.getText().toString());
                newCharacter.setInfection(charInfection.getText().toString());
                newCharacter.setHealth(charBody.getText().toString());
                newCharacter.setMind(charMind.getText().toString());
                newCharacter.setStrain(charStrain.getName());
                newCharacter.setProfessions(professions);
                newCharacter.setProfSkills(profSkills);
                newCharacter.setStrainSkills(strainSkills);
                newCharacter.setAvailBuild(charBuild.getText().toString());

                CharacterManager.saveCharacter(newCharacter, context);
            }
        });

        //
        //Strain drop down
        //
        final List<Strain> strains = StrainList.getStrainList();
        String [] strainNames = new String[strains.size()];
        for(int i =0; i<strains.size(); i++){
            strainNames[i] = strains.get(i).getName();
        }
        Spinner strainDropDown = (Spinner) findViewById(R.id.strainDropDown);
        ArrayAdapter<String> strainAdapter = new ArrayAdapter<>(this, R.layout.item_simple_spinner, strainNames);
        strainDropDown.setAdapter(strainAdapter);
        strainDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                charStrain = strains.get(position);
                if(charStrain != null){
                    strainSkills = charStrain.getSkills();
                }
                availableSkills.clear();
                availableSkills = CharacterManager.updateAvailableSkillList(charProfession, secondCharProfession, thirdCharProfession, charStrain);
                availSkillAdapter.clear();
                availSkillAdapter.addAll(availableSkills);
                availSkillAdapter.notifyDataSetChanged();
                charBuild.setText("13");
                charInfection.setText(String.valueOf(charStrain.getInfection()));
                charBody.setText(String.valueOf(charStrain.getBody()));
                charMind.setText(String.valueOf(charStrain.getMind()));
                if(!selectedSkills.isEmpty()){
                    selectedSkills.clear();
                    selectedSkillAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //
        //Profession Drop Down
        //
        final List<Profession> professions = ProfessionList.getProfessionList();
        String[] professionNames = new String[professions.size()];
        for(int i = 0; i<professions.size(); i++){
            professionNames[i] = professions.get(i).getName();
        }
        Spinner profDropDown = (Spinner) findViewById(R.id.professionDropDown);
        ArrayAdapter<String> profAdapter = new ArrayAdapter<>(this, R.layout.item_simple_spinner, professionNames);
        profDropDown.setAdapter(profAdapter);
        profDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                charProfession = professions.get(position);
                charBuild.setText("13");
                if (charProfession != null) {
                    profSkills = charProfession.getSkills();
                }
                availableSkills.clear();
                availableSkills = CharacterManager.updateAvailableSkillList(charProfession, secondCharProfession, thirdCharProfession, charStrain);
                availSkillAdapter.clear();
                availSkillAdapter.addAll(availableSkills);
                availSkillAdapter.notifyDataSetChanged();
                if(!selectedSkills.isEmpty()){
                    selectedSkills.clear();
                    selectedSkillAdapter.notifyDataSetChanged();
                }
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
                if (secondCharProfession != null) {
                    secondProfSkills = secondCharProfession.getSkills();
                }
                availableSkills.clear();
                availableSkills = CharacterManager.updateAvailableSkillList(charProfession, secondCharProfession, thirdCharProfession, charStrain);
                availSkillAdapter.clear();
                availSkillAdapter.addAll(availableSkills);
                availSkillAdapter.notifyDataSetChanged();
                if(!selectedSkills.isEmpty()){
                    charBuild.setText("13");
                    selectedSkills.clear();
                    selectedSkillAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        secondProfToggle = (CheckBox) findViewById(R.id.addSecondProfession);
        secondProfToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int visible = View.INVISIBLE;
                Integer availBuild = Integer.parseInt(charBuild.getText().toString());
                if (isChecked && availBuild >= 10) {
                    availBuild = availBuild - 10;
                    charBuild.setText(String.valueOf(availBuild));
                    visible = View.VISIBLE;
                    if (secondCharProfession != null) {
                        secondProfSkills = secondCharProfession.getSkills();
                    }
                } else if (!isChecked) {
                    //TODO make this not execute when screen loads or find a way to account for the added build
                    availBuild = availBuild + 10;
                    charBuild.setText(String.valueOf(availBuild));
                    secondProfSkills = "";
                    secondCharProfession = null;
                }
                availableSkills.clear();
                availableSkills = CharacterManager.updateAvailableSkillList(charProfession, secondCharProfession, thirdCharProfession, charStrain);
                availSkillAdapter.clear();
                availSkillAdapter.addAll(availableSkills);
                availSkillAdapter.notifyDataSetChanged();
                secondProfDropDown.setVisibility(visible);
            }
        });

        final ListView displayedSkills = (ListView) findViewById(R.id.selectedSkills);
        displayedSkills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Skill skillToRemove = selectedSkills.get(position);
                Integer currentBuild = Integer.parseInt(charBuild.getText().toString());
                if(skillToRemove.getCurrRank()==1){
                    selectedSkills.remove(position);
                }else{
                    skillToRemove.setCurrRank(skillToRemove.getCurrRank()-1);
                }
                selectedSkillAdapter.notifyDataSetChanged();
                currentBuild = currentBuild + skillToRemove.getBuildCost();
                charBuild.setText(String.valueOf(currentBuild));
            }
        });

        availSkills = (Spinner) findViewById(R.id.availableSkills);
        availSkillAdapter = new ArrayAdapter<Skill>(context, R.layout.item_character_skill, R.id.skillName, availableSkills) {

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {

                LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.item_character_skill, null);

                TextView textView = (TextView) view.findViewById(R.id.skillName);
                textView.setTextColor(Color.BLACK);

                TextView textViewChkBoxLabel = (TextView) view.findViewById(R.id.skillStrainLabel);
                textViewChkBoxLabel.setTextColor(Color.BLACK);

                CheckBox checkBoxStrainSkill = (CheckBox) view.findViewById(R.id.isSkillStrain);
                checkBoxStrainSkill.setTextColor(Color.BLACK);

                if(availableSkills.size()>position){
                    textView.setText(availableSkills.get(position).getName());
                    if(availableSkills.get(position).getIsStrain()){
                        checkBoxStrainSkill.setChecked(true);
                    }else{
                        checkBoxStrainSkill.setVisibility(View.INVISIBLE);
                        textViewChkBoxLabel.setText("Build: "+ availableSkills.get(position).getBuildCost());
                    }
                }

                return view;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.item_character_skill, null);

                TextView textView = (TextView) view.findViewById(R.id.skillName);
                textView.setTextColor(Color.BLACK);

                TextView textViewChkBoxLabel = (TextView) view.findViewById(R.id.skillStrainLabel);
                textViewChkBoxLabel.setTextColor(Color.BLACK);

                CheckBox checkBoxStrainSkill = (CheckBox) view.findViewById(R.id.isSkillStrain);
                checkBoxStrainSkill.setTextColor(Color.BLACK);

                if(availableSkills.size()>position){
                    textView.setText(availableSkills.get(position).getName());
                    if(availableSkills.get(position).getIsStrain()){
                        checkBoxStrainSkill.setChecked(true);
                    }else{
                        checkBoxStrainSkill.setVisibility(View.INVISIBLE);
                        textViewChkBoxLabel.setText("Build: "+ availableSkills.get(position).getBuildCost());
                    }
                }

                return view;
            }
        };
        availSkills.setAdapter(availSkillAdapter);
        availSkills.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Skill skillToAdd = (Skill) availSkills.getItemAtPosition(position);
                Integer currentBuild = Integer.parseInt(charBuild.getText().toString());
                if(currentBuild>=skillToAdd.getBuildCost()){
                    if(selectedSkills.contains(skillToAdd)) {
                        for (int i = 0; i < selectedSkills.size(); i++) {
                            if (selectedSkills.get(i).getName().equals(skillToAdd.getName())) {
                                Skill existingSkill = selectedSkills.get(i);
                                if (existingSkill.getAvailRank() > existingSkill.getCurrRank()) {
                                    existingSkill.setCurrRank(existingSkill.getCurrRank() + 1);
                                }
                            }
                        }
                    }else{
                        selectedSkills.add(skillToAdd);
                    }
                    currentBuild = currentBuild-skillToAdd.getBuildCost();
                    charBuild.setText(String.valueOf(currentBuild));
                }

                if(selectedSkillAdapter == null){
                    selectedSkillAdapter = CharacterManager.getSkillArrayAdapter(context,selectedSkills);
                    displayedSkills.setAdapter(selectedSkillAdapter);
                }else{
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
}
