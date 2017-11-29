package com.cs321.group7.worksmart;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.cs321.group7.worksmart.Entities.Class;

/**
 * Created by veeda on 11/28/2017.
 */

public class EditClassActivity extends BasicActivity {

    SystemUtilities util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editclass);

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

        Long class_id = Long.parseLong(message);
        Class current_class = util.getClassById(class_id);

        EditText editClass = (EditText) findViewById(R.id.label_editclassname);
        editClass.setText(current_class.getName());




//        EditText editClass = (EditText) findViewById(R.id.label_editclassname);
//
//        editClass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                EditClassActivity.super.goToActivity(R.id.action_editclass);
//            }
//        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_classinfo:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
