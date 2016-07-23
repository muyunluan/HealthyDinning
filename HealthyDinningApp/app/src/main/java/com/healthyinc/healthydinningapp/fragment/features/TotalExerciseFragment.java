package com.healthyinc.healthydinningapp.fragment.features;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.healthyinc.healthydinningapp.R;

/**
 * Created by Fei Deng on 7/20/16.
 * Copyright (c) 2016 Ayla. All rights reserved.
 */
public class TotalExerciseFragment extends Fragment {

    private View mView;
    private Context mContext;

    public TotalExerciseFragment() {}

    public static TotalExerciseFragment newInstance() {
        TotalExerciseFragment totalExerciseFragment = new TotalExerciseFragment();
        return totalExerciseFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_total_exercise, container, false);
        mContext = mView.getContext();

        return mView;
    }
}
