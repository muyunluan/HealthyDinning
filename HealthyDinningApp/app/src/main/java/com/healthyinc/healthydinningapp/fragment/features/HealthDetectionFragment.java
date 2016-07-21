package com.healthyinc.healthydinningapp.fragment.features;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.healthyinc.healthydinningapp.R;
import com.txusballesteros.widgets.FitChart;

/**
 * Created by Fei Deng on 7/20/16.
 * Copyright (c) 2016 Ayla. All rights reserved.
 */
public class HealthDetectionFragment extends Fragment {

    private View mView;
    private Context mContext;

    private FitChart fitChart;
    private TextView tvScore;

    public HealthDetectionFragment() {}

    public static HealthDetectionFragment newInstance() {
        HealthDetectionFragment healthDetectionFragment = new HealthDetectionFragment();
        return healthDetectionFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_health_detection, container, false);
        mContext = mView.getContext();

        fitChart = (FitChart)mView.findViewById(R.id.fitChart);
        fitChart.setMinValue(0f);
        fitChart.setMaxValue(100f);
        fitChart.setValue(80f);

        tvScore = (TextView)mView.findViewById(R.id.tv_score);
        tvScore.setText("80分");
        return mView;
    }
}
