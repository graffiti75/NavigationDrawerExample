package com.example.android.navigationdrawerexample;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    private DrawerLayout mDrawerLayout;

    //--------------------------------------------------
    // Activity Life Cycle
    //--------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar();
        setDrawerLayout();
        setViewPager();
    }

    //--------------------------------------------------
    // Methods
    //--------------------------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //--------------------------------------------------
    // Methods
    //--------------------------------------------------

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_activity_main__toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("");
    }

    private void setDrawerLayout() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_activity_main__drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.id_activity_main__navigation_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }
    }

    private void setViewPager() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.id_activity_main__view_pager);
        if (viewPager != null) {
            ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
            adapter.addFragment(new SimpleListFragment(), "Category 1");
            adapter.addFragment(new SimpleListFragment(), "Category 2");
            adapter.addFragment(new SimpleListFragment(), "Category 3");
            viewPager.setAdapter(adapter);
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.id_activity_main__tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
            new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }
}