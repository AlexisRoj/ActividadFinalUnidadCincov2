package com.innovagenesis.aplicaciones.android.actividadfinalunidadcincov2.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.innovagenesis.aplicaciones.android.actividadfinalunidadcincov2.BaseFragment;

/**
 * Adaptador encargado de rellenar los tabs.
 * Created by Alexis on 22/11/2016.
 */

public class BaseViewPagerAdapter extends FragmentStatePagerAdapter {

    private String[] tabs;

    public BaseViewPagerAdapter(FragmentManager fm, String[] tabs) {
        super(fm);
        this.tabs = tabs;
    }

    @Override
    public Fragment getItem(int position) {
        return BaseFragment.getInstance(tabs[position]);
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
