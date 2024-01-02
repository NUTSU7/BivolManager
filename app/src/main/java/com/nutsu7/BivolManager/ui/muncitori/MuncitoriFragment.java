package com.nutsu7.BivolManager.ui.muncitori;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.nutsu7.BivolManager.databinding.FragmentMuncitoriBinding;

public class MuncitoriFragment extends Fragment {

    private FragmentMuncitoriBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MuncitoriViewModel muncitoriViewModel =
                new ViewModelProvider(this).get(MuncitoriViewModel.class);

        binding = FragmentMuncitoriBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNotifications;
        muncitoriViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}