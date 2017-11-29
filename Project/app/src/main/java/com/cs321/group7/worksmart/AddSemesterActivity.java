package com.cs321.group7.worksmart;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by Chris on 11/26/2017.
 */

public class AddSemesterActivity extends BasicActivity {
    EditText name;
    Button addSemesterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addsemester);

        name = (EditText) findViewById(R.id.semesterName);
        addSemesterButton = (Button) findViewById(R.id.submit);

        addSemesterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SystemUtilities util = new SystemUtilities(getApplicationContext());
                util.addSemester(name.getText().toString());
                AddSemesterActivity.super.goToActivity(R.id.action_semesterlist);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_addsemester:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
