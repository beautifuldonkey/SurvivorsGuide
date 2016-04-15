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

import beautifuldonkey.survivorsguide.Data.Profession;
import beautifuldonkey.survivorsguide.Data.ProfessionList;
import beautifuldonkey.survivorsguide.Data.Skill;
import beautifuldonkey.survivorsguide.Data.SkillList;
import beautifuldonkey.survivorsguide.Manager.AdapterManager;

public class CrossReference extends AppCompatActivity {

  List<Skill> requiredSkills;
  List<Skill> skills;
  List<Profession> availableProfessions;
  List<Profession> professions;
  ArrayAdapter<Profession> professionArrayAdapter;
  ArrayAdapter<Skill> selectedSkillAdapter;
  ListView selectedSkills;
  ListView professionOptions;
  Spinner availSkills;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cross_reference);
    Context context = getApplicationContext();

    requiredSkills = new ArrayList<>();
    skills = SkillList.getSkillList();
    professions = new ArrayList<>(ProfessionList.getProfessionList());
    availableProfessions = new ArrayList<>(ProfessionList.getProfessionList());

    availSkills = (Spinner) findViewById(R.id.skills);
    ArrayAdapter<Skill> availSkillAdapter = AdapterManager.getSimpleSkillAdapter(context, skills);
    availSkills.setAdapter(availSkillAdapter);
    availSkills.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Skill newReqSkill = (Skill) availSkills.getItemAtPosition(position);
        if(!requiredSkills.contains(newReqSkill)){
          requiredSkills.add(newReqSkill);
          selectedSkillAdapter.notifyDataSetChanged();
          updateAvailableProfessions();
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
        updateAvailableProfessions();
      }
    });

    professionOptions = (ListView) findViewById(R.id.professions);
    professionArrayAdapter = AdapterManager.getSimpleProfessionAdapter(context, availableProfessions);
    professionOptions.setAdapter(professionArrayAdapter);

  }

  private void updateAvailableProfessions(){
    availableProfessions.clear();
    for(int i=0; i<professions.size(); i++){
      Boolean isProfAvail = true;
      String[] profSkills = professions.get(i).getSkills().split(",");
      for(int j=0; j<requiredSkills.size(); j++){
        Boolean profHasSkill = false;
        for(int k=0; k<profSkills.length; k++){
          if(requiredSkills.get(j).getName().equals(profSkills[k])){
            profHasSkill = true;
            break;
          }
        }
        if(!profHasSkill){
          isProfAvail = false;
        }
      }
      if(isProfAvail){
        availableProfessions.add(professions.get(i));
      }
    }
    professionArrayAdapter.notifyDataSetChanged();
  }
}
