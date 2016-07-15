package com.healthyinc.healthydinningapp.fragment.account;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.healthyinc.healthydinningapp.R;

/**
 * Created by Fei Deng on 7/14/16.
 * Copyright (c) 2016 Ayla. All rights reserved.
 */
public class UserDietDataFragment extends Fragment {

    private View mView;
    private Context mContext;

    public UserDietDataFragment() {}

    public static UserDietDataFragment newInstance() {
        UserDietDataFragment userDietDataFragment = new UserDietDataFragment();
        return userDietDataFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_user_diet_data, container, false);
        mContext = mView.getContext();

        return mView;
    }
}
