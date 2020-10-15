package com.tuition.infoage;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    private int numOfTabs;
    //Page adapter constructor
    //Communicates between this class and the main activity
    public PagerAdapter(FragmentManager fm, int numOfTabs){
        super(fm);
        this.numOfTabs = numOfTabs;
    }
    @Override
    public Fragment getItem(int position) { //
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new TeachersFragment();
            case 2:
                return new StudentsFragment();
            case 3:
                return new ForumsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() { //Counts how many tabs we have
        return numOfTabs;
    }
}
