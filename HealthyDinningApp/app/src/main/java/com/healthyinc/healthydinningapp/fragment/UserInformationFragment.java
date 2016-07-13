package com.healthyinc.healthydinningapp.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by Fei Deng on 7/12/16.
 * Copyright (c) 2016 Ayla. All rights reserved.
 */
public class UserInformationFragment extends Fragment {

    private View mView;
    private Context mContext;

    public UserInformationFragment() {

    }

    public static UserInformationFragment newInstance() {
        UserInformationFragment userInformationFragment = new UserInformationFragment();
        return userInformationFragment;
    }


}
