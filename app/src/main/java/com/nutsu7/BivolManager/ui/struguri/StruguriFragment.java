package com.nutsu7.BivolManager.ui.struguri;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.nutsu7.BivolManager.databinding.FragmentStruguriBinding;

public class StruguriFragment extends Fragment {

    private FragmentStruguriBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        StruguriViewModel struguriViewModel =
                new ViewModelProvider(this).get(StruguriViewModel.class);

        binding = FragmentStruguriBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textStruguri;
        struguriViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}