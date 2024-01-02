package com.nutsu7.BivolManager.ui.Rosii;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.nutsu7.BivolManager.databinding.FragmentRosiiBinding;

public class RosiiFragment extends Fragment {

    private FragmentRosiiBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RosiiViewModel rosiiViewModel =
                new ViewModelProvider(this).get(RosiiViewModel.class);

        binding = FragmentRosiiBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textRosii;
        rosiiViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}