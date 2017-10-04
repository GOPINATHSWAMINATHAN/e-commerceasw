package com.aswaqqnet.it.aswaqqapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.stephentuso.welcome.WelcomeHelper;

public class MainActivity extends AppCompatActivity {
    Button check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        check = (Button) findViewById(R.id.fazalur);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ProductDisplay.class));
            }
        });
    }
}
////        check=(Button)findViewById(R.id.fazalur);
////        check.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Toast.makeText(getApplicationContext(),"OH!!! You won Lenovo Note 5",Toast.LENGTH_LONG).show();
////            }
////        });
//
//    mDrawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
//        mNavigationView=(NavigationView)findViewById(R.id.nav_view);
////toolbar=(Toolbar)findViewById(R.id.toolbar);
//
//        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
//        mNavigationView=(NavigationView)findViewById(R.id.nav_view);
//        setupDrawerContent(mNavigationView);
////        mFragmentManager=getSupportFragmentManager();
////        mFragmentTransaction=mFragmentManager.beginTransaction();
////        mFragmentTransaction.replace(R.id.container,new HomeFragment()).commit();
//
//
////
////     public boolean onNavigationItemSelected ( MenuItem item){
////         if (item.getItemId() == R.id.nav_camera) {
////             FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
////             fragmentTransaction.replace(R.id.container, new HomeFragment());
////         }
////
////         return false;
////     }
//// }
////
////
////
////android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
////        ActionBarDrawerToggle mDrawerToggle=new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
////        mDrawerLayout.addDrawerListener(mDrawerToggle);
////        mDrawerToggle.syncState();
//    }
//
//    public boolean onOptionItemSelected(MenuItem item)
//    {
//        switch(item.getItemId())
//        {
//            case android.R.id.home:
//                mDrawerLayout.openDrawer(GravityCompat.START);
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//    private void setupDrawerContent(NavigationView navigationView)
//    {
//       new NavigationView.OnNavigationItemSelectedListener()
//       {
//
//           @Override
//           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            selectDrawerItem(item);
//               return true;
//           }
//       };
//    }
//    public void selectDrawerItem(MenuItem menuItem)
//    {
//        Fragment fragment=null;
//        Class fragmentClass;
//        switch(menuItem.getItemId())
//        {
//            case R.id.nav_camera:
//                fragmentClass=HomeFragment.class;
//
//            break;
//            default:
//                fragmentClass=HomeFragment.class;
//        }
//        try
//        {
//            fragment=(Fragment)fragmentClass.newInstance();
//        }catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//FragmentManager fragmentManager=getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.nav_view,fragment).commit();
//        menuItem.setCheckable(true);
//        setTitle(menuItem.getTitle());
//        mDrawerLayout.closeDrawers();
//    }
