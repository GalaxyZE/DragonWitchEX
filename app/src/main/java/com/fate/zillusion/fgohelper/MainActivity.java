package com.fate.zillusion.fgohelper;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.net.HttpURLConnection;

public class MainActivity extends AppCompatActivity
        implements
        News.OnFragmentInteractionListener,
        fragment_Event.OnFragmentInteractionListener,
        servent2.OnFragmentInteractionListener,
        FragmentCraftEssence.OnFragmentInteractionListener,
        NavigationView.OnNavigationItemSelectedListener {
    //region Valueables
    private FirebaseAnalytics mFirebaseAnalytics;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);// Obtain the FirebaseAnalytics instance.

        MobileAds.initialize(this, "ca-app-pub-8418426477328402~2027922183");

        ///region StatusBar Color
        Window window = MainActivity.this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(R.style.AppTheme1);
        //endregion
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Log.d("MainActivity-CreateView", "nav_view");
        //region ListView
        /*
        ListView listView=(ListView) findViewById(R.id.listview);
        CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid,itemdes);
        listView=(ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);
        //Click_ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem= itemname[+position];
                //Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();//Inner
                //Toast.makeText(getApplicationContext(),String.valueOf(+position),Toast.LENGTH_SHORT).show();//Display position

                //region 傳值
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,Servent_Query_Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("BundleServent",String.valueOf(+position));
                intent.putExtras(bundle);
                startActivity(intent);
                //endregion
            }
        });
        */
        //endregion

        //region Fragment
        //NOTE:  Checks first item in the navigation drawer initially
        //navigationView.setCheckedItem(R.id.nav_News);
        navigationView.setCheckedItem(R.id.nav_Servent);
        //NOTE:  Open fragment1 initially.
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //ft.replace(R.id.mainFrame, new News());
        ft.replace(R.id.mainFrame,new servent2());
        ft.commit();

        //endregion
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent myIntent = new Intent(this,setting.class);
            this.startActivity(myIntent);
            return true;
        }/*
        else if(id==R.id.action_WebVersion)
        {
            Intent myIntent = new Intent(this,test.class);
            this.startActivity(myIntent);
            return true;
        }

        else if (id==R.id.action_WebPage)
        {
            Intent myIntent = new Intent(this,WebActivity.class);
            this.startActivity(myIntent);
            return true;
        }
        else if(id==R.id.action_Tab)
        {
            Intent myIntent = new Intent(this,TabActivity.class);
            this.startActivity(myIntent);
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment=null;

        if (id == R.id.nav_News) {
            //Toast.makeText(getApplicationContext(), "Click", Toast.LENGTH_SHORT).show();
            fragment=new News();
        }else if (id==R.id.nav_Event){
            fragment=new fragment_Event();
        }
        else if (id == R.id.nav_Servent) {
           fragment=new servent2();
        } else if (id == R.id.nav_CraftEssence) {
            //fragment=new FragmentCraftEssence();
            Intent myIntent = new Intent(this,WebActivity.class);
            this.startActivity(myIntent);
        } else if (id == R.id.nav_about){
            Intent myIntent=new Intent(this,About.class);
            this.startActivity(myIntent);
        }

        //region Fragment

        //NOTE: Fragment changing code
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, fragment);
            ft.commit();
        }
        //NOTE:  Closing the drawer after selecting
        DrawerLayout drawer = findViewById(R.id.drawer_layout); //Ya you can also globalize this variable :P
        drawer.closeDrawer(GravityCompat.START);

        //endregion
        return true;
    }

    @Override
    public void onFragmentInteraction(String title) {
        getSupportActionBar().setTitle(title);
    }
}
