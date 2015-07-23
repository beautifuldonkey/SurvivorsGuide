package beautifuldonkey.survivorsguide;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;

import java.io.BufferedInputStream;
import java.io.FileInputStream;


public class CharacterExistingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_existing);
        Log.d("READCHAR", "initial open");

        String[] availFiles = fileList();

        ArrayAdapter<String> fileListAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, availFiles);
        Spinner existingFiles = (Spinner) findViewById(R.id.existingFiles);
        existingFiles.setAdapter(fileListAdapter);
        existingFiles.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    String[] files = fileList();
                    FileInputStream fis = openFileInput(files[position]);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    StringBuffer b = new StringBuffer();
                    Log.d("READCHAR", "file opened & buffers created");
                    while (bis.available() != 0) {
                        char c = (char) bis.read();
                        b.append(c);
                    }
                    bis.close();
                    fis.close();
                    Log.d("READCHAR", "buffers closed");

                    JSONArray data = new JSONArray(b.toString());

                    Log.d("READCHAR", "building string");
                    StringBuffer charBuffer = new StringBuffer();
                    for (int i = 0; i < data.length(); i++) {

                        String charName = data.getJSONObject(i).getString("name");
                        charBuffer.append(charName);
                    }
                    Log.d("READCHAR", "built string now displaying");
                    TextView existingChar = (TextView) findViewById(R.id.existingChar);
                    existingChar.setText(charBuffer);

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
