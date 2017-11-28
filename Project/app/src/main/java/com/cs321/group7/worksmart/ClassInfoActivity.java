package com.cs321.group7.worksmart;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by veeda on 11/27/2017.
 */

public class ClassInfoActivity extends BasicActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classinfo);

        Button editClass = (Button) findViewById(R.id.editclass);
        Button contactProf = (Button) findViewById(R.id.contactprofessor);
        Button contactTA = (Button) findViewById(R.id.contactta);

        editClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassInfoActivity.super.goToActivity(R.id.action_editclass);

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
