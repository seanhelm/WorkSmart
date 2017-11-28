package com.cs321.group7.worksmart;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by veeda on 11/28/2017.
 */

public class EditClassActivity extends BasicActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editclass);

        EditText editClass = (EditText) findViewById(R.id.editclassname);

        editClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditClassActivity.super.goToActivity(R.id.action_editclass);
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
