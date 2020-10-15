package com.tuition.infoage;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize and declare the tab layout, items and pager

        //The tab layout
        TabLayout tabLayout = findViewById(R.id.tabBar);

        //The tab items
        TabItem HomeTab = findViewById(R.id.HomeTab);
        TabItem TeachersTab = findViewById(R.id.TeachersTab);
        TabItem StudentsTab = findViewById(R.id.StudentsTab);
        TabItem ForumsTab = findViewById(R.id.ForumsTab);

        //Pager adapter
        final ViewPager viewPager = findViewById(R.id.ViewPager);

        //Define PagerAdapter
        PagerAdapter pagerAdapter = new
                PagerAdapter(getSupportFragmentManager(),
                tabLayout.getTabCount());

        viewPager.setAdapter(pagerAdapter);

        //Changes tabs view when tab is selected
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.
                TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}