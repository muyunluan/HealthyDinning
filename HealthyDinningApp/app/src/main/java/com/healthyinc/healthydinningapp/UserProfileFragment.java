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
public class UserProfileFragment extends Fragment {
    public UserProfileFragment() {

    }

    public static UserProfileFragment newInstance() {
        UserProfileFragment userProfileFragment = new UserProfileFragment();
        return userProfileFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        return view;
    }
}
