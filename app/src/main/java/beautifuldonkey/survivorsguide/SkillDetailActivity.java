package beautifuldonkey.survivorsguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import beautifuldonkey.survivorsguide.Data.SgConstants;
import beautifuldonkey.survivorsguide.Data.Skill;


public class SkillDetailActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_skill_detail);

    Skill skill = getIntent().getParcelableExtra(SgConstants.INTENT_SKILL);

    TextView viewSkillName = (TextView) findViewById(R.id.skillName);
    viewSkillName.setText(skill.getName());

    TextView viewSkillCost = (TextView) findViewById(R.id.skillCost);
    viewSkillCost.setText(String.valueOf(skill.getMpCost()));

    TextView viewSkillDesc = (TextView) findViewById(R.id.skillDescription);
    viewSkillDesc.setText(skill.getDescription());
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_skill_detail, menu);
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
