package com.healthyinc.healthydinningapp.fragment.account;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.healthyinc.healthydinningapp.R;

/**
 * Created by Fei Deng on 7/13/16.
 * Copyright (c) 2016 Ayla. All rights reserved.
 */
public class UserBasicDataFragment extends Fragment {

    private View mView;
    private Context mContext;

    public UserBasicDataFragment() {}

    public static UserBasicDataFragment newInstance() {

        Bundle args = new Bundle();

        UserBasicDataFragment fragment = new UserBasicDataFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.cardview_user_basic_data, container, false);
        mContext = mView.getContext();


        return mView;
    }

}
