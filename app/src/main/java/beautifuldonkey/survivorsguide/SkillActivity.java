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

import java.util.ArrayList;
import java.util.List;

import beautifuldonkey.survivorsguide.Data.SgConstants;
import beautifuldonkey.survivorsguide.Data.Skill;
import beautifuldonkey.survivorsguide.Data.SkillList;
import beautifuldonkey.survivorsguide.Manager.AdapterManager;


public class SkillActivity extends AppCompatActivity {

  protected List<Skill> skillList = new ArrayList<>();


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_skill);
    Context context = getApplicationContext();

    skillList = SkillList.getSkillList();
    ArrayAdapter<Skill> adapter = AdapterManager.getCharacterSkillArrayAdapter(context, skillList);
    ListView viewSkillList = (ListView) findViewById(R.id.skillsList);
    viewSkillList.setAdapter(adapter);

    viewSkillList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Context context = getApplicationContext();
        Skill skill = skillList.get(position);
        Intent intent = new Intent(context, SkillDetailActivity.class);
        intent.putExtra(SgConstants.INTENT_SKILL, skill);
        startActivityForResult(intent, SgConstants.SKILL_DETAIL_ACTIVITY);
      }
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_skill_activty, menu);
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
