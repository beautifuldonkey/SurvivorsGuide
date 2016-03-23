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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_edit_existing);
        final Context context = getApplicationContext();

        PlayerCharacter charToEdit = getIntent().getParcelableExtra(SgConstants.INTENT_EDIT_CHAR);

        TextView charName = (TextView) findViewById(R.id.characterName);
        charName.setText(charToEdit.getName());

        TextView charStrainText = (TextView) findViewById(R.id.characterStrain);
        charStrainText.setText(charToEdit.getStrain());

        TextView charProfsText = (TextView) findViewById(R.id.characterProfessions);
        charProfsText.setText(charToEdit.getProfessions());

        final TextView charBuild = (TextView) findViewById(R.id.newCharacterBuild);
        charBuild.setText(charToEdit.getAvailBuild());

        TextView charInfection = (TextView) findViewById(R.id.newCharacterInfection);
        charInfection.setText(charToEdit.getInfection());

        TextView charBody = (TextView) findViewById(R.id.newCharacterBody);
        charBody.setText(charToEdit.getHealth());

        TextView charMind = (TextView) findViewById(R.id.newCharacterMind);
        charMind.setText(charToEdit.getMind());

        final List<Skill> selectedSkills = SkillList.getSkillsByName(charToEdit.getSelectedSkills());
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

        String[] profs = charToEdit.getProfessions().split(",");
        List<Profession> charProfs = new ArrayList<>();
        for(int i=0; i<profs.length; i++){
            charProfs.add(ProfessionList.getProfessionByName(profs[i]));
        }

        Strain charStrain = StrainList.getStrainByName(charToEdit.getStrain());

        List<Skill> availableSkills = CharacterManager.updateAvailableSkillList(
                charProfs.get(0),
                charProfs.size()>1 ? charProfs.get(1) : null,
                charProfs.size()>2 ? charProfs.get(2) : null,
                charStrain);
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
