package com.nutsu7.BivolManager.ui.muncitori;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.nutsu7.BivolManager.MainActivity;
import com.nutsu7.BivolManager.R;
import com.nutsu7.BivolManager.databinding.FragmentMuncitoriBinding;

import java.util.ArrayList;

public class MuncitoriFragment extends Fragment {

    private FragmentMuncitoriBinding binding;
    private AdaptorMuncitoriList adaptorML;
    private RecyclerView muncitoriListRV;
    private MuncitoriViewModel muncitoriViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        muncitoriViewModel =
                new ViewModelProvider(this).get(MuncitoriViewModel.class);

        binding = FragmentMuncitoriBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        muncitoriListRV = root.findViewById(R.id.muncitoriListRV);
        muncitoriViewModel.getMuncitorMutableLiveData().observe(getViewLifecycleOwner(), muncitorListUpdateObserver);
        return root;
    }

    private final Observer<ArrayList<Muncitor>> muncitorListUpdateObserver = new Observer<ArrayList<Muncitor>>() {
        @Override
        public void onChanged(ArrayList<Muncitor> muncitorList) {

            adaptorML = new AdaptorMuncitoriList(muncitorList,requireActivity());
            muncitoriListRV.setAdapter(adaptorML);
        }
    };
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}