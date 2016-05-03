package com.abd.zaher88.swaqny;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationDrawerFragment.DrawerLisner {
    Toolbar toolbar;
    private DrawerLayout mDrawLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_main);
            setUpToolbar();
            setUpDrawer();
        } catch (Exception ex) {
            Log.d("OnCreate", ex.getMessage());
        }
    }

    private void setUpToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void setUpDrawer() {
        try {
            NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                    getSupportFragmentManager().findFragmentById(R.id.nav_drwr_fragment);
            DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawerFragment.setUpDrawer(R.id.nav_drwr_fragment, drawerLayout, toolbar);
        } catch (Exception e) {
            Log.d("main1_activity.setUpDrawer", e.getMessage());
        }
    }


    @Override
    public void setCatigoryMaterial(int Id) {
        try {
            Toast.makeText(this, "Category Name :" + Id, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.d("setCatigoryMaterial ", e.getMessage());
        }
    }


}
