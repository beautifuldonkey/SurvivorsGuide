package beautifuldonkey.survivorsguide;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import beautifuldonkey.survivorsguide.Data.Profession;
import beautifuldonkey.survivorsguide.Data.ProfessionList;
import beautifuldonkey.survivorsguide.Data.Skill;
import beautifuldonkey.survivorsguide.Data.SkillList;
import beautifuldonkey.survivorsguide.Data.Strain;
import beautifuldonkey.survivorsguide.Data.StrainList;


public class CharacterNewActivity extends AppCompatActivity {

    Profession charProfession;
    Strain charStrain;
    ArrayAdapter<Skill> availSkillAdapter;
    ArrayAdapter<Skill> displaySkillAdapter;
    String strainSkills = "";
    String profSkills = "";
    List<Skill> selectedSkills = new ArrayList<>();
    Boolean isStrainSkill = false;
    ListView availSkills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_new);
        final Context context = getApplicationContext();

        final EditText charName = (EditText) findViewById(R.id.characterName);
        charName.setText("Enter character name");
        charName.setTextColor(Color.BLACK);

        final TextView charInfection = (TextView) findViewById(R.id.newCharacterInfection);

        Button btn_addBody = (Button) findViewById(R.id.btn_newCharMoreBody);
        btn_addBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textBody = (TextView) findViewById(R.id.newCharacterBody);
                Integer currentBody = Integer.parseInt(textBody.getText().toString());
                currentBody = currentBody + 1;
                textBody.setText(String.valueOf(currentBody));
            }
        });

        Button btn_subBody = (Button) findViewById(R.id.btn_newCharLessBody);
        btn_subBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textBody = (TextView) findViewById(R.id.newCharacterBody);
                Integer currentBody = Integer.parseInt(textBody.getText().toString());
                currentBody = currentBody - 1;
                textBody.setText(String.valueOf(currentBody));
            }
        });

        Button btn_addMind = (Button) findViewById(R.id.btn_newCharMoreMind);
        btn_addMind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textMind = (TextView) findViewById(R.id.newCharacterMind);
                Integer currentMind = Integer.parseInt(textMind.getText().toString());
                currentMind = currentMind+1;
                textMind.setText(String.valueOf(currentMind));
            }
        });

        Button btn_subMind = (Button) findViewById(R.id.btn_newCharLessMind);
        btn_subMind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textMind = (TextView) findViewById(R.id.newCharacterMind);
                Integer currentMind = Integer.parseInt(textMind.getText().toString());
                currentMind = currentMind-1;
                textMind.setText(String.valueOf(currentMind));
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

                JSONArray data = new JSONArray();
                JSONObject character;
                String charProfSkills = "";
                String charStrainSkills = "";
                String characterName = charName.getText().toString();
                for(int i=0; i<selectedSkills.size(); i++){
                    Skill skill = selectedSkills.get(i);
                    if(skill.getIsStrain()){
                        charStrainSkills = skill.getName()+",";
                    }else{
                        charProfSkills = skill.getName()+",";
                    }
                }

                character = new JSONObject();
                try {
                    character.put("name", characterName);
                    character.put("body", charStrain.getBody());
                    character.put("mind", charStrain.getMind());
                    character.put("strain", charStrain.getName());
                    character.put("professions", charProfession.getName());
                    character.put("profSkills", charProfSkills);
                    character.put("strainSkills", charStrainSkills);
                    data.put(character);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                String text = data.toString();

                try {
                    FileOutputStream fos = openFileOutput(characterName, MODE_PRIVATE);
                    fos.write(text.getBytes());
                    fos.close();
                    Log.d("FILEWRITTEN", "File written to local storage!\n"+data.toString());
                }catch (Exception ex){
                    ex.printStackTrace();
                }
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
        ArrayAdapter<String> strainAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, strainNames);
        strainDropDown.setAdapter(strainAdapter);
        strainDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                charStrain = strains.get(position);
                if(charStrain != null){
                    strainSkills = charStrain.getSkills();
                }
                updateAvailableSkillList(context, profSkills, strainSkills, true);
                charInfection.setText(String.valueOf(charStrain.getInfection()));
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
        ArrayAdapter<String> profAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, professionNames);
        profDropDown.setAdapter(profAdapter);
        profDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                charProfession = professions.get(position);
                if (charProfession != null) {
                    profSkills = charProfession.getSkills();
                }
                updateAvailableSkillList(context, profSkills, strainSkills, false);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final ListView displayedSkills = (ListView) findViewById(R.id.selectedSkills);
        displayedSkills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedSkills.remove(position);
                displaySkillAdapter.notifyDataSetChanged();
            }
        });

        availSkills = (ListView) findViewById(R.id.availableSkills);
        availSkills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(!selectedSkills.contains(availSkills.getItemAtPosition(position))){
                    selectedSkills.add((Skill)availSkills.getItemAtPosition(position));
                }

                if(displaySkillAdapter == null){
                    displaySkillAdapter = new ArrayAdapter<Skill>(context, R.layout.item_character_skill, selectedSkills){
                        @Override
                        public View getView(int position, View convertView, ViewGroup parent) {
                            LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
                            View view = inflater.inflate(R.layout.item_character_skill, null);

                            TextView textView = (TextView) view.findViewById(R.id.skillName);
                            textView.setTextColor(Color.BLACK);
                            textView.setText(selectedSkills.get(position).getName());

                            TextView textViewChkBoxLabel = (TextView) view.findViewById(R.id.skillStrainLabel);
                            textViewChkBoxLabel.setTextColor(Color.BLACK);

                            CheckBox checkBoxStrainSkill = (CheckBox) view.findViewById(R.id.isSkillStrain);
                            checkBoxStrainSkill.setTextColor(Color.BLACK);

                            if(selectedSkills.get(position).getIsStrain()){
                                checkBoxStrainSkill.setChecked(true);
                            }
                            return view;
                        }
                    };
                    displayedSkills.setAdapter(displaySkillAdapter);
                }else{
                    displaySkillAdapter.notifyDataSetChanged();
                }
            }
        });

    }

    public void updateAvailableSkillList(final Context context, String profSkills, String strainSkills, Boolean strainFlag){
        isStrainSkill = strainFlag;
        List<Skill> incProfSkills = SkillList.getSkillsByName(profSkills);
        List<Skill> incStrainSkills = SkillList.getSkillsByName(strainSkills);
        final List<Skill> newDisplayedSkills = new ArrayList<>();
        for(int i=0; i<incStrainSkills.size(); i++){
            incStrainSkills.get(i).setIsStrain(true);
            for(int j=0; j<incProfSkills.size(); j++){
                if(incStrainSkills.get(i).getName().equals(incProfSkills.get(j).getName())){
                    incProfSkills.remove(j);
                    break;
                }
            }
        }

        newDisplayedSkills.addAll(incStrainSkills);
        newDisplayedSkills.addAll(incProfSkills);

        if(availSkillAdapter==null) {
            availSkillAdapter = new ArrayAdapter<Skill>(context, R.layout.item_character_skill, newDisplayedSkills) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {

                    LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
                    View view = inflater.inflate(R.layout.item_character_skill, null);

                    TextView textView = (TextView) view.findViewById(R.id.skillName);
                    textView.setTextColor(Color.BLACK);
                    textView.setText(newDisplayedSkills.get(position).getName());

                    TextView textViewChkBoxLabel = (TextView) view.findViewById(R.id.skillStrainLabel);
                    textViewChkBoxLabel.setTextColor(Color.BLACK);

                    CheckBox checkBoxStrainSkill = (CheckBox) view.findViewById(R.id.isSkillStrain);
                    checkBoxStrainSkill.setTextColor(Color.BLACK);

                    if(newDisplayedSkills.get(position).getIsStrain()){
                        checkBoxStrainSkill.setChecked(true);
                    }

                    return view;
                }
            };
            availSkills.setAdapter(availSkillAdapter);
        }else{
            availSkillAdapter.clear();
            availSkillAdapter.addAll(newDisplayedSkills);
            availSkillAdapter.notifyDataSetChanged();
        }
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
