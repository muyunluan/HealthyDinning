package com.healthyinc.healthydinningapp.fragment;

import android.content.Context;
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
import com.dexafree.materialList.card.OnActionClickListener;
import com.dexafree.materialList.card.action.TextViewAction;
import com.dexafree.materialList.listeners.OnDismissCallback;
import com.dexafree.materialList.listeners.RecyclerItemClickListener;
import com.dexafree.materialList.view.MaterialListView;
import com.healthyinc.healthydinningapp.MainActivity;
import com.healthyinc.healthydinningapp.R;
import com.healthyinc.healthydinningapp.fragment.features.HealthDetectionFragment;
import com.healthyinc.healthydinningapp.fragment.features.HealthReportFragment;
import com.healthyinc.healthydinningapp.fragment.features.MoreFeatureFragment;
import com.healthyinc.healthydinningapp.fragment.features.NutritionGainFragment;
import com.healthyinc.healthydinningapp.fragment.features.NutritionStatusFragment;
import com.healthyinc.healthydinningapp.fragment.features.TotalExerciseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fei Deng on 6/12/16.
 * Copyright (c) 2015 Ayla. All rights reserved.
 */
public class MainPageFragment extends Fragment {

    private View mView;
    private Context mContext;
    private MaterialListView mListView;

    public MainPageFragment() {

    }

    public static MainPageFragment newInstance() {
        MainPageFragment mainPageFragment = new MainPageFragment();
        return mainPageFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_main_page, container, false);
        mContext = mView.getContext();
        mListView = (MaterialListView) mView.findViewById(R.id.material_listview);

        mListView.getAdapter().addAll(generateCards());
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
            }

            @Override
            public void onItemLongClick(@NonNull Card card, int position) {
                Log.d("LONG_CLICK", "" + card.getTag());
            }
        });
        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();
        generateCards();
    }

    private List<Card> generateCards() {
        List<Card> cards = new ArrayList<>();
        cards.add(generateUserInfoCard("test"));
        cards.add(geneerateBasicFeaturesCard("test"));
        cards.add(generateCustomerCard("test customer"));
        return cards;
    }

    private Card generateUserInfoCard(String content) {
        final CardProvider provider = new Card.Builder(mContext)
                .setTag("WELCOME_CARD")
                .withProvider(new CardProvider())
                .setLayout(R.layout.material_welcome_card_layout)
                .setTitle("Welcome to HealthyInc")
                .setTitleColor(Color.WHITE)
                .setDescription(content)
                .setDescriptionColor(Color.WHITE)
                .setSubtitle(R.string.user_name)
                .setSubtitleColor(Color.WHITE)
                .setBackgroundColor(Color.BLUE);
        return provider.endConfig().build();
    }


    private Card geneerateBasicFeaturesCard(String content) {
        final CardProvider provider = new Card.Builder(mContext)
                .setTag("BASIC_FEATURES_CARD")
                .withProvider(new CardProvider())
                .setLayout(R.layout.cardview_basic_features)
                .addAction(R.id.tv_nutrition_status, new TextViewAction(mContext)
                        .setText(mContext.getResources().getString(R.string.nutrition_status))
                        .setTextResourceColor(R.color.black_button)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                MainActivity.getInstance().pushFragment(NutritionStatusFragment.newInstance());
                            }
                        }))
                .addAction(R.id.tv_health_exam, new TextViewAction(mContext)
                        .setText(mContext.getResources().getString(R.string.health_exam))
                        .setTextResourceColor(R.color.black_button)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                MainActivity.getInstance().pushFragment(HealthDetectionFragment.newInstance());
                            }
                        }))
                .addAction(R.id.tv_health_report, new TextViewAction(mContext)
                        .setText(mContext.getResources().getString(R.string.health_report))
                        .setTextResourceColor(R.color.black_button)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                MainActivity.getInstance().pushFragment(HealthReportFragment.newInstance());
                            }
                        }))
                .addAction(R.id.tv_total_exercise, new TextViewAction(mContext)
                        .setText(mContext.getResources().getString(R.string.total_exercise))
                        .setTextResourceColor(R.color.black_button)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                MainActivity.getInstance().pushFragment(TotalExerciseFragment.newInstance());
                            }
                        }))
                .addAction(R.id.tv_more_features, new TextViewAction(mContext)
                        .setText(mContext.getResources().getString(R.string.more_features))
                        .setTextResourceColor(R.color.black_button)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                MainActivity.getInstance().pushFragment(MoreFeatureFragment.newInstance());
                            }
                        }))
                .addAction(R.id.tv_nutrition_gain, new TextViewAction(mContext)
                        .setText(mContext.getResources().getString(R.string.nutrition_gain))
                        .setTextResourceColor(R.color.black_button)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                MainActivity.getInstance().pushFragment(NutritionGainFragment.newInstance());
                            }
                        }))
                .addAction(R.id.tv_unkown, new TextViewAction(mContext)
                        .setText("UNKNOWN")
                        .setTextResourceColor(R.color.black_button)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                //MainActivity.getInstance().pushFragment(HealthDetectionFragment.newInstance());
                            }
                        }));
        return provider.endConfig().build();
    }


    private Card generateCustomerCard(String content) {
        return new Card.Builder(mContext)
                .setTag("BASIC_IMAGE_BUTTONS_CARD")
                .withProvider(new CardProvider())
                .setLayout(R.layout.material_basic_image_buttons_card_layout)
                .setTitle(R.string.customers_info)
                .setDescription(content)
                .setDrawable(R.drawable.dog)
                .endConfig()
                .build();
    }
}
