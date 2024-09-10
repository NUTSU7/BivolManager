package com.nutsu7.BivolManager.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nutsu7.BivolManager.databinding.FragmentHomeBinding;
import com.nutsu7.BivolManager.ui.angajat.AngajatViewModel;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView ziListRV;
    private AngajatViewModel ziViewModel;
    private FloatingActionButton ziAddFBA;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ziListRV = binding.ziListRV;
        ziListRV.setAdapter(new ZiListAdaptor(requireActivity()));

        ziAddFBA = binding.ziAddFBA;
        ziAddFBA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZiAddDialog ziAddDialog = new ZiAddDialog();
                ziAddDialog.show(getChildFragmentManager(), "Adauga Zi");
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