package com.cs321.group7.worksmart;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.cs321.group7.worksmart.Entities.Semester;

/**
 * Created by Chris on 11/26/2017.
 */

public class ClassListActivity extends BasicActivity {
    SystemUtilities util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classlist);

        util = new SystemUtilities(getApplicationContext());

        FloatingActionButton addClassButton = (FloatingActionButton) findViewById(R.id.addClassButton);

        addClassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassListActivity.super.goToActivity(R.id.action_addclass);
            }
        });

        String message;
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

        Long sem_id = Long.parseLong((message));
        Semester semester = util.getSemesterById(sem_id);

        TextView sem_name = (TextView) findViewById(R.id.semester_name_tag);
        sem_name.setText(semester.getName()+" Classes:");
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
