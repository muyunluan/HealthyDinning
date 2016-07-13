package com.healthyinc.healthydinningapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.healthyinc.healthydinningapp.R;

/**
 * Created by Fei Deng on 6/12/16.
 * Copyright (c) 2015 Ayla. All rights reserved.
 */
public class UserProfileFragment extends Fragment {
    private View mView;
    private Context mContext;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    public UserProfileFragment() {

    }

    public static UserProfileFragment newInstance() {
        UserProfileFragment userProfileFragment = new UserProfileFragment();
        return userProfileFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_user_profile_new, container, false);
        mContext = mView.getContext();



        return mView;
    }






}
