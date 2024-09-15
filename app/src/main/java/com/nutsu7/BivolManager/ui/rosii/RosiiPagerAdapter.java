package com.nutsu7.BivolManager.ui.rosii;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class RosiiPagerAdapter extends FragmentStateAdapter {

    public RosiiPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position==0) return RosiiFragment.newInstance();
        if(position==1) return RosiiTransactionFragment.newInstance();
        return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
