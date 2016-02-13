package beautifuldonkey.survivorsguide.Manager;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import beautifuldonkey.survivorsguide.Data.Skill;
import beautifuldonkey.survivorsguide.R;

import java.util.List;

/**
 * Created by jaw_m on 2/12/2016.
 */
public class AdapterManager {

  public static ArrayAdapter<Skill> getCharacterSkillArrayAdapter(final Context context,final List<Skill> skills){
    ArrayAdapter<Skill> skillArrayAdapter = new ArrayAdapter<Skill>(context, R.layout.item_character_skill, skills){
      @Override
      public View getDropDownView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_character_skill, null);

        TextView textView = (TextView) view.findViewById(R.id.skillName);
        textView.setTextColor(Color.BLACK);

        TextView textViewChkBoxLabel = (TextView) view.findViewById(R.id.skillStrainLabel);
        textViewChkBoxLabel.setTextColor(Color.BLACK);

        CheckBox checkBoxStrainSkill = (CheckBox) view.findViewById(R.id.isSkillStrain);
        checkBoxStrainSkill.setTextColor(Color.BLACK);

        if(skills.size()>position){
          textView.setText(skills.get(position).getName());
          if(skills.get(position).getIsStrain()){
            checkBoxStrainSkill.setChecked(true);
          }else{
            checkBoxStrainSkill.setVisibility(View.INVISIBLE);
            textViewChkBoxLabel.setText("Build: "+ skills.get(position).getBuildCost());
          }
        }

        return view;
      }

      @Override
      public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_character_skill, null);

        TextView textView = (TextView) view.findViewById(R.id.skillName);
        textView.setTextColor(Color.BLACK);
        textView.setText(skills.get(position).getName());

        TextView textViewChkBoxLabel = (TextView) view.findViewById(R.id.skillStrainLabel);
        textViewChkBoxLabel.setTextColor(Color.BLACK);

        CheckBox checkBoxStrainSkill = (CheckBox) view.findViewById(R.id.isSkillStrain);
        checkBoxStrainSkill.setTextColor(Color.BLACK);

//                            if(skills.get(position).getIsStrain()){
//                                checkBoxStrainSkill.setChecked(true);
//                            }
        checkBoxStrainSkill.setVisibility(View.INVISIBLE);
        textViewChkBoxLabel.setText("Rank: "+ skills.get(position).getCurrRank());

        return view;
      }
    };
    return skillArrayAdapter;
  }

  public static ArrayAdapter<Skill> getSimpleSkillAdapter(final Context context, final List<Skill> skills){
    ArrayAdapter<Skill> adapter = new ArrayAdapter<Skill>(context, R.layout.item_skill, skills){
      @Override
      public View getView(int position, View convertView, ViewGroup parent) {

        Skill skill = skills.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_skill, null);

        TextView viewSkillName = (TextView) view.findViewById(R.id.skillName);
        viewSkillName.setText(skill.getName());

        TextView viewSkillCost = (TextView) view.findViewById(R.id.skillCost);
        viewSkillCost.setText(String.valueOf(skill.getMpCost()));

        return view;
      }
    };


    return adapter;
  }
}
