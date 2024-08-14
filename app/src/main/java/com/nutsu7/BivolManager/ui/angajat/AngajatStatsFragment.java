package com.nutsu7.BivolManager.ui.angajat;

import androidx.activity.OnBackPressedCallback;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.nutsu7.BivolManager.R;
import com.nutsu7.BivolManager.databinding.FragmentAngajatStatsBinding;

public class AngajatStatsFragment extends Fragment {
    private FragmentAngajatStatsBinding binding;
    private AngajatStatsViewModel angajatStatsViewModel;
    private ExtendedFloatingActionButton angajatPayFBA;
    private ExtendedFloatingActionButton angajatDebtFBA;


    public static AngajatStatsFragment newInstance() {
        return new AngajatStatsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        angajatStatsViewModel = new ViewModelProvider(this).get(AngajatStatsViewModel.class);

        binding = FragmentAngajatStatsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        angajatStatsViewModel.init(getContext(), getArguments().getInt("angajatID"));

        TextView angajatNameTextView = root.findViewById(R.id.angajatName);
        TextView angajatSalaryTextView = root.findViewById(R.id.angajatSalary);
        TextView angajatDebtTextView = root.findViewById(R.id.angajatDebt);
        TextView angajatTotalDaysTextView = root.findViewById(R.id.angajatTotalDays);
        TextView angajatTotalHRTextView = root.findViewById(R.id.angajatTotalHR);
        angajatNameTextView.setText(String.valueOf(angajatStatsViewModel.getName()+" "+angajatStatsViewModel.getSurname()));
        angajatSalaryTextView.setText(String.valueOf(String.valueOf(angajatStatsViewModel.getSalary())));
        angajatDebtTextView.setText(String.valueOf(String.valueOf(angajatStatsViewModel.getDebt())));
        angajatTotalDaysTextView.setText(String.valueOf(String.valueOf(angajatStatsViewModel.getTotalDays())));
        angajatTotalHRTextView.setText(String.valueOf(String.valueOf(angajatStatsViewModel.getTotalHours())));


        angajatPayFBA = root.findViewById(R.id.angajatPayFBA);
        angajatDebtFBA = root.findViewById(R.id.angajatDebtFBA);

        angajatPayFBA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AngajatPayDialog angajatPayDialog = new AngajatPayDialog();
                angajatPayDialog.show(getChildFragmentManager(), "Plateste Angajat");
            }
        });

        angajatDebtFBA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AngajatDebtDialog angajatDebtDialog = new AngajatDebtDialog();
                angajatDebtDialog.show(getChildFragmentManager(), "Adauga Datorie");
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}