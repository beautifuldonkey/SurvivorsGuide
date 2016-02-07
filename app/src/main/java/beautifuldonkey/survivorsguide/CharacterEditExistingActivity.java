package beautifuldonkey.survivorsguide;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import beautifuldonkey.survivorsguide.Data.PlayerCharacter;
import beautifuldonkey.survivorsguide.Data.SgConstants;
import beautifuldonkey.survivorsguide.Data.Skill;
import beautifuldonkey.survivorsguide.Data.SkillList;
import beautifuldonkey.survivorsguide.Manager.CharacterManager;

public class CharacterEditExistingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_edit_existing);
        Context context = getApplicationContext();

        PlayerCharacter charToEdit = getIntent().getParcelableExtra(SgConstants.INTENT_EDIT_CHAR);

        TextView charName = (TextView) findViewById(R.id.characterName);
        charName.setText(charToEdit.getName());

        TextView charBuild = (TextView) findViewById(R.id.newCharacterBuild);
        charBuild.setText(charToEdit.getAvailBuild());

        TextView charInfection = (TextView) findViewById(R.id.newCharacterInfection);
        charInfection.setText(charToEdit.getInfection());

        TextView charBody = (TextView) findViewById(R.id.newCharacterBody);
        charBody.setText(charToEdit.getHealth());

        TextView charMind = (TextView) findViewById(R.id.newCharacterMind);
        charMind.setText(charToEdit.getMind());

        final List<Skill> selectedSkills = SkillList.getSkillsByName(charToEdit.getSelectedSkills());

        ListView existingCharSkills = (ListView) findViewById(R.id.selectedSkills);
        ArrayAdapter<Skill> selectedSkillAdapter = CharacterManager.getSkillArrayAdapter(context, selectedSkills);
        existingCharSkills.setAdapter(selectedSkillAdapter);
    }

}
