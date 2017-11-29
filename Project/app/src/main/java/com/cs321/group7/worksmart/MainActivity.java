package com.cs321.group7.worksmart;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;

/**
 * Created by Chris on 11/26/2017.
 */

public class MainActivity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Use for performing commands that are stored in the System Utilities layer
        SystemUtilities util = new SystemUtilities(getApplicationContext());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_main:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
