package com.cs321.group7.worksmart;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cs321.group7.worksmart.Entities.Class;

/**
 * Created by veeda on 11/28/2017.
 */

public class EditClassActivity extends BasicActivity {

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
        final Class current_class = util.getClassById(class_id);

        setTextOfBox(R.id.label_editclassname, current_class.getName());
        setTextOfBox(R.id.label_editprofessor, current_class.getProfessor());
        setTextOfBox(R.id.label_edituta, current_class.getUta());
        setTextOfBox(R.id.label_editgta, current_class.getGta());
        setTextOfBox(R.id.label_editlocation, current_class.getLocation());

        Button save_butt = (Button) findViewById(R.id.button_save);
        save_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                current_class.setName(getTextOfBox(R.id.label_editclassname));
                current_class.setProfessor(getTextOfBox(R.id.label_editprofessor));
                current_class.setUta(getTextOfBox(R.id.label_edituta));
                current_class.setGta(getTextOfBox(R.id.label_editgta));
                current_class.setLocation(getTextOfBox(R.id.label_editlocation));
                util.updateClass(current_class);

                EditClassActivity.super.goToActivity(R.id.action_classinfo, message);
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
