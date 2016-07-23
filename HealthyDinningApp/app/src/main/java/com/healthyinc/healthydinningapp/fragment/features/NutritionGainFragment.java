package com.healthyinc.healthydinningapp.fragment.features;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.IconRoundCornerProgressBar;
import com.healthyinc.healthydinningapp.R;

/**
 * Created by Fei Deng on 7/20/16.
 * Copyright (c) 2016 Ayla. All rights reserved.
 */
public class NutritionGainFragment extends Fragment implements View.OnClickListener {

    private View mView;
    private Context mContext;


    private IconRoundCornerProgressBar progressOne;
    private TextView tvProgressOne;

    public NutritionGainFragment() {}

    public static NutritionGainFragment newInstance() {
        NutritionGainFragment nutritionGainFragment = new NutritionGainFragment();
        return nutritionGainFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_nutrition_gain, container, false);
        mContext = mView.getContext();

        progressOne = (IconRoundCornerProgressBar) mView.findViewById(R.id.progress_one);
        progressOne.setProgressColor(getResources().getColor(R.color.custom_progress_blue_progress));
        progressOne.setSecondaryProgressColor(getResources().getColor(R.color.custom_progress_blue_progress_half));
        progressOne.setIconBackgroundColor(getResources().getColor(R.color.custom_progress_blue_header));
        progressOne.setProgressBackgroundColor(getResources().getColor(R.color.custom_progress_background));

        tvProgressOne = (TextView) mView.findViewById(R.id.tv_progress_one);
        updateTextProgressOne();


        mView.findViewById(R.id.button_progress_one_decrease).setOnClickListener(this);
        mView.findViewById(R.id.button_progress_one_increase).setOnClickListener(this);

        return mView;
    }

    private void increaseProgressOne() {
        progressOne.setProgress(progressOne.getProgress() + 1);
        updateTextProgressOne();
    }

    private void decreaseProgressOne() {
        progressOne.setProgress(progressOne.getProgress() - 1);
        updateTextProgressOne();
    }

    private void updateTextProgressOne() {
        tvProgressOne.setText(String.valueOf((int) progressOne.getProgress()));
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button_progress_one_decrease) {
            decreaseProgressOne();
        } else if (id == R.id.button_progress_one_increase) {
            increaseProgressOne();
        }
    }
}
