package com.nutsu7.BivolManager.ui.struguri;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class StruguriPagerAdapter extends FragmentStateAdapter {

    public StruguriPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }



    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position==0) return StruguriFragment.newInstance();
        if(position==1) return StruguriTransactionFragment.newInstance();
        return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
