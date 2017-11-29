package com.cs321.group7.worksmart;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cs321.group7.worksmart.Entities.Class;

/**
 * Created by veeda on 11/27/2017.
 */

public class ClassInfoActivity extends BasicActivity {

    SystemUtilities util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classinfo);

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

        TextView sem_name = (TextView) findViewById(R.id.classname);
        sem_name.setText(current_class.getName());

        TextView loc = (TextView) findViewById(R.id.label_editlocation);
        loc.setText(current_class.getLocation());


        Button editClass = (Button) findViewById(R.id.editclass);
//        Button contactProf = (Button) findViewById(R.id.contactprofessor);
//        Button contactUta = (Button) findViewById(R.id.contatctuta);

        editClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassInfoActivity.super.goToActivity(R.id.action_editclass, message);
            }
        });


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
