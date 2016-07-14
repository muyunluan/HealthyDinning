package com.healthyinc.healthydinningapp.fragment.account;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.healthyinc.healthydinningapp.R;

/**
 * Created by Fei Deng on 6/12/16.
 * Copyright (c) 2015 Ayla. All rights reserved.
 */
public class UserProfileFragment extends Fragment {
    private View mView;
    private Context mContext;

    private EditText mUserName;
    private EditText mUserHeight;
    private EditText mUserWeight;
    private EditText mUserSex;
    private EditText mCountry;
    private EditText mPhoneCountryCode;
    private EditText mPhoneNumber;
    private EditText mCity;
    private EditText mState;
    private EditText mZip;

    private Button mUpdate;

    public UserProfileFragment() {

    }

    public static UserProfileFragment newInstance() {
        UserProfileFragment userProfileFragment = new UserProfileFragment();
        return userProfileFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_user_profile, container, false);
        mContext = mView.getContext();

        mUserName = (EditText)mView.findViewById(R.id.et_user_name);
        mUserHeight = (EditText)mView.findViewById(R.id.et_user_height);
        mUserWeight = (EditText)mView.findViewById(R.id.et_user_weight);
        mUserSex = (EditText)mView.findViewById(R.id.et_user_sex);
        mCountry = (EditText)mView.findViewById(R.id.et_country);
        mPhoneCountryCode = (EditText)mView.findViewById(R.id.et_phone_country_code);
        mPhoneNumber = (EditText)mView.findViewById(R.id.et_phone_number);
        mCity = (EditText)mView.findViewById(R.id.et_city);
        mState = (EditText)mView.findViewById(R.id.et_state);
        mZip = (EditText)mView.findViewById(R.id.et_zipcode);

        mUpdate = (Button)mView.findViewById(R.id.bt_confirm);
        mUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUserProfile();
            }
        });
        return mView;
    }

    private void updateUserProfile() {

    }


}
