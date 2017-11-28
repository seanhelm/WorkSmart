package com.cs321.group7.worksmart;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;

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
        Button contactUta = (Button) findViewById(R.id.contatctuta);


        editClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassInfoActivity.super.goToActivity(R.id.action_editclass);
            }
        });
        contactProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://mailto:fakeEmail@gmu.edu");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        contactUta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://mailto:fakeEmail@gmu.edu");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
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
