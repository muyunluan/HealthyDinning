package com.healthyinc.healthydinningapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dexafree.materialList.card.Card;
import com.dexafree.materialList.card.CardProvider;
import com.dexafree.materialList.listeners.OnDismissCallback;
import com.dexafree.materialList.listeners.RecyclerItemClickListener;
import com.dexafree.materialList.view.MaterialListView;
import com.healthyinc.healthydinningapp.R;
import com.healthyinc.healthydinningapp.util.Constants;

/**
 * Created by Fei Deng on 7/12/16.
 * Copyright (c) 2016 Ayla. All rights reserved.
 */
public class AccountDetailFragment extends Fragment {

    private View mView;
    private Context mContext;

    private MaterialListView mListView;

    public AccountDetailFragment() {

    }

    public static AccountDetailFragment newInstance() {
        AccountDetailFragment accountDetailFragment = new AccountDetailFragment();
        return accountDetailFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_account_detail, container, false);
        mContext = mView.getContext();

        mListView.getAdapter().add(generateUserInfoCard("user"));


        // Set the dismiss listener
        mListView.setOnDismissCallback(new OnDismissCallback() {
            @Override
            public void onDismiss(@NonNull Card card, int position) {
                // Show a toast
                Toast.makeText(mContext, "You have dismissed a " + card.getTag(), Toast.LENGTH_SHORT).show();
            }
        });

        // Add the ItemTouchListener
        mListView.addOnItemTouchListener(new RecyclerItemClickListener.OnItemClickListener() {
            Class mClass;

            @Override
            public void onItemClick(@NonNull Card card, int position) {
                Log.d("CARD_TYPE", "" + card.getTag());
                if (card.getTag().toString().equals(Constants.USER_INFORMATION_CARD_TAG)) {
                    mClass = null;
                }

                Intent mIntent = new Intent(mContext, mClass);
                mContext.startActivity(mIntent);
            }

            @Override
            public void onItemLongClick(@NonNull Card card, int position) {
                Log.d("LONG_CLICK", "" + card.getTag());
            }
        });

        return mView;
    }

    public Card generateUserInfoCard(String content) {
        final CardProvider provider = new Card.Builder(mContext)
                .setTag(Constants.USER_INFORMATION_CARD_TAG)
                .setDismissible()
                .withProvider(new CardProvider())
                .setLayout(R.layout.cardview_single_textview)
                .setTitle("Welcome to HealthyInc")
                .setTitleColor(Color.WHITE)
                .setDescription(content)
                .setDescriptionColor(Color.WHITE)
                .setSubtitle(R.string.user_name)
                .setSubtitleColor(Color.WHITE)
                .setBackgroundColor(Color.BLUE);
        return provider.endConfig().build();
    }
}
