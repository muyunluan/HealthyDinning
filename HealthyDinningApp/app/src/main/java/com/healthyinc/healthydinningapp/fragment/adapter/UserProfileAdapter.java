package com.healthyinc.healthydinningapp.fragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.healthyinc.healthydinningapp.R;

/**
 * Created by Fei Deng on 7/12/16.
 * Copyright (c) 2016 Ayla. All rights reserved.
 */
public class UserProfileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;
    private Context mContext;
    View.OnClickListener mClickListener;

    public UserProfileAdapter(View.OnClickListener listener) {
        mClickListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_user_profile, parent, false);
        return new UserProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class UserProfileViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTextView;
        private EditText mEditText;

        public UserProfileViewHolder(View itemView) {
            super(itemView);

            mTextView = (TextView)itemView.findViewById(R.id.text_view);

            mEditText = (EditText)itemView.findViewById(R.id.edit_text);
            mEditText.setClickable(true);
            mEditText.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
