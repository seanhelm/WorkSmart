package com.cs321.group7.worksmart;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.cs321.group7.worksmart.Entities.Semester;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 11/26/2017.
 */

public class SemesterListActivity extends BasicActivity {

    ListView listview;
    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    SystemUtilities util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semesterlist);

        util = new SystemUtilities(getApplicationContext());
        List<Semester> sems = util.getAllSemesters();

        listview = (ListView) findViewById(R.id.semester_list);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        listview.setAdapter(adapter);

        for (int i = 0; i < sems.size(); i++) {
            listItems.add(sems.get(i).getName());
        }
        adapter.notifyDataSetChanged();


        FloatingActionButton addSemesterButton = (FloatingActionButton) findViewById(R.id.addSemesterButton);

        addSemesterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SemesterListActivity.super.goToActivity(R.id.action_addsemester);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_semesterlist:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
