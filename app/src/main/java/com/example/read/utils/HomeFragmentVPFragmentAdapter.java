package com.example.read.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class HomeFragmentVPFragmentAdapter extends FragmentStatePagerAdapter {
    List<Fragment> listfragment;
    List<String> listtitle;

    public HomeFragmentVPFragmentAdapter(FragmentManager fm, List<Fragment> listfragment, List<String> listtitle) {
        super(fm);
        this.listfragment = listfragment;
        this.listtitle = listtitle;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listtitle.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return listfragment.get(position);
    }

    @Override
    public int getCount() {
        return listfragment.size();
    }
}