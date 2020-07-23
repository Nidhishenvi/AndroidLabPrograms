package com.example.fabandtab;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new frag_1();
                break;

            case 1:
                fragment = new frag_2();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    public  CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "Fragment Blue";

            case 1:
                return "Fragment Green";
        }
        return null;
    }
}

