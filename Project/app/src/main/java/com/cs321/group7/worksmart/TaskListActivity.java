package com.cs321.group7.worksmart;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cs321.group7.worksmart.Entities.Class;
import com.cs321.group7.worksmart.Entities.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 11/26/2017.
 */

public class TaskListActivity extends BasicActivity {
    SystemUtilities util;
    ListView listview;
    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    List<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasklist);

        util = new SystemUtilities(getApplicationContext());

        FloatingActionButton addClassButton = (FloatingActionButton) findViewById(R.id.addTaskButton);

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

        Long class_id = Long.parseLong(message);
        Class current_class = util.getClassById(class_id);

        TextView label = (TextView) findViewById(R.id.classname);
        label.setText(current_class.getName() + " Tasks:");


        listview = (ListView) findViewById(R.id.task_list);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        listview.setAdapter(adapter);

        tasks = util.getTasksForClass(current_class);

        for (int i = 0; i < tasks.size(); i++) {
            listItems.add(tasks.get(i).getName() + " due at " + tasks.get(i).getTime() + " on " + tasks.get(i).getDate());
        }
        adapter.notifyDataSetChanged();

        addClassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskListActivity.super.goToActivity(R.id.action_addtask, message);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_tasklist:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
