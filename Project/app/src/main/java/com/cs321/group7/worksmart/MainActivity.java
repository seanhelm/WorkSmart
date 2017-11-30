package com.cs321.group7.worksmart;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cs321.group7.worksmart.Entities.Class;
import com.cs321.group7.worksmart.Entities.Semester;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * Created by Chris on 11/26/2017.
 */

public class MainActivity extends BasicActivity {

    ArrayList<String> listItems = new ArrayList<String>();
    ArrayList<Long> listItemsIDs = new ArrayList<Long>();
    ArrayAdapter<String> adapter;
    SystemUtilities util;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.my_list);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        listview.setAdapter(adapter);


        TextView loc = (TextView) findViewById(R.id.textView);

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        switch (day) {
            case Calendar.SUNDAY:
                loc.setText("Classes Today!" + " (Sunday)");
                break;

            case Calendar.MONDAY:
                loc.setText("Classes Today!" + " (Monday)");
                break;

            case Calendar.TUESDAY:
                loc.setText("Classes Today!"+" (Tuesday)");
                break;

            case Calendar.WEDNESDAY:
                loc.setText("Classes Today!"+" (Wednesday)");
                break;

            case Calendar.THURSDAY:
                loc.setText("Classes Today!"+" (Thursday)");
                break;

            case Calendar.FRIDAY:
                loc.setText("Classes Today!"+" (Friday)");
                break;

            case Calendar.SATURDAY:
                loc.setText("Classes Today!"+" (Saturday)");
                break;
        }


        util = new SystemUtilities(getApplicationContext());

        List<Semester> sems = util.getAllSemesters();
        for (int i = 0; i < sems.size(); i++) {
            List<Class> classes = util.getClassesForSemester(sems.get(i));

            for (int j = 0; j < classes.size(); j++) {
                if (classes.get(j).getDay(day-2)) {
                    listItems.add(classes.get(j).getName() + " at " + classes.get(j).getClass_start_time());
                    listItemsIDs.add(classes.get(j).getId());
                }
            }
        }

        adapter.notifyDataSetChanged();

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.super.goToActivity(R.id.action_classinfo, "" + listItemsIDs.get(position));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_main:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
