package com.nutsu7.BivolManager.ui.angajat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nutsu7.BivolManager.R;
import com.nutsu7.BivolManager.databinding.FragmentAngajatBinding;
import com.nutsu7.BivolManager.db.AppDB;
import com.nutsu7.BivolManager.db.angajat.Angajat;
import com.nutsu7.BivolManager.db.angajat.AngajatRepo;

import java.util.List;

public class AngajatFragment extends Fragment {
    private FragmentAngajatBinding binding;
    private RecyclerView angajatListRV;
    private AngajatViewModel angajatViewModel;
    private FloatingActionButton angajatAddFBA;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        angajatViewModel =
                new ViewModelProvider(this).get(AngajatViewModel.class);
        binding = FragmentAngajatBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        angajatListRV = root.findViewById(R.id.angajatListRV);
        angajatListRV.setAdapter(new AngajatListAdaptor(requireActivity()));

        angajatAddFBA = root.findViewById(R.id.angajatAddFBA);
        angajatAddFBA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AngajatAddDialog angajatAddDialog = new AngajatAddDialog();
                angajatAddDialog.show(getChildFragmentManager(), "Adauga Angajat");
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