package com.cs321.group7.worksmart;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.cs321.group7.worksmart.Entities.Class;

/**
 * Created by Chris on 11/28/2017.
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

    public void setCheckbox(int textbox_id, boolean checked) {
        final CheckBox checkbox = (CheckBox) findViewById(textbox_id);
        checkbox.setChecked(checked);
    }

    public boolean getCheckbox(int textbox_id) {
        final CheckBox checkbox = (CheckBox) findViewById(textbox_id);
        return checkbox.isChecked();
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

        setCheckbox(R.id.check_monday, current_class.getDay(0));
        setCheckbox(R.id.check_tuesday, current_class.getDay(1));
        setCheckbox(R.id.check_wednesday, current_class.getDay(2));
        setCheckbox(R.id.check_thursday, current_class.getDay(3));
        setCheckbox(R.id.check_friday, current_class.getDay(4));
        setCheckbox(R.id.check_saturday, current_class.getDay(5));

        setTextOfBox(R.id.editstartime, current_class.getClass_start_time());
        setTextOfBox(R.id.editendtime, current_class.getClass_end_time());

        Button save_butt = (Button) findViewById(R.id.button_save);
        save_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                current_class.setName(getTextOfBox(R.id.label_editclassname));
                current_class.setProfessor(getTextOfBox(R.id.label_editprofessor));
                current_class.setUta(getTextOfBox(R.id.label_edituta));
                current_class.setGta(getTextOfBox(R.id.label_editgta));
                current_class.setLocation(getTextOfBox(R.id.label_editlocation));

                current_class.setDay(0, getCheckbox(R.id.check_monday));
                current_class.setDay(1, getCheckbox(R.id.check_tuesday));
                current_class.setDay(2, getCheckbox(R.id.check_wednesday));
                current_class.setDay(3, getCheckbox(R.id.check_thursday));
                current_class.setDay(4, getCheckbox(R.id.check_friday));
                current_class.setDay(5, getCheckbox(R.id.check_saturday));

                current_class.setClass_start_time(getTextOfBox(R.id.editstartime));
                current_class.setClass_end_time(getTextOfBox(R.id.editendtime));

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
