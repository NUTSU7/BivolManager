package com.nutsu7.BivolManager.ui.struguri;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nutsu7.BivolManager.databinding.FragmentStruguriTransactionBinding;

public class StruguriTransactionFragment extends Fragment {
    private FragmentStruguriTransactionBinding binding;
    private RecyclerView rv;
    private FloatingActionButton struguriTranAddFBA;

    public StruguriTransactionFragment(){

    }

    public static StruguriTransactionFragment newInstance() {
        StruguriTransactionFragment fragment = new StruguriTransactionFragment();
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        StruguriTransactionViewModel struguriTransactionViewModel =
                new ViewModelProvider(this).get(StruguriTransactionViewModel.class);

        binding = FragmentStruguriTransactionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        rv = binding.struguriTranListRV;
        rv.setAdapter(new StruguriTransactionListAdaptor(requireActivity()));

        struguriTranAddFBA = binding.struguriTranAddFBA;
        struguriTranAddFBA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StruguriTransactionAddDialog struguriTransactionAddDialog = new StruguriTransactionAddDialog();
                struguriTransactionAddDialog.show(getChildFragmentManager(), "Adauga tranzactie");
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
