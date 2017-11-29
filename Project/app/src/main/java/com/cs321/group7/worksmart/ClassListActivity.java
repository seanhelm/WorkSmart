package com.cs321.group7.worksmart;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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

        FloatingActionButton addClassButton = (FloatingActionButton) findViewById(R.id.addClassButton);

        addClassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassListActivity.super.goToActivity(R.id.action_addclass);
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
