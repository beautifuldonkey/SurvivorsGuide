package beautifuldonkey.survivorsguide;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import beautifuldonkey.survivorsguide.Data.Skill;
import beautifuldonkey.survivorsguide.Data.SkillList;
import beautifuldonkey.survivorsguide.Manager.AdapterManager;

public class CrossReference extends AppCompatActivity {

    List<Skill> requiredSkills;
    ArrayAdapter<Skill> selectedSkillAdapter;
    ListView selectedSkills;
    Spinner availSkills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross_reference);
        Context context = getApplicationContext();

        requiredSkills = new ArrayList<>();

        List<Skill> skills = SkillList.getSkillList();

        availSkills = (Spinner) findViewById(R.id.skills);
        ArrayAdapter<Skill> availSkillAdapter = AdapterManager.getCharacterSkillArrayAdapter(context, skills);
        availSkills.setAdapter(availSkillAdapter);
        availSkills.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Skill newReqSkill = (Skill) availSkills.getItemAtPosition(position);
                if(!requiredSkills.contains(newReqSkill)){
                    requiredSkills.add(newReqSkill);
                    selectedSkillAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        selectedSkills = (ListView) findViewById(R.id.required_skills);
        selectedSkillAdapter = AdapterManager.getSimpleSkillAdapter(context, requiredSkills);
        selectedSkills.setAdapter(selectedSkillAdapter);
        selectedSkills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                requiredSkills.remove(position);
                selectedSkillAdapter.notifyDataSetChanged();
            }
        });

    }
}
