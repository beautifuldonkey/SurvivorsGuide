package beautifuldonkey.survivorsguide;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import beautifuldonkey.survivorsguide.Data.Strain;
import beautifuldonkey.survivorsguide.Data.SgConstants;


public class StrainDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strain_detail);

        //Intent intent
        Strain strain = getIntent().getParcelableExtra(SgConstants.INTENT_STRAIN);

        TextView viewStrainName = (TextView) findViewById(R.id.strainName);
        viewStrainName.setText(strain.getName());

        TextView viewStrainBody = (TextView) findViewById(R.id.strainBody);
        viewStrainBody.setText(String.valueOf(strain.getBody()));

        TextView viewStrainMind = (TextView) findViewById(R.id.strainMind);
        viewStrainMind.setText(String.valueOf(strain.getMind()));

        TextView viewStrainInfection = (TextView) findViewById(R.id.strainInfection);
        viewStrainInfection.setText(String.valueOf(strain.getInfection()));

        TextView viewStrainSkills = (TextView) findViewById(R.id.strainSkills);
        viewStrainSkills.setText(strain.getSkills());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_strain_detail, menu);
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
