package com.nutsu7.BivolManager.ui.struguri;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.nutsu7.BivolManager.databinding.FragmentStruguriBinding;


public class StruguriFragment extends Fragment{
    private FragmentStruguriBinding binding;
    private StruguriViewModel struguriViewModel;

    public StruguriFragment(){

    }

    public static StruguriFragment newInstance() {
        StruguriFragment fragment = new StruguriFragment();
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        struguriViewModel =
                new ViewModelProvider(this).get(StruguriViewModel.class);

        binding = FragmentStruguriBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        struguriViewModel.init(getContext());

        updateData();

        struguriViewModel.getStruguriLiveData().observe(getViewLifecycleOwner(), struguri -> {
            updateData();
        });



        return root;
    }

    public void updateData(){
        struguriViewModel.update();
        binding.struguriCurrQuantity.setText(String.valueOf(struguriViewModel.getQuantityCurrent()));
        binding.struguriHarvestedQuantity.setText(String.valueOf(struguriViewModel.getQuantityHarvested()));
        binding.struguriSoldQuantity.setText(String.valueOf(struguriViewModel.getQuantitySold()));

        binding.struguriMoney.setText(String.valueOf(struguriViewModel.getMoneyTotal()));
        binding.struguriMoneyNR.setText(String.valueOf(struguriViewModel.getMoneyNRTotal()));

        binding.struguriDays.setText(String.valueOf(struguriViewModel.getDaysWorked()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
