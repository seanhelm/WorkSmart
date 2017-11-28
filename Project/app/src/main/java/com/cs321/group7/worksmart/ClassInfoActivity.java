package com.cs321.group7.worksmart;

import android.content.Intent;
import android.net.Uri;
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
        Button removeClass = (Button) findViewById(R.id.removeclass);
        Button contactProf = (Button) findViewById(R.id.contactprofessor);
        Button contactUta = (Button) findViewById(R.id.contatctuta);
        Button contactGta = (Button) findViewById(R.id.contactgta);

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
        contactGta.setOnClickListener(new View.OnClickListener() {
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
