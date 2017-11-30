package com.cs321.group7.worksmart;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cs321.group7.worksmart.Entities.Class;

/**
 * Created by Chris on 11/26/2017.
 */

public class AddGradeActivity extends BasicActivity {

    EditText name;
    Button button_submit;
    SystemUtilities util;

    public void setTextOfBox(int textbox_id, String text) {
        final EditText textbox = (EditText) findViewById(textbox_id);
        textbox.setText(text);
    }

    public String getTextOfBox(int textbox_id) {
        final EditText textbox = (EditText) findViewById(textbox_id);
        return textbox.getText().toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addgrade);

        button_submit = (Button) findViewById(R.id.submit);
        name = (EditText) findViewById(R.id.label_editname);

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
        final Class current_class = util.getClassById(class_id);

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SystemUtilities util = new SystemUtilities(getApplicationContext());
                util.addGrade(current_class, getTextOfBox(R.id.label_editname), Float.parseFloat(getTextOfBox(R.id.label_editvalue)), Float.parseFloat(getTextOfBox(R.id.label_editweight)));
                util.updateClass(current_class);
                AddGradeActivity.super.goToActivity(R.id.action_tasklist, message);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_addgrade:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
