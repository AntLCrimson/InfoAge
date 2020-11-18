package com.tuition.infoage;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.fragment.app.Fragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeAcitivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Menu menu;
    TabLayout tabLayout;
    ViewPager viewPager;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayou);
        viewPager = findViewById(R.id.view_pager);
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("Latest");
        arrayList.add("Popular");
        arrayList.add("Playlist");
        prepareViewPager(viewPager,arrayList);
        tabLayout.setupWithViewPager(viewPager);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=new
                ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }
    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {super.onBackPressed();
        }
    }
    private void prepareViewPager(ViewPager viewPager, ArrayList<String> arrayList){
        MainAdapter adapter= new MainAdapter(getSupportFragmentManager());
        LatestFragment fragment= new LatestFragment();
        for(int i=0;i<arrayList.size();i++){
            Bundle bundle= new Bundle();
            bundle.putString("tille",arrayList.get(i));
            fragment.setArguments(bundle);
            adapter.addFragment(fragment, arrayList.get(i));
            fragment=new LatestFragment();
        }
        viewPager.setAdapter(adapter);
    }
    }
    class MainAdapter extends FragmentPagerAdapter{
        ArrayList<String> arrayList= new ArrayList<>();
        List<Fragment> fragmentList= new ArrayList<>();
        public void addFragment(Fragment fragment, String title){
            arrayList.add(title);
            fragmentList.add(fragment);
        }


        public MainAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return arrayList.get(position);
        }
    }