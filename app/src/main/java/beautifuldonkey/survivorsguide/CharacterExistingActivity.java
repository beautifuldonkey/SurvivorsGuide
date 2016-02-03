package beautifuldonkey.survivorsguide;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import beautifuldonkey.survivorsguide.Data.PlayerCharacter;
import beautifuldonkey.survivorsguide.Data.SgConstants;
import beautifuldonkey.survivorsguide.Manager.CharacterManager;


public class CharacterExistingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_existing);
        Log.d("READCHAR", "initial open");
        final Context context = getApplicationContext();

        String[] availFiles = fileList();

        ArrayAdapter<String> fileListAdapter = new ArrayAdapter<>(this, R.layout.item_simple_spinner, availFiles);
        Spinner existingFiles = (Spinner) findViewById(R.id.existingFiles);
        existingFiles.setAdapter(fileListAdapter);
        existingFiles.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                PlayerCharacter loadedCharacter = CharacterManager.loadCharacter(position, context);

                //displaying existing character attributes
                TextView existingCharName = (TextView) findViewById(R.id.existingCharName);
                existingCharName.setText(loadedCharacter.getName());

                TextView existingCharStrain = (TextView) findViewById(R.id.existingCharStrain);
                existingCharStrain.setText(loadedCharacter.getStrain());

                TextView existingCharProfessions = (TextView) findViewById(R.id.existingCharProfession);
                existingCharProfessions.setText(loadedCharacter.getProfessions());

                TextView existingCharInfection = (TextView) findViewById(R.id.existingCharInfection);
                existingCharInfection.setText(loadedCharacter.getInfection());

                TextView existingCharBody = (TextView) findViewById(R.id.existingCharBody);
                existingCharBody.setText(loadedCharacter.getHealth());

                TextView existingCharMind = (TextView) findViewById(R.id.existingCharMind);
                existingCharMind.setText(loadedCharacter.getMind());

                ListView existingCharSkills = (ListView) findViewById(R.id.existingCharSkills);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button btn_Edit = (Button) findViewById(R.id.btn_editExisting);
        btn_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CharacterEditExistingActivity.class);
                startActivityForResult(intent, SgConstants.CHARACTER_EDIT_ACTIVITY);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_character_existing, menu);
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
