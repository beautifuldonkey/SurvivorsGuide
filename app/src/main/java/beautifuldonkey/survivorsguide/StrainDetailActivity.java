package beautifuldonkey.survivorsguide;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import beautifuldonkey.survivorsguide.Data.SgConstants;
import beautifuldonkey.survivorsguide.Data.Skill;
import beautifuldonkey.survivorsguide.Data.SkillList;
import beautifuldonkey.survivorsguide.Data.Strain;
import beautifuldonkey.survivorsguide.Manager.AdapterManager;


public class StrainDetailActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_strain_detail);
    Context context = getApplicationContext();

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

    final List<Skill> strainSkills = SkillList.getSkillsByName(strain.getSkills());

    ListView viewStrainSkills = (ListView) findViewById(R.id.strainSkills);
    ArrayAdapter<Skill> adapter = AdapterManager.getSimpleSkillAdapter(context, strainSkills);
    viewStrainSkills.setAdapter(adapter);
//        viewStrainSkills.setText(strain.getSkills());
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
