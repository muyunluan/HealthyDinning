package com.healthyinc.healthydinningapp;

import android.support.v4.app.Fragment;

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
}
