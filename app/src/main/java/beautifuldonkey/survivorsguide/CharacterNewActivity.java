package beautifuldonkey.survivorsguide;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import beautifuldonkey.survivorsguide.Data.Profession;
import beautifuldonkey.survivorsguide.Data.ProfessionList;
import beautifuldonkey.survivorsguide.Data.Strain;
import beautifuldonkey.survivorsguide.Data.StrainList;


public class CharacterNewActivity extends ActionBarActivity {

    Profession charProfession;
    Strain charStrain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_new);
        final Context context = getApplicationContext();

        final List<Strain> strains = StrainList.getStrainList();
        String [] strainNames = new String[strains.size()];
        for(int i =0; i<strains.size(); i++){
            strainNames[i] = strains.get(i).getName();
        }
        Spinner strainDropDown = (Spinner) findViewById(R.id.strainDropDown);
        ArrayAdapter<String> strainAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, strainNames);
        strainDropDown.setAdapter(strainAdapter);
        strainDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                charStrain = strains.get(position);
                String profStrain = " , ";
                if(charStrain != null){
                    profStrain = charStrain.getSkills();
                }
                updateAvailableSkillList(context, profStrain);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final List<Profession> professions = ProfessionList.getProfessionList();
        String[] professionNames = new String[professions.size()];
        for(int i = 0; i<professions.size(); i++){
            professionNames[i] = professions.get(i).getName();
        }
        Spinner profDropDown = (Spinner) findViewById(R.id.professionDropDown);
        ArrayAdapter<String> profAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, professionNames);
        profDropDown.setAdapter(profAdapter);
        profDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                charProfession = professions.get(position);
                String profSkills = " , ";
                if(charProfession != null){
                    profSkills = charProfession.getSkills();
                }
                updateAvailableSkillList(context, profSkills);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void updateAvailableSkillList(Context context, String skills){
        String[] charSkills = skills.split(",");
        ListView availSkills = (ListView) findViewById(R.id.availableSkills);
        ArrayAdapter<String> availSkillAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1,charSkills ){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position,convertView,parent);

                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setTextColor(Color.BLACK);

                return view;
            }
        };
        availSkills.setAdapter(availSkillAdapter);

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
