package beautifuldonkey.survivorsguide;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;

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

  List<Skill> requiredSkills;
  List<Skill> skills;
  List<SgSpinnerItem> availableItems;
  List<Profession> professions;
  List<Strain> strains;
  ArrayAdapter<SgSpinnerItem> itemArrayAdapter;
  ArrayAdapter<Skill> selectedSkillAdapter;
  ListView selectedSkills;
  ListView availableOptions;
  Spinner availSkills;

  CheckBox chkProfessions;
  CheckBox chkStrains;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cross_reference);
    Context context = getApplicationContext();

    requiredSkills = new ArrayList<>();
    skills = SkillList.getSkillList();
    professions = ProfessionList.getProfessionList();
    strains = StrainList.getStrainList();
    availableItems = new ArrayList<>();

    chkProfessions = (CheckBox) findViewById(R.id.chk_profs);
    chkProfessions.setChecked(true);
    chkProfessions.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(chkStrains != null){
          chkStrains.setChecked(false);
        }
      }
    });

    chkStrains = (CheckBox) findViewById(R.id.chk_strains);
    chkStrains.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(chkProfessions != null){
          chkProfessions.setChecked(false);
        }
      }
    });

    availSkills = (Spinner) findViewById(R.id.skills);
    ArrayAdapter<Skill> availSkillAdapter = AdapterManager.getSimpleSkillAdapter(context, skills);
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

    selectedSkills = (ListView) findViewById(R.id.required_skills);
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

    availableOptions = (ListView) findViewById(R.id.professions);
    itemArrayAdapter = AdapterManager.getSimpleSgSpinner(context, availableItems);
    availableOptions.setAdapter(itemArrayAdapter);

  }

  private void updateAvailableProfessions() {
    availableItems.clear();
    for (int i = 0; i < professions.size(); i++) {
      Boolean isProfAvail = true;
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
