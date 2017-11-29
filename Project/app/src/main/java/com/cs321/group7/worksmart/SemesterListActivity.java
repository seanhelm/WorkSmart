package com.cs321.group7.worksmart;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
    List<Semester> sems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semesterlist);

        util = new SystemUtilities(getApplicationContext());
        sems = util.getAllSemesters();

        listview = (ListView) findViewById(R.id.semester_list);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        listview.setAdapter(adapter);

        for (int i = 0; i < sems.size(); i++) {
            listItems.add(sems.get(i).getName());
            //util.removeSemester(sems.get(i));
        }
        adapter.notifyDataSetChanged();


        FloatingActionButton addSemesterButton = (FloatingActionButton) findViewById(R.id.addSemesterButton);

        addSemesterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SemesterListActivity.super.goToActivity(R.id.action_addsemester);
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //util.setCurrentSemester(sems.get(position));
                SemesterListActivity.super.goToActivity(R.id.action_classlist, "" + sems.get(position).getId());
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
