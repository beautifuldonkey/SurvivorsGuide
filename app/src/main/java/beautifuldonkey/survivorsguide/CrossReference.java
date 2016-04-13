package beautifuldonkey.survivorsguide;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import beautifuldonkey.survivorsguide.Data.Skill;
import beautifuldonkey.survivorsguide.Data.SkillList;
import beautifuldonkey.survivorsguide.Manager.AdapterManager;

public class CrossReference extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross_reference);
        Context context = getApplicationContext();

        List<Skill> skills = SkillList.getSkillList();

        Spinner availSkills = (Spinner) findViewById(R.id.skills);
        ArrayAdapter<Skill> availAkillAdapter = AdapterManager.getSimpleSkillAdapter(context, skills);
        availSkills.setAdapter(availAkillAdapter);

    }
}
