package com.nutsu7.BivolManager.ui.rosii;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.nutsu7.BivolManager.databinding.FragmentRosiiBinding;

public class RosiiFragment extends Fragment {

    private RosiiViewModel mViewModel;
    private FragmentRosiiBinding binding;

    public RosiiFragment(){ }

    public static RosiiFragment newInstance() {
        return new RosiiFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(RosiiViewModel.class);

        binding = FragmentRosiiBinding.inflate(inflater, container, false);

        View root = binding.getRoot();

        mViewModel.init(getContext());

        updateData();

        mViewModel.getRosiiLiveData().observe(getViewLifecycleOwner(), rosii -> {
            updateData();
        });

        return root;
    }

    public void updateData(){
        mViewModel.update();

        binding.rosiiQuantity1.setText(String.valueOf(mViewModel.getQuantitySold1()));
        binding.rosiiQuantity2.setText(String.valueOf(mViewModel.getQuantitySold2()));

        binding.rosiiCurrBox1.setText(String.valueOf(mViewModel.getBoxCurrent1()));
        binding.rosiiCurrBox2.setText(String.valueOf(mViewModel.getBoxCurrent2()));

        binding.rosiiSoldBox1.setText(String.valueOf(mViewModel.getBoxSold1()));
        binding.rosiiSoldBox2.setText(String.valueOf(mViewModel.getBoxSold2()));

        binding.rosiiMoney1.setText(String.valueOf(mViewModel.getMoneyTotal1()));
        binding.rosiiMoney2.setText(String.valueOf(mViewModel.getMoneyTotal2()));

        binding.rosiiDays.setText(String.valueOf(mViewModel.getDaysWorked()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}