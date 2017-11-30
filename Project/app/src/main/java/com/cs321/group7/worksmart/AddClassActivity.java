package com.cs321.group7.worksmart;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cs321.group7.worksmart.Entities.Semester;

/**
 * Created by Chris on 11/26/2017.
 */

public class AddClassActivity extends BasicActivity {

    EditText name;
    Button addSemesterButton;
    SystemUtilities util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addclass);

        addSemesterButton = (Button) findViewById(R.id.submit);
        name = (EditText) findViewById(R.id.label_editdate);

        util = new SystemUtilities(getApplicationContext());

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

        Long sem_id = Long.parseLong((message));

        final Semester semester = util.getSemesterById(sem_id);


        addSemesterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SystemUtilities util = new SystemUtilities(getApplicationContext());
                util.addClass(semester, name.getText().toString(), "", "", "", "");
                AddClassActivity.super.goToActivity(R.id.action_classlist, message);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_addclass:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
