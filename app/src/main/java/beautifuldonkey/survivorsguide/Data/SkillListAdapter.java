package beautifuldonkey.survivorsguide.Data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import beautifuldonkey.survivorsguide.R;

/**
 * Created by user on 6/24/2015.
 */
public class SkillListAdapter {

    public class skillListAdapter extends ArrayAdapter<Skill> {

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
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
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



}
