package com.nutsu7.BivolManager.ui.struguri;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.tabs.TabLayoutMediator;
import com.nutsu7.BivolManager.databinding.FragmentStruguriPagerBinding;

import java.util.ArrayList;
import java.util.List;

public class StruguriPagerFragment extends Fragment {

    private FragmentStruguriPagerBinding binding;
    private List<String> fragmentNameList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        StruguriPagerViewModel struguriPagerViewModel =
                new ViewModelProvider(this).get(StruguriPagerViewModel.class);

        binding = FragmentStruguriPagerBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        fragmentNameList.add("Statistica");
        fragmentNameList.add("Tranzactii");

        StruguriPagerAdapter struguriPagerAdapter = new StruguriPagerAdapter(getChildFragmentManager(), getLifecycle());
        binding.struguriPager.setAdapter(struguriPagerAdapter);
        new TabLayoutMediator(binding.struguriPagerTabLayout, binding.struguriPager,
                (tab, position) ->
                        tab.setText(fragmentNameList.get(position))
        ).attach();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}