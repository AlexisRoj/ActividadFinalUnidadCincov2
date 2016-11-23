package com.innovagenesis.aplicaciones.android.actividadfinalunidadcincov2;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
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

    private String[] tabs;
    private TypedArray imgTabs;
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

        MainActivity activity = (MainActivity) getActivity();
        id = activity.getPositionArray();

        switch (id) {

            /** Seleciona la lista a desplegar de iconos e imagenes*/
            case 1:
                tabs = getContext().getResources().getStringArray(R.array.facebookTabs);
                imgTabs = getContext().getResources().obtainTypedArray(R.array.facebookImg);
                break;
            case 2:
                tabs = getContext().getResources().getStringArray(R.array.instagramTabs);
                imgTabs = getContext().getResources().obtainTypedArray(R.array.twiterImg);
                break;
            case 3:
                tabs = getContext().getResources().getStringArray(R.array.plusTabs);
                imgTabs = getContext().getResources().obtainTypedArray(R.array.plusImg);
                break;
            case 4:
                tabs = getContext().getResources().getStringArray(R.array.twiterTabs);
                imgTabs = getContext().getResources().obtainTypedArray(R.array.twiterImg);
                break;
        }

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        viewPager.setAdapter(new BookViewPagerAdapter(getActivity().getSupportFragmentManager()));

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);


        /**
         *
         * Administra los colores del drawer, toolbar y tabs
         *
         * */

        @SuppressLint("Recycle")
        TypedArray arrayColorToolbar = getResources().obtainTypedArray(R.array.colorToolbar);


        int color = arrayColorToolbar.getResourceId(id, 0);
        int cambiarColor = ContextCompat.getColor(activity.getBaseContext(), color);

        Drawable toolbarColor = new ColorDrawable(cambiarColor);

        if (activity.getSupportActionBar() != null) {
            activity.getSupportActionBar().setBackgroundDrawable(toolbarColor);
        }

        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().setStatusBarColor(cambiarColor);
        }

        /** Incerta el icono en el tab */

        for (int i = 0; i < imgTabs.length(); i++) {

            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null){
                tab.setIcon(imgTabs.getResourceId(i,0));
            }
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String title = getString(R.string.app_name);
        String subTitle = null;
        int check = 0;
        /** Selector de titulos de toolbar*/

        MainActivity activity = (MainActivity) getActivity();

        switch (id){
            case 1:
                subTitle = getString(R.string.facebook);
                check = R.id.nav_facebook;
                break;
            case 2:
                subTitle = getString(R.string.instragram);
                check = R.id.nav_instagram;
                break;
            case 3:
                subTitle = getString(R.string.google_plus);
                check = R.id.nav_plus;
                break;
            case 4:
                subTitle = getString(R.string.tweeter);
                check = R.id.nav_tweeter;
                break;
        }

        /** Actualiza el titulo*/

        activity.updateView(title, subTitle);
        activity.navigationView.setCheckedItem(check);
    }

    private class BookViewPagerAdapter extends BaseViewPagerAdapter {

        public BookViewPagerAdapter(FragmentManager manager) {
            super(manager, tabs);
        }


    }
}




