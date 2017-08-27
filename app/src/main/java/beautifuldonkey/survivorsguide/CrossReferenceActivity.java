package beautifuldonkey.survivorsguide;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import beautifuldonkey.survivorsguide.Data.Profession;
import beautifuldonkey.survivorsguide.Data.ProfessionList;
import beautifuldonkey.survivorsguide.Data.SgSpinnerItem;
import beautifuldonkey.survivorsguide.Data.Skill;
import beautifuldonkey.survivorsguide.Data.SkillList;
import beautifuldonkey.survivorsguide.Data.Strain;
import beautifuldonkey.survivorsguide.Data.StrainList;
import beautifuldonkey.survivorsguide.Manager.AdapterManager;

public class CrossReferenceActivity extends AppCompatActivity {

  private ArrayAdapter<SgSpinnerItem> itemArrayAdapter;
  private ArrayAdapter<Skill> selectedSkillAdapter;
  private List<Profession> professions;
  private List<SgSpinnerItem> availableItems;
  private List<Skill> requiredSkills;
  private List<Strain> strains;
  private RadioButton chkProfessions;
  private RadioButton chkStrains;
  private Spinner availSkills;

  private TextView txtOptionsLabel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cross_reference);
    Context context = getApplicationContext();

    requiredSkills = new ArrayList<>();
    professions = ProfessionList.getProfessionList();
    strains = StrainList.getStrainList();
    availableItems = new ArrayList<>();

    txtOptionsLabel = (TextView) findViewById(R.id.text_professions);

    chkProfessions = (RadioButton) findViewById(R.id.chk_profs);
    chkProfessions.setChecked(true);
    chkProfessions.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(chkProfessions.isChecked()){
          updateAvailableProfessions();
          txtOptionsLabel.setText(R.string.text_cr_prof_options);
        }
      }
    });

    chkStrains = (RadioButton) findViewById(R.id.chk_strains);
    chkStrains.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(chkStrains.isChecked()){
          updateAvailableStrains();
          txtOptionsLabel.setText(R.string.text_cr_strain_options);
        }
      }
    });

    availSkills = (Spinner) findViewById(R.id.skills);
    ArrayAdapter<Skill> availSkillAdapter = AdapterManager.getSimpleSkillAdapter(context, SkillList.getSkillList());
    availSkills.setAdapter(availSkillAdapter);
    availSkills.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Skill newReqSkill = (Skill) availSkills.getItemAtPosition(position);
        if (!requiredSkills.contains(newReqSkill)) {
          requiredSkills.add(newReqSkill);
          selectedSkillAdapter.notifyDataSetChanged();
          if(chkProfessions.isChecked()){
            updateAvailableProfessions();
          }
          if(chkStrains.isChecked()){
            updateAvailableStrains();
          }
        }
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
    });

    ListView selectedSkills = (ListView) findViewById(R.id.required_skills);
    selectedSkillAdapter = AdapterManager.getSimpleSkillAdapter(context, requiredSkills);
    selectedSkills.setAdapter(selectedSkillAdapter);
    selectedSkills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        requiredSkills.remove(position);
        selectedSkillAdapter.notifyDataSetChanged();
        if(chkProfessions.isChecked()){
          updateAvailableProfessions();
        }
        if(chkStrains.isChecked()){
          updateAvailableStrains();
        }
      }
    });

    ListView availableOptions = (ListView) findViewById(R.id.professions);
    itemArrayAdapter = AdapterManager.getSimpleSgSpinner(context, availableItems);
    availableOptions.setAdapter(itemArrayAdapter);

  }

  private void updateAvailableProfessions() {
    availableItems.clear();
    for (int i = 0; i < professions.size(); i++) {
      Boolean isProfAvail = true;

      if(professions.get(i).getSkills() == null){
        continue;
      }

      String[] profSkills = professions.get(i).getSkills().split(",");
      for (int j = 0; j < requiredSkills.size(); j++) {
        Boolean profHasSkill = false;
        for (int k = 0; k < profSkills.length; k++) {
          if (requiredSkills.get(j).getName().equals(profSkills[k])) {
            profHasSkill = true;
            break;
          }
        }
        if (!profHasSkill) {
          isProfAvail = false;
        }
      }
      if (isProfAvail) {
        availableItems.add(new SgSpinnerItem(professions.get(i).getName()));
      }
    }
    itemArrayAdapter.notifyDataSetChanged();
  }

  private void updateAvailableStrains() {
    availableItems.clear();
    for(Strain strain : strains){
      Boolean isStrainAvail = true;
      String[] strainSkills = strain.getSkills().split(",");

      for(Skill reqSkill : requiredSkills){
        Boolean strainHasSkill = false;
        for(String strainSkill : strainSkills){
          if(reqSkill.getName().equals(strainSkill)){
            strainHasSkill = true;
            break;
          }
        }
        if(!strainHasSkill){
          isStrainAvail = false;
        }
      }
      if(isStrainAvail){
        availableItems.add(new SgSpinnerItem(strain.getName()));
      }
    }
    itemArrayAdapter.notifyDataSetChanged();
  }
}
