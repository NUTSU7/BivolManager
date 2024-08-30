package com.nutsu7.BivolManager.ui.struguri;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.nutsu7.BivolManager.databinding.FragmentStruguriPagerBinding;

import java.util.ArrayList;
import java.util.List;

public class StruguriPagerFragment extends Fragment {

    private FragmentStruguriPagerBinding binding;
    private List<Fragment> fragmentList = new ArrayList<Fragment>();;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        StruguriPagerViewModel struguriPagerViewModel =
                new ViewModelProvider(this).get(StruguriPagerViewModel.class);

        binding = FragmentStruguriPagerBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        fragmentList.add(StruguriFragment.newInstance());
        fragmentList.add(StruguriTransactionFragment.newInstance());

        StruguriPagerAdapter struguriPagerAdapter = new StruguriPagerAdapter(getChildFragmentManager(), getLifecycle(), fragmentList);
        binding.struguriPager.setAdapter(struguriPagerAdapter);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}