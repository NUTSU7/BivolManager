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

import com.nutsu7.BivolManager.R;
import com.nutsu7.BivolManager.databinding.FragmentAngajatStatsBinding;

public class AngajatStatsFragment extends Fragment {
    private FragmentAngajatStatsBinding binding;
    private AngajatStatsViewModel angajatStatsViewModel;

    public static AngajatStatsFragment newInstance() {
        return new AngajatStatsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        angajatStatsViewModel = new ViewModelProvider(this).get(AngajatStatsViewModel.class);

        binding = FragmentAngajatStatsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}