package com.innovagenesis.aplicaciones.android.actividadfinalunidadcincov2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.app_bar_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() instanceof MainActivity){

            /** Cambia el titulo y el subtitulo del Toolbar*/
            String title = getString(R.string.app_name);
            String subTitle = getString(R.string.home);

            MainActivity activity = (MainActivity) getActivity();

            activity.updateView(title,subTitle);
            activity.navigationView.setCheckedItem(R.id.nav_home);



        }
    }
}
