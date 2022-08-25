package com.example.azka.noreen.portal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragmentArrayList;
    ArrayList<String> Title;
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragmentArrayList=new ArrayList<>();
        Title=new ArrayList<>();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }
    public void addFragment(Fragment fragment,String title){
        fragmentArrayList.add(fragment);
        Title.add(title);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    //for tab
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        //return super.getPageTitle(position);
        return Title.get(position);

    }
}

