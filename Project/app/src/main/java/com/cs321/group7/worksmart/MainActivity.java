package com.cs321.group7.worksmart;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
<<<<<<< HEAD
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
=======
import android.content.Context;
>>>>>>> refs/remotes/origin/master

/**
 * Created by Chris on 11/26/2017.
 */

public class MainActivity extends BasicActivity {

    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    int clickCounter = 0;

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
        listview = (ListView) findViewById(R.id.my_list);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        listview.setAdapter(adapter);

        Button butt = (Button) findViewById(R.id.button2);

        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listItems.add("Clicked : " + clickCounter++);
                adapter.notifyDataSetChanged();
            }
        });
=======
        //Use for performing commands that are stored in the System Utilities layer
        SystemUtilities util = new SystemUtilities(getApplicationContext());
>>>>>>> refs/remotes/origin/master
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
