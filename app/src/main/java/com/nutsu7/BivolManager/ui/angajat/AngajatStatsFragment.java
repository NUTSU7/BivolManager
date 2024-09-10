package com.nutsu7.BivolManager.ui.angajat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.nutsu7.BivolManager.databinding.FragmentAngajatStatsBinding;

public class AngajatStatsFragment extends Fragment {
    private FragmentAngajatStatsBinding binding;
    private AngajatStatsViewModel angajatStatsViewModel;
    private ExtendedFloatingActionButton angajatPayFBA;
    private ExtendedFloatingActionButton angajatDebtFBA;
    TextView angajatNameTextView;
    TextView angajatSalaryTextView;
    TextView angajatDebtTextView;
    TextView angajatTotalDaysTextView;
    TextView angajatTotalHRTextView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        angajatStatsViewModel = new ViewModelProvider(this).get(AngajatStatsViewModel.class);

        binding = FragmentAngajatStatsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        angajatStatsViewModel.init(getContext(), getArguments().getInt("angajatID"));
        angajatNameTextView = binding.angajatName;
        angajatSalaryTextView = binding.angajatSalary;
        angajatDebtTextView = binding.angajatDebt;
        angajatTotalDaysTextView = binding.angajatTotalDays;
        angajatTotalHRTextView = binding.angajatTotalHR;


        updateData();

        angajatPayFBA = binding.angajatPayFBA;
        angajatDebtFBA = binding.angajatDebtFBA;

        angajatStatsViewModel.getStatus().observe(getViewLifecycleOwner(), angajat -> {
            updateData();
        });

        angajatPayFBA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AngajatPayDialog angajatPayDialog = new AngajatPayDialog();
                Bundle args = new Bundle();
                args.putInt("arg", getArguments().getInt("angajatID"));

                angajatPayDialog.setArguments(args);
                angajatPayDialog.show(getChildFragmentManager(), "Plateste Angajat");

            }
        });

        angajatDebtFBA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AngajatDebtDialog angajatDebtDialog = new AngajatDebtDialog();
                Bundle args = new Bundle();
                args.putInt("arg", getArguments().getInt("angajatID"));

                angajatDebtDialog.setArguments(args);
                angajatDebtDialog.show(getChildFragmentManager(), "Adauga Datorie");
            }
        });


        return root;
    }

    public void updateData(){
        angajatStatsViewModel.update();
        angajatNameTextView.setText(angajatStatsViewModel.getSurname()+" "+angajatStatsViewModel.getName());
        angajatSalaryTextView.setText(String.valueOf(angajatStatsViewModel.getSalary()));
        angajatDebtTextView.setText(String.valueOf(angajatStatsViewModel.getDebt()));
        angajatTotalDaysTextView.setText(String.valueOf(angajatStatsViewModel.getTotalDays()));
        angajatTotalHRTextView.setText(String.valueOf(angajatStatsViewModel.getTotalHours()));
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}