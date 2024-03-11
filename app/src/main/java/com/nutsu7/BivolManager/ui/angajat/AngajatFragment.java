package com.nutsu7.BivolManager.ui.angajat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nutsu7.BivolManager.R;
import com.nutsu7.BivolManager.databinding.FragmentAngajatBinding;
import com.nutsu7.BivolManager.db.angajat.Angajat;
import com.nutsu7.BivolManager.db.angajat.AngajatDao;

import java.util.ArrayList;

public class AngajatFragment extends Fragment {
    private FragmentAngajatBinding binding;
    private AdaptorAngajatList adaptorML;
    private RecyclerView muncitoriListRV;
    private AngajatViewModel angajatViewModel;

    private FloatingActionButton angajatAddFBA;
    //public static ArrayList<Angajat> angajatList=


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        angajatViewModel =
                new ViewModelProvider(this).get(AngajatViewModel.class);

        binding = FragmentAngajatBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        muncitoriListRV = root.findViewById(R.id.angajatListRV);

        angajatViewModel.getAngajatMutableLiveData().observe(getViewLifecycleOwner(), muncitorListUpdateObserver);
        angajatAddFBA = root.findViewById(R.id.angajatAddFBA);
        angajatAddFBA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAgajatAddDialog();
            }
        });
        return root;
    }

    public void openAgajatAddDialog(){
        AngajatAddDialog angajatAddDialog = new AngajatAddDialog();
        angajatAddDialog.show(getChildFragmentManager(), "Adauga Angajat");
    }

    private final Observer<ArrayList<Angajat>> muncitorListUpdateObserver = new Observer<ArrayList<Angajat>>() {
        @Override
        public void onChanged(ArrayList<Angajat> angajatList) {

            adaptorML = new AdaptorAngajatList(angajatList,requireActivity());
            muncitoriListRV.setAdapter(adaptorML);
        }
    };
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}