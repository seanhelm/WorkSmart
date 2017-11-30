package com.cs321.group7.worksmart;

import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

public class BasicActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private DrawerLayout fullLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;
    private int selectedNavItemId;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        fullLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_basic, null);
        FrameLayout activityContainer = (FrameLayout) fullLayout.findViewById(R.id.activity_content);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);
        super.setContentView(fullLayout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (NavigationView) findViewById(R.id.navigationView);

        if (useToolbar()) {
            setSupportActionBar(toolbar);
        } else {
            toolbar.setVisibility(View.GONE);
        }

        setUpNavView();
    }

    protected boolean useToolbar() {
        return true;
    }

    protected boolean useHamburger() {
        return true;
    }

    protected void setUpNavView() {
        navigationView.setNavigationItemSelectedListener(this);

        if (useHamburger()) {
            drawerToggle = new ActionBarDrawerToggle(this, fullLayout, toolbar, R.string.nav_drawer_opened, R.string.nav_drawer_closed);
            drawerToggle.syncState();
        } else if (useToolbar() && getSupportActionBar() != null) {
            // Use home/back button instead
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        fullLayout.closeDrawer(GravityCompat.START);
        selectedNavItemId = menuItem.getItemId();

        return onOptionsItemSelected(menuItem);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        goToActivity(id);

        return super.onOptionsItemSelected(item);
    }

    public void goToActivity(int id) {
        goToActivity(id, null);
    }

    public void goToActivity(int id, String message) {

        Class c = null;

        switch (id) {
            case R.id.action_main:
                c = MainActivity.class;
                break;

            case R.id.action_classlist:
                c = ClassListActivity.class;
                break;

            case R.id.action_editclass:
                c = EditClassActivity.class;
                break;

            case R.id.debug_make_me_disappear:
                Log.d("Heads up!", "You clicked the disappearing one.");
                invalidateOptionsMenu();
                break;

            case R.id.action_settings:
                c = SettingsActivity.class;
                break;

            case R.id.action_classinfo:
                c = ClassInfoActivity.class;
                break;

            case R.id.action_addclass:
                c = AddClassActivity.class;
                break;

            case R.id.action_addsemester:
                c = AddSemesterActivity.class;
                break;

            case R.id.action_semesterlist:
                c = SemesterListActivity.class;
                break;


            case R.id.action_tasklist:
                c = TaskListActivity.class;
                break;

            case R.id.action_addtask:
                c = AddTaskActivity.class;
                break;

            case R.id.action_addgrade:
                c = AddGradeActivity.class;
                break;

            case R.id.action_about:
                c = About.class;
                break;

            default:
                c = MainActivity.class;
                Log.d("Heads up!", "Add this activity to the switch statement");
                break;
        }

        Intent i = (new Intent(this, c));

        if (message != null)
            i.putExtra("MESSAGE", message);

        startActivity(i);
    }
}
