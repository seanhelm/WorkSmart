package com.cs321.group7.worksmart;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cs321.group7.worksmart.Entities.Class;
import com.cs321.group7.worksmart.Entities.Semester;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 11/26/2017.
 */

public class ClassListActivity extends BasicActivity {
    SystemUtilities util;
    ListView listview;
    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    List<Class> classes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classlist);

        util = new SystemUtilities(getApplicationContext());

        FloatingActionButton addClassButton = (FloatingActionButton) findViewById(R.id.addClassButton);

        final String message;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                message = null;
            } else {
                message = extras.getString("MESSAGE");
            }
        } else {
            message = (String) savedInstanceState.getSerializable("MESSAGE");
        }

        Long sem_id = Long.parseLong(message);

        Semester semester = util.getSemesterById(sem_id);

        TextView sem_name = (TextView) findViewById(R.id.semester_name_tag);
        sem_name.setText(semester.getName() + " Classes:");

        classes = util.getClassesForSemester(semester);

        listview = (ListView) findViewById(R.id.class_list);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        listview.setAdapter(adapter);

        for (int i = 0; i < classes.size(); i++) {
            listItems.add(classes.get(i).getName());
            //util.removeSemester(sems.get(i));
        }
        adapter.notifyDataSetChanged();


        addClassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassListActivity.super.goToActivity(R.id.action_addclass, message);
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClassListActivity.super.goToActivity(R.id.action_classinfo, "" + classes.get(position).getId());
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_classlist:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
