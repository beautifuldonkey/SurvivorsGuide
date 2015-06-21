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
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

import beautifuldonkey.survivorsguide.Data.Profession;
import beautifuldonkey.survivorsguide.Data.ProfessionList;


public class ProfessionActivity extends ActionBarActivity {

    public static int PROFESSION_DETAIL_ACTIVITY = 11;

    private List<Profession> professions = ProfessionList.getProfessionList();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profession);

        ArrayAdapter <Profession> adapter = new professionArrayAdapter(this, 0, professions);
        ListView professionList = (ListView) findViewById(R.id.professionList);
        professionList.setAdapter(adapter);

        professionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = getApplicationContext();
                Profession profession = professions.get(position);
                Intent intent = new Intent (context, ProfessionDetailActivity.class);
                intent.putExtra("PROFESSION", profession);
                startActivityForResult(intent, PROFESSION_DETAIL_ACTIVITY);
            }
        });
    }

    class professionArrayAdapter extends ArrayAdapter<Profession>{

        Context context;
        List<Profession> objects;

        public professionArrayAdapter(Context context, int resource, List<Profession> objects) {
            super(context, resource, objects);
            this.context = context;
            this.objects = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Profession profession = objects.get(position);
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.item_profession, null);

            TextView professionName = (TextView) view.findViewById(R.id.professionName);
            professionName.setText(profession.getName());

            return view;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profession, menu);
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
