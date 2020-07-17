package com.dikamjitborah.hobarb.ohweather.views.fragment.adapters;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    List<String> fragmentTitleList = new ArrayList<>();
    List<Fragment> fragmentList = new ArrayList<>();



    public ViewPagerAdapter(@NonNull FragmentManager fm) {
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
        return fragmentTitleList.get(position);
    }

    public void  add_New_Fragment(Fragment fragment, String title, String latitude, String longitude)
    {
        Bundle bundle = new Bundle();
        bundle.putString("LATITUDE", latitude);
        bundle.putString("LONGITUDE", longitude);
        fragment.setArguments(bundle);
        fragmentList.add(fragment);
        fragmentTitleList.add(title);
    }
}
