package beautifuldonkey.survivorsguide.Manager;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import beautifuldonkey.survivorsguide.Data.Profession;
import beautifuldonkey.survivorsguide.Data.SgSpinnerItem;
import beautifuldonkey.survivorsguide.Data.Skill;
import beautifuldonkey.survivorsguide.R;

/**
 * Provides ArrayAdapter implementations for classes
 * Created by jaw_m on 2/12/2016.
 */
public class AdapterManager {
  /**
   * Provides ArrayAdapter that implements Skill info for characters
   * @param context Current application context
   * @param skills Source data - Skill properties mapped to display
   * @return ArrayAdapter with detailed Skill info mapped
   */
  public static ArrayAdapter<Skill> getCharacterSkillArrayAdapter(final Context context, final List<Skill> skills) {
    ArrayAdapter<Skill> skillArrayAdapter = new ArrayAdapter<Skill>(context, R.layout.item_character_skill, skills) {
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

        if (skills.size() > position) {
          textView.setText(skills.get(position).getName());
          if (skills.get(position).getIsStrain()) {
            checkBoxStrainSkill.setChecked(true);
          } else {
            checkBoxStrainSkill.setVisibility(View.INVISIBLE);
            textViewChkBoxLabel.setText("Build: " + skills.get(position).getBuildCost());
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
        textViewChkBoxLabel.setText("Rank: " + skills.get(position).getCurrRank());

        return view;
      }
    };
    return skillArrayAdapter;
  }
  /**
   * Provides ArrayAdapter that implements simple Skill info
   * @param context Current application context
   * @param skills Source data - Skill properties mapped to display
   * @return ArrayAdapter with Skill info mapped
   */
  public static ArrayAdapter<Skill> getSimpleSkillAdapter(final Context context, final List<Skill> skills) {
    ArrayAdapter<Skill> adapter = new ArrayAdapter<Skill>(context, R.layout.item_skill, skills) {
      @Override
      public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_skill, null);

        TextView txtName = (TextView) view.findViewById(R.id.skillName);
        TextView txtCost = (TextView) view.findViewById(R.id.skillCost);

        if (skills.size() > position) {
          txtName.setText(skills.get(position).getName());
          txtCost.setText(String.valueOf(skills.get(position).getBuildCost()));
        }

        return view;
      }

      @Override
      public View getView(int position, View convertView, ViewGroup parent) {
        Skill skill = skills.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_skill, null);

        TextView txtName = (TextView) view.findViewById(R.id.skillName);
        TextView txtCost = (TextView) view.findViewById(R.id.skillCost);

        txtName.setText(skill.getName());
        txtCost.setText(String.valueOf(skill.getBuildCost()));

        return view;
      }
    };
    return adapter;
  }
  /**
   * Provides ArrayAdapter that implements Profession info
   * @param context Current application context
   * @param profs Source data - Profession properties mapped to display
   * @return ArrayAdapter with Profession info mapped
   */
  public static ArrayAdapter<Profession> getSimpleProfessionAdapter(final Context context, final List<Profession> profs) {
    ArrayAdapter<Profession> adapter = new ArrayAdapter<Profession>(context, R.layout.item_profession, profs) {
      @Override
      public View getDropDownView(int position, View convertView, ViewGroup parent) {
        Profession profession = profs.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_profession,null);
        view.setBackgroundColor(Color.LTGRAY);

        TextView viewProfName = (TextView) view.findViewById(R.id.professionName);
        viewProfName.setText(profession.getName());

        return view;
      }

      @Override
      public View getView(int position, View convertView, ViewGroup parent) {
        Profession profession = profs.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_profession, null);

        TextView viewProfName = (TextView) view.findViewById(R.id.professionName);
        viewProfName.setText(profession.getName());

        return view;
      }
    };
    return adapter;
  }
  /**
   * Provides ArrayAdapter that implements generic application list item
   * @param context Current application context
   * @param list Source data - list of spinner items to be displayed
   * @return ArrayAdapter with spinner item info mapped
   */
  public static ArrayAdapter<SgSpinnerItem> getSimpleSgSpinner(final Context context, final List<SgSpinnerItem> list){
    ArrayAdapter<SgSpinnerItem> adapterSg = new ArrayAdapter<SgSpinnerItem>(context, R.layout.item_simple_spinner, list){
      @NonNull
      @Override
      public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_simple_spinner,null);

        SgSpinnerItem item = list.get(position);

        TextView itemText = (TextView) view.findViewById(R.id.item_text);
        itemText.setText(item.getItemText());

        return view;
      }
    };
    return adapterSg;
  }
}
