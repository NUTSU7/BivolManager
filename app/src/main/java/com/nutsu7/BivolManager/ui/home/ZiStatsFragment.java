package com.nutsu7.BivolManager.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.nutsu7.BivolManager.databinding.FragmentZiStatsBinding;

public class ZiStatsFragment extends Fragment {
    private FragmentZiStatsBinding binding;
    private ZiStatsViewModel ziStatsViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ziStatsViewModel = new ViewModelProvider(this).get(ZiStatsViewModel.class);

        binding = FragmentZiStatsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ziStatsViewModel.init(getContext(), getArguments().getInt("ziID"));


        binding.ziStatsListRV.setAdapter(new ZiStatsListAdaptor(requireActivity(), ziStatsViewModel.getID()));

        updateData();

        ziStatsViewModel.getStatus().observe(getViewLifecycleOwner(), zi -> {
            updateData();
        });


        return root;
    }

    public void updateData(){
        ziStatsViewModel.update();
        binding.ziDate.setText(String.valueOf(ziStatsViewModel.getDate()) + " " + ziStatsViewModel.getMonth()+ " ");
        binding.ziInfo.setText(ziStatsViewModel.getInfo());
        binding.ziHours.setText(String.valueOf(ziStatsViewModel.getHours()));
        binding.ziLucru.setText(ziStatsViewModel.getWork());
        binding.ziBox1.setText(String.valueOf(ziStatsViewModel.getQuantity1()));
        binding.ziBox2.setText(String.valueOf(ziStatsViewModel.getQuantity2()));
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}