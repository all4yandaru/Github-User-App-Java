package com.project.githubapp.view.tablayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class SectionPagerAdapter extends FragmentStateAdapter {

    private String login;

    public SectionPagerAdapter(@NonNull FragmentActivity fragmentActivity, String login) {
        super(fragmentActivity);
        this.login = login;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FollowerFragment(login);
                break;
            case 1:
                fragment = new FollowingFragment(login);
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
