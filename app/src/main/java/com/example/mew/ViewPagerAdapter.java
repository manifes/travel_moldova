package com.example.mew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.cuberto.liquid_swipe.LiquidPager;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull  FragmentManager fm, int behavior){
        super(fm, behavior);
    }
    private static final int NUM_PAGES = 2;

    @NonNull
    @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    FragmentFive tab1 = new FragmentFive();
                    return tab1;
                case 1:
                    FragmentSix tab2 = new FragmentSix();
                    return tab2;

            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }


