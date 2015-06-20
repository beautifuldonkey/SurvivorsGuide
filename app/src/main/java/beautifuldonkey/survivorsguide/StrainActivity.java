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

import java.util.ArrayList;
import java.util.List;

import beautifuldonkey.survivorsguide.Data.Strain;
import beautifuldonkey.survivorsguide.Data.StrainList;


public class StrainActivity extends ActionBarActivity {

    protected List<Strain> strainList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strain);

        strainList = StrainList.getStrainList();
        ArrayAdapter<Strain> adapter = new strainListAdapter(this, 0, strainList);
        ListView strainListView = (ListView) findViewById(R.id.strainList);
        strainListView.setAdapter(adapter);

        strainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Context context = getApplicationContext();
                Strain strain = strainList.get(position);
                Intent intent = new Intent(context, StrainDetailActivity.class);
                intent.putExtra("STRAIN", strain);
                startActivityForResult(intent, 06);
            }
        });

    }

    class strainListAdapter extends ArrayAdapter<Strain>{

        Context context;
        List<Strain> objects;

        public strainListAdapter(Context context, int resource, List<Strain> objects) {
            super(context, resource, objects);
            this.context = context;
            this.objects = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Strain strain = objects.get(position);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.item_strain, null);

            TextView viewStrainName = (TextView) view.findViewById(R.id.strainName);
            viewStrainName.setText(strain.getName());

            TextView viewStrainBody = (TextView) view.findViewById(R.id.strainBody);
            viewStrainBody.setText(String.valueOf(strain.getBody()));

            TextView viewStrainMind = (TextView) view.findViewById(R.id.strainMind);
            viewStrainMind.setText(String.valueOf(strain.getMind()));

            TextView viewStrainInfection = (TextView) view.findViewById(R.id.strainInfection);
            viewStrainInfection.setText(String.valueOf(strain.getInfection()));

            return view;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_strain, menu);
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
