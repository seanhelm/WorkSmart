package com.cs321.group7.worksmart;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by Chris on 11/26/2017.
 */

public class ClassListActivity extends BasicActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classlist);

        Button Class1 = (Button) findViewById(R.id.class1);
        Button Class2 = (Button) findViewById(R.id.class2);
        Button Class3 = (Button) findViewById(R.id.class3);
        Button Class4 = (Button) findViewById(R.id.class4);
        Button Class5 = (Button) findViewById(R.id.class5);
        Button Class6 = (Button) findViewById(R.id.class6);
        Button Class7 = (Button) findViewById(R.id.class7);
        Button Class8 = (Button) findViewById(R.id.class8);

        Class1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ClassListActivity.super.goToActivity(R.id.action_classinfo);
            }
        });
        Class2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassListActivity.super.goToActivity(R.id.action_classinfo);
            }
        });
        Class3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassListActivity.super.goToActivity(R.id.action_classinfo);
            }
        });
        Class4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassListActivity.super.goToActivity(R.id.action_classinfo);
            }
        });
        Class5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassListActivity.super.goToActivity(R.id.action_classinfo);
            }
        });
        Class6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassListActivity.super.goToActivity(R.id.action_classinfo);
            }
        });
        Class7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassListActivity.super.goToActivity(R.id.action_classinfo);
            }
        });
        Class8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassListActivity.super.goToActivity(R.id.action_classinfo);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_classlist:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
