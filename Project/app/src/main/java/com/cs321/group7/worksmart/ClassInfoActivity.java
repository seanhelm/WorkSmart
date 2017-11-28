package com.cs321.group7.worksmart;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by Chris on 11/26/2017.
 */

public class ClassInfoActivity extends BasicActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classinfo);

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
