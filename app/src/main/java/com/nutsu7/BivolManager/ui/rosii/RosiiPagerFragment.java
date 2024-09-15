package com.nutsu7.BivolManager.ui.rosii;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.tabs.TabLayoutMediator;
import com.nutsu7.BivolManager.databinding.FragmentRosiiPagerBinding;

import java.util.ArrayList;
import java.util.List;

public class RosiiPagerFragment extends Fragment {

    private FragmentRosiiPagerBinding binding;
    private List<String> fragmentNameList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RosiiPagerViewModel rosiiPagerViewModel =
                new ViewModelProvider(this).get(RosiiPagerViewModel.class);

        binding = FragmentRosiiPagerBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        fragmentNameList.add("Statistica");
        fragmentNameList.add("Tranzactii");

        RosiiPagerAdapter rosiiPagerAdapter = new RosiiPagerAdapter(getChildFragmentManager(), getLifecycle());
        binding.rosiiPager.setAdapter(rosiiPagerAdapter);
        new TabLayoutMediator(binding.rosiiPagerTabLayout, binding.rosiiPager,
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