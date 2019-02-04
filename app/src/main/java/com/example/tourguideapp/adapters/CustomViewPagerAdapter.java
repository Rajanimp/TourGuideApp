package com.example.tourguideapp.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.tourguideapp.R;
import com.example.tourguideapp.fragments.EventsFragment;
import com.example.tourguideapp.fragments.FoodFragment;
import com.example.tourguideapp.fragments.TemplesFragment;
import com.example.tourguideapp.fragments.TourismFragment;

public class CustomViewPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CustomViewPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TourismFragment();
        } else if (position == 1){
            return new TemplesFragment();
        } else if (position == 2){
            return new FoodFragment();
        } else {
            return new EventsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.tourism);
        } else if (position == 1) {
            return mContext.getString(R.string.temples);
        } else if (position == 2) {
            return mContext.getString(R.string.food);
        } else {
            return mContext.getString(R.string.events);
        }
    }
}
