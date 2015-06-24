package beautifuldonkey.survivorsguide;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import beautifuldonkey.survivorsguide.Data.Profession;
import beautifuldonkey.survivorsguide.Data.Skill;
import beautifuldonkey.survivorsguide.Data.SkillList;


public class ProfessionDetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profession_detail);

        Profession profession = getIntent().getParcelableExtra("PROFESSION");
        List<Skill> professionSkills = SkillList.getSkillsByName(profession.getSkills());

        TextView viewProfessionName = (TextView) findViewById(R.id.professionName);
        viewProfessionName.setText(profession.getName());

        ArrayAdapter <Skill> adapter = new professionSkillListAdapter(this, 0, professionSkills);
        ListView viewProfessionSkills = (ListView) findViewById(R.id.professionSkills);
        viewProfessionSkills.setAdapter(adapter);

    }

    class professionSkillListAdapter extends ArrayAdapter<Skill>{

        Context context;
        List<Skill> objects;
        public professionSkillListAdapter(Context context, int resource, List<Skill> objects) {
            super(context, resource, objects);
            this.context = context;
            this.objects = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Skill skill = objects.get(position);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.item_skill, null);

            TextView viewSkillName = (TextView) view.findViewById(R.id.skillName);
            viewSkillName.setText(skill.getName());

            TextView viewSkillCost = (TextView) view.findViewById(R.id.skillCost);
            viewSkillCost.setText(skill.getMpCost());

            return view;
        }
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
