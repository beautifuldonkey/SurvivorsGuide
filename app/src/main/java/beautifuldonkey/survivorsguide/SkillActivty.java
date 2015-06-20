package beautifuldonkey.survivorsguide;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import beautifuldonkey.survivorsguide.Data.Skill;
import beautifuldonkey.survivorsguide.Data.SkillList;


public class SkillActivty extends ActionBarActivity {

    protected List<Skill> skillList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_activty);

        skillList =  SkillList.getSkillList();
        ArrayAdapter <Skill> adapter = new skillListAdapter(this, 0, skillList);
        ListView viewSkillList = (ListView) findViewById(R.id.skillsList);
        viewSkillList.setAdapter(adapter);

        viewSkillList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = getApplicationContext();
                Skill skill = skillList.get(position);
                Intent intent = new Intent(context, SkillDetailActivity.class);
                intent.putExtra("SKILL", skill);
                startActivityForResult(intent, 07);
            }
        });
    }

   class skillListAdapter extends ArrayAdapter<Skill>{

       Context context;
       List<Skill> objects;

       public skillListAdapter(Context context, int resource, List<Skill> objects) {
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
           viewSkillCost.setText(String.valueOf(skill.getMpCost()));

           TextView viewSkillDesc = (TextView) view.findViewById(R.id.skillDescription);
           viewSkillDesc.setText(skill.getDescription());

           return view;
       }

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
