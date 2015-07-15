package beautifuldonkey.survivorsguide;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import beautifuldonkey.survivorsguide.Data.SgConstants;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        final Context context = getApplicationContext();

        Button btn_Skills = (Button) findViewById(R.id.btn_skills);
        btn_Skills.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SkillActivty.class);
                startActivityForResult(intent, SgConstants.SKILL_ACTIVITY);
            }
        });

        Button btn_Strain = (Button) findViewById(R.id.btn_strains);
        btn_Strain.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StrainActivity.class);
                startActivityForResult(intent, SgConstants.STRAIN_ACTIVITY);
            }
        });

        Button btn_Profession = (Button) findViewById(R.id.btn_professions);
        btn_Profession.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProfessionActivity.class);
                startActivityForResult(intent, SgConstants.PROFESSION_ACTIVITY);
            }
        });

        Button btn_Character = (Button) findViewById(R.id.btn_character);
        btn_Character.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CharacterActivity.class);
                startActivityForResult(intent, SgConstants.CHARACTER_ACTIVITY);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome_screen, menu);
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
