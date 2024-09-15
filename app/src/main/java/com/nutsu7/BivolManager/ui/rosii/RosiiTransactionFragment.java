package com.nutsu7.BivolManager.ui.rosii;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nutsu7.BivolManager.databinding.FragmentRosiiTransactionBinding;

public class RosiiTransactionFragment extends Fragment {

    private RosiiTransactionViewModel mViewModel;
    private FragmentRosiiTransactionBinding binding;
    private RecyclerView rv;

    public static RosiiTransactionFragment newInstance() {
        return new RosiiTransactionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(RosiiTransactionViewModel.class);

        binding = FragmentRosiiTransactionBinding.inflate(inflater, container, false);

        View root = binding.getRoot();


        rv = binding.rosiiTranListRV;
        rv.setAdapter(new RosiiTransactionListAdaptor(requireActivity()));

        binding.rosiiTranAddFBA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RosiiTransactionAddDialog rosiiTransactionAddDialog = new RosiiTransactionAddDialog();
                rosiiTransactionAddDialog.show(getChildFragmentManager(), "Adauga tranzactie");
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}