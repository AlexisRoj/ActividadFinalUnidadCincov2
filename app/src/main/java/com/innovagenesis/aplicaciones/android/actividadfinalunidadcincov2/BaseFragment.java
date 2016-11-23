package com.innovagenesis.aplicaciones.android.actividadfinalunidadcincov2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment {

    private String name;
    private static final String ARG_NAME = "name";


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public BaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base, container, false);
    }

    public static Fragment getInstance(String name) {
        BaseFragment fragment = new BaseFragment();

        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null)
            name = args.getString(ARG_NAME);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((TextView) view.findViewById(R.id.text_name)).setText(this.name);
    }
}
