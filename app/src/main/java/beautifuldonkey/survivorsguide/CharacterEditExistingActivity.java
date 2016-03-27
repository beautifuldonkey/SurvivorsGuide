package beautifuldonkey.survivorsguide;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
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
    TextView charMind;
    TextView charBody;
    Strain charStrain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_edit_existing);
        final Context context = getApplicationContext();

        final PlayerCharacter charToEdit = getIntent().getParcelableExtra(SgConstants.INTENT_EDIT_CHAR);

        TextView charName = (TextView) findViewById(R.id.characterName);
        charName.setText(charToEdit.getName());

        charStrain = StrainList.getStrainByName(charToEdit.getStrain());
        TextView charStrainText = (TextView) findViewById(R.id.characterStrain);
        charStrainText.setText(charToEdit.getStrain());

        TextView charProfsText = (TextView) findViewById(R.id.characterProfessions);
        charProfsText.setText(charToEdit.getProfessions());

        final TextView charBuild = (TextView) findViewById(R.id.newCharacterBuild);
        charBuild.setText(charToEdit.getAvailBuild());

        final TextView charInfection = (TextView) findViewById(R.id.newCharacterInfection);
        charInfection.setText(charToEdit.getInfection());

        charBody = (TextView) findViewById(R.id.newCharacterBody);
        charBody.setText(charToEdit.getHealth());

        charMind = (TextView) findViewById(R.id.newCharacterMind);
        charMind.setText(charToEdit.getMind());

        final List<Skill> selectedSkills = SkillList.getSkillsByName(charToEdit.getSelectedSkills());

        String[] profs = charToEdit.getProfessions().split(",");
        List<Profession> charProfs = new ArrayList<>();
        for(int i=0; i<profs.length; i++){
            charProfs.add(ProfessionList.getProfessionByName(profs[i]));
        }

        List<Skill> availableSkills = CharacterManager.updateAvailableSkillList(
                charProfs.get(0),
                charProfs.size()>1 ? charProfs.get(1) : null,
                charProfs.size()>2 ? charProfs.get(2) : null,
                charStrain);

        Button btn_addBuild = (Button) findViewById(R.id.btn_addCharacterBuild);
        btn_addBuild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer currentBuild = Integer.parseInt(charBuild.getText().toString());
                charBuild.setText(String.valueOf(currentBuild+1));
            }
        });

        Button btn_subInf = (Button) findViewById(R.id.btn_newCharLessInf);
        btn_subInf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer currentInf = (Integer.parseInt(charInfection.getText().toString()));
                if(currentInf > 0){
                    currentInf = currentInf - 1;
                    charInfection.setText(String.valueOf(currentInf));
                }
            }
        });

        Button btn_addBody = (Button) findViewById(R.id.btn_newCharMoreBody);
        btn_addBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer currentBuild = Integer.parseInt(charBuild.getText().toString());
                Integer currentBody = Integer.parseInt(charBody.getText().toString());
                if (currentBuild > 0) {
                    currentBody = currentBody + 1;
                    charBody.setText(String.valueOf(currentBody));
                    currentBuild = currentBuild - 1;
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
                if (currentBody > charStrain.getBody()) {
                    currentBody = currentBody - 1;
                    charBody.setText(String.valueOf(currentBody));
                    currentBuild = currentBuild + 1;
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
                if (currentBuild > 0) {
                    currentMind = currentMind + 1;
                    charMind.setText(String.valueOf(currentMind));
                    currentBuild = currentBuild - 1;
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
                if (currentMind > charStrain.getMind()) {
                    currentMind = currentMind - 1;
                    charMind.setText(String.valueOf(currentMind));
                    currentBuild = currentBuild + 1;
                    charBuild.setText(String.valueOf(currentBuild));
                }
            }
        });

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
                charToEdit.setSelectedSkills(updatedCharSkills);

                CharacterManager.saveCharacter(charToEdit,context);
            }
        });

        final ListView displayedSkills = (ListView) findViewById(R.id.selectedSkills);
        selectedSkillAdapter = AdapterManager.getCharacterSkillArrayAdapter(context, selectedSkills);
        displayedSkills.setAdapter(selectedSkillAdapter);
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
            }
        });

        final Spinner availSkills = (Spinner) findViewById(R.id.availableSkills);
        ArrayAdapter<Skill> availSkillAdapter = AdapterManager.getCharacterSkillArrayAdapter(context, availableSkills);
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

}
