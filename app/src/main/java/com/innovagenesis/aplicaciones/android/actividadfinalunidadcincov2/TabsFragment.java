package com.innovagenesis.aplicaciones.android.actividadfinalunidadcincov2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.innovagenesis.aplicaciones.android.actividadfinalunidadcincov2.adapter.BaseViewPagerAdapter;

/**
 * Administra los tabs
 * Created by Alexis on 22/11/2016.
 */

public class TabsFragment extends Fragment {

    private String [] tabs;
    int id;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.app_bar_with_tabs, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainActivity activity = (MainActivity)getActivity();
        id = activity.getPositionArray();

        switch (id){

            /** Seleciona la lista a desplegar*/
            case 1:
                tabs = getContext().getResources().getStringArray(R.array.facebookTabs);
                break;
            case 2:
                tabs = getContext().getResources().getStringArray(R.array.instagramTabs);
                break;
            case 3:
                tabs = getContext().getResources().getStringArray(R.array.plusTabs);
                break;
            case 4:
                tabs = getContext().getResources().getStringArray(R.array.twiterTabs);
                break;
        }

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        viewPager.setAdapter(new BookViewPagerAdapter(getActivity().getSupportFragmentManager()));

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        MainActivity activity = (MainActivity) getActivity();

        String data = getString(R.string.facebook);
        activity.updateView(data,data);


        activity.navigationView.setCheckedItem(R.id.nav_facebook);
    }


    private class BookViewPagerAdapter extends BaseViewPagerAdapter {

        public BookViewPagerAdapter(FragmentManager manager) {
            super(manager, tabs);
        }


    }
}




