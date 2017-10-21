package com.aswaqqnet.it.aswaqqapp;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Drawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mFragmentManager=getSupportFragmentManager();
        mFragmentTransaction=mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.container,new HomeFragment()).commit();

//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        drawer.closeDrawers();
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }


        return super.onOptionsItemSelected(item);
    }

  Fragment newFragment;
//    FragmentTransaction transaction = getFragmentManager().beginTransaction();

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            //startActivity(new Intent(getApplicationContext(),HomeFragment.class));
            newFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, newFragment).commit();
            // transaction.replace(R.id.demo,newFragment);
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawers();
            return true;
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

            newFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, newFragment).commit();
            // transaction.replace(R.id.demo,newFragment);
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawers();
            return true;
        } else if (id == R.id.nav_slideshow) {
            newFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, newFragment).commit();
            // transaction.replace(R.id.demo,newFragment);
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawers();
            return true;

        } else if (id == R.id.nav_manage) {
            newFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, newFragment).commit();
            // transaction.replace(R.id.demo,newFragment);
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawers();
            return true;

        } else if (id == R.id.nav_share) {
            newFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, newFragment).commit();
            // transaction.replace(R.id.demo,newFragment);
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawers();
            return true;

        } else if (id == R.id.nav_send) {
            newFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, newFragment).commit();
            // transaction.replace(R.id.demo,newFragment);
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawers();
            return true;

        }
        else if(id==R.id.clothes_women)
        {
            newFragment=new WomenCloth();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, newFragment).commit();
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawers();
            return true;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.END);
        drawer.closeDrawers();
        return true;
    }

}
