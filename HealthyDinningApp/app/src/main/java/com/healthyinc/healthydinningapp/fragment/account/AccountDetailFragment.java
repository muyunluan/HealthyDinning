package com.healthyinc.healthydinningapp.fragment.account;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.dexafree.materialList.card.Card;
import com.dexafree.materialList.card.CardProvider;
import com.dexafree.materialList.card.provider.ListCardProvider;
import com.dexafree.materialList.listeners.OnDismissCallback;
import com.dexafree.materialList.listeners.RecyclerItemClickListener;
import com.dexafree.materialList.view.MaterialListView;
import com.healthyinc.healthydinningapp.MainActivity;
import com.healthyinc.healthydinningapp.R;
import com.healthyinc.healthydinningapp.util.Constants;
import com.squareup.picasso.RequestCreator;

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

        mListView = (MaterialListView)mView.findViewById(R.id.material_listview);
        mListView.getAdapter().add(generateUserInfoCard(mContext.getResources().getString(R.string.user_name)));
        mListView.getAdapter().add(generateUserBasicDataCard("user basic"));
        mListView.getAdapter().add(generateUserDietDataCard("user diet"));
        mListView.getAdapter().add(generateFamilialDiseaseCard(mContext.getResources().getString(R.string.user_familial_disease)));
        mListView.getAdapter().add(generateUserBodyDataCard(mContext.getResources().getString(R.string.user_body_data)));

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
            @Override
            public void onItemClick(@NonNull Card card, int position) {
                Log.d("CARD_TYPE", "" + card.getTag());
                String cardTag = card.getTag().toString();
                if (cardTag.isEmpty()) {
                    //null value
                }
                else {
                    if (cardTag.equals(Constants.USER_INFORMATION_CARD_TAG)) {
                        MainActivity.getInstance().pushFragment(UserProfileFragment.newInstance());
                    }
                    else if (cardTag.equals(Constants.USER_BASIC_DATA_CARD_TAG)) {
                        MainActivity.getInstance().pushFragment(UserBasicDataFragment.newInstance());
                    }
                    else if (cardTag.equals(Constants.USER_DIET_DATA_CARD_TAG)) {
                        MainActivity.getInstance().pushFragment(UserDietDataFragment.newInstance());
                    }
                    else if (cardTag.equals(Constants.USER_FAMILIAL_DISEASE_CARD_TAG)) {
                        MainActivity.getInstance().pushFragment(UserFamiliarDiseaseFragment.newInstance());
                    }
                    else if (cardTag.equals(Constants.USER_BODY_DATA_CARD_TAG)) {
                        MainActivity.getInstance().pushFragment(UserBodyDataFragment.newInstance());
                    }
                }
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
                .setLayout(R.layout.material_basic_image_buttons_card_layout)
                .setTitleGravity(Gravity.END)
                .setDescription(content)
                .setDescriptionGravity(Gravity.END)
                .setDrawable(R.drawable.dog)
                .setDrawableConfiguration(new CardProvider.OnImageConfigListener() {
                    @Override
                    public void onImageConfigure(@NonNull RequestCreator requestCreator) {
                        requestCreator.fit();
                    }
                });
        return provider.endConfig().build();
    }

    public Card generateUserBasicDataCard(String content) {
        final CardProvider provider = new Card.Builder(mContext)
                .setTag(Constants.USER_BASIC_DATA_CARD_TAG)
                .setDismissible()
                .withProvider(new CardProvider())
                .setLayout(R.layout.cardview_user_basic_data)
                .setDescription(content);
        return provider.endConfig().build();
    }

    public Card generateUserDietDataCard(String content) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1);
        adapter.add("挑食情况：");
        adapter.add("过敏食物：");
        adapter.add("喜好食物：");

        final ListCardProvider provider = new Card.Builder(mContext)
                .setTag(Constants.USER_DIET_DATA_CARD_TAG)
                .setDismissible()
                .withProvider(new ListCardProvider())
                .setLayout(R.layout.material_list_card_layout)
                .setTitle("个人饮食习惯")
                .setAdapter(adapter);
        return provider.endConfig().build();
    }

    private Card generateFamilialDiseaseCard(String content) {
        final CardProvider provider = new Card.Builder(mContext)
                .setTag(Constants.USER_FAMILIAL_DISEASE_CARD_TAG)
                .setDismissible()
                .withProvider(new CardProvider())
                .setLayout(R.layout.cardview_user_familial_disease)
                .setDescription(content);
        return provider.endConfig().build();
    }

    private Card generateUserBodyDataCard(String content) {
        final CardProvider provider = new Card.Builder(mContext)
                .setTag(Constants.USER_BODY_DATA_CARD_TAG)
                .setDismissible()
                .withProvider(new CardProvider())
                .setLayout(R.layout.cardview_user_body_data)
                .setDescription(content);
        return provider.endConfig().build();
    }
}
