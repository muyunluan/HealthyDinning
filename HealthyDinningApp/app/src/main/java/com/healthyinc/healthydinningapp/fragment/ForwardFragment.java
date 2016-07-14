package com.healthyinc.healthydinningapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.healthyinc.healthydinningapp.R;

/**
 * Created by feideng on 7/5/16.
 */
public class ForwardFragment extends Fragment {

    private View mView;

    public ForwardFragment() {}

    public static ForwardFragment newInstance() {
        ForwardFragment forwardFragment = new ForwardFragment();
        return forwardFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_forward, container, false);
        return mView;
    }
}
