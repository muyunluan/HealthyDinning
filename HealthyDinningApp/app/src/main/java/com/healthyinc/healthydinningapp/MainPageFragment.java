package com.healthyinc.healthydinningapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Fei Deng on 6/12/16.
 * Copyright (c) 2015 Ayla. All rights reserved.
 */
public class MainPageFragment extends Fragment {

    public MainPageFragment() {

    }

    public static MainPageFragment newInstance() {
        MainPageFragment mainPageFragment = new MainPageFragment();
        return mainPageFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_page, container, false);
        return view;
    }
}
