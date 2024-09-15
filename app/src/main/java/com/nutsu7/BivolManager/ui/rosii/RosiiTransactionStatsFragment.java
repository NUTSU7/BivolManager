package com.nutsu7.BivolManager.ui.rosii;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nutsu7.BivolManager.R;
import com.nutsu7.BivolManager.databinding.FragmentRosiiTransactionStatsBinding;

import java.util.List;

public class RosiiTransactionStatsFragment extends Fragment {

    private RosiiTransactionStatsViewModel mViewModel;
    private FragmentRosiiTransactionStatsBinding binding;

    public static RosiiTransactionStatsFragment newInstance() {
        return new RosiiTransactionStatsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(RosiiTransactionStatsViewModel.class);

        binding = FragmentRosiiTransactionStatsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mViewModel.init(getContext(), getArguments().getInt("transactionID"));

        List<Double> quantity1 = mViewModel.getQuantity1(),
                quantity2 = mViewModel.getQuantity2();

        binding.rosiiTranStatsDate.setText("Nr."+String.valueOf(mViewModel.getID()+1)+"  "+
                String.valueOf(mViewModel.getDay())+" "+
                mViewModel.getMonth());

        binding.rosiiTranStatsQuantity11.setText(String.valueOf(quantity1.get(0)));
        binding.rosiiTranStatsQuantity21.setText(String.valueOf(quantity1.get(1)));
        binding.rosiiTranStatsQuantity31.setText(String.valueOf(quantity1.get(2)));

        binding.rosiiTranStatsQuantity12.setText(String.valueOf(quantity2.get(0)));
        binding.rosiiTranStatsQuantity22.setText(String.valueOf(quantity2.get(1)));
        binding.rosiiTranStatsQuantity32.setText(String.valueOf(quantity2.get(2)));

        binding.rosiiTranStatsPrice1.setText(String.valueOf(mViewModel.getPrice1()));
        binding.rosiiTranStatsPrice2.setText(String.valueOf(mViewModel.getPrice2()));

        binding.rosiiTranStatsMoney1.setText(String.valueOf(mViewModel.getMoney1()));
        binding.rosiiTranStatsMoney2.setText(String.valueOf(mViewModel.getMoney2()));

        binding.rosiiTranStatsBoxNr1.setText(String.valueOf(mViewModel.getBoxNr1()));
        binding.rosiiTranStatsBoxNr2.setText(String.valueOf(mViewModel.getBoxNr2()));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }
}