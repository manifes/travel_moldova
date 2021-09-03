package com.example.mew;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

public class LoginAdapter extends FragmentPagerAdapter {

    private final Context mContext;
    int totalTabs;

    public LoginAdapter(@NonNull FragmentManager fm, Context context, int totalTabs) {
        super(fm);
        mContext = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public int getCount() {
        return totalTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                System.out.println(">>>>>>>>>>>>>>>>>>>>> LOGIN <<<<<<<<<<<<<<<<<<<<<<");
                LoginTabFragment loginTabFragment = new LoginTabFragment();
                return loginTabFragment;
            case 1:
                System.out.println(">>>>>>>>>>>>>>>>>>>>> SIGN UP <<<<<<<<<<<<<<<<<<<<<");
                SignupTabFragment signupTabFragment = new SignupTabFragment();
                return signupTabFragment;
            default:
                System.out.println(">>>>>>>>>>>>>>>>>>>>> DEFAULT <<<<<<<<<<<<<<<<<<<<<<");
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(position);
    }
}
