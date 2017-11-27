package com.cs321.group7.worksmart;

import android.os.Bundle;
import android.view.MenuItem;

/**
 * Created by Chris on 11/26/2017.
 */

public class ClassListActivity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classlist);
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
