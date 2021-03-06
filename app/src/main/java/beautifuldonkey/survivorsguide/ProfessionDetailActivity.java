package beautifuldonkey.survivorsguide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import beautifuldonkey.survivorsguide.Data.Profession;
import beautifuldonkey.survivorsguide.Data.SgConstants;
import beautifuldonkey.survivorsguide.Data.Skill;
import beautifuldonkey.survivorsguide.Data.SkillList;
import beautifuldonkey.survivorsguide.Manager.AdapterManager;


public class ProfessionDetailActivity extends AppCompatActivity {

  List<Skill> professionSkills;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profession_detail);
    Context context = getApplicationContext();

    Profession profession = getIntent().getParcelableExtra(SgConstants.INTENT_PROFESSION);
    professionSkills = SkillList.getSkillsByNameSetCost(profession.getSkills(), profession.getSkillCost());

    TextView viewProfessionName = (TextView) findViewById(R.id.professionName);
    viewProfessionName.setText(profession.getName());

    TextView viewProfessionDesc = (TextView) findViewById(R.id.professionDesc);
    viewProfessionDesc.setText(profession.getDescription());

    ArrayAdapter<Skill> adapter = AdapterManager.getSimpleSkillAdapter(context, professionSkills);
    ListView viewProfessionSkills = (ListView) findViewById(R.id.professionSkills);
    viewProfessionSkills.setAdapter(adapter);

    viewProfessionSkills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Context context = getApplicationContext();
        Intent intent = new Intent(context, SkillDetailActivity.class);
        intent.putExtra(SgConstants.INTENT_SKILL, professionSkills.get(position));
        startActivityForResult(intent, SgConstants.SKILL_DETAIL_ACTIVITY);
      }
    });

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_profession_detail, menu);
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
