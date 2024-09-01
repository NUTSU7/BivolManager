package com.nutsu7.BivolManager.ui.struguri;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nutsu7.BivolManager.databinding.FragmentStruguriTransactionStatsBinding;

public class StruguriTransactionStatsFragment extends Fragment {
    FragmentStruguriTransactionStatsBinding binding;

    public static StruguriTransactionStatsFragment newInstance() {
        return new StruguriTransactionStatsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        StruguriTransactionStatsViewModel struguriTransactionStatsViewModel =
                new ViewModelProvider(this).get(StruguriTransactionStatsViewModel.class);

        binding = FragmentStruguriTransactionStatsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        struguriTransactionStatsViewModel.init(getContext(), getArguments().getInt("transactionID"));

        binding.struguriTranStatsDate.setText("Nr."+String.valueOf(struguriTransactionStatsViewModel.getID()+1)+"  "+
                String.valueOf(struguriTransactionStatsViewModel.getDay())+" "+
                struguriTransactionStatsViewModel.getMonth());
        binding.struguriTranStatsBuyer.setText(struguriTransactionStatsViewModel.getBuyer());
        binding.struguriTranStatsQuantity.setText(String.valueOf(struguriTransactionStatsViewModel.getQuantity()));
        binding.struguriTranStatsQuantityNR.setText(String.valueOf(struguriTransactionStatsViewModel.getQuantityNR()));
        binding.struguriTranStatsNetQuantity.setText(String.valueOf(struguriTransactionStatsViewModel.getNetQuantity()));
        binding.struguriTranStatsPrice.setText(String.valueOf(struguriTransactionStatsViewModel.getPrice()));
        binding.struguriTranStatsPriceNC.setText(String.valueOf(struguriTransactionStatsViewModel.getPriceNC()));
        binding.struguriTranStatsPaletteNR.setText(String.valueOf(struguriTransactionStatsViewModel.getPaletteNr()));



        return root;
    }

    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}