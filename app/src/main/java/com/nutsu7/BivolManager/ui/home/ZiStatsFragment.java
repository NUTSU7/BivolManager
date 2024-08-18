package com.nutsu7.BivolManager.ui.home;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.nutsu7.BivolManager.databinding.FragmentZiStatsBinding;
import com.nutsu7.BivolManager.ui.home.ZiStatsViewModel;

import org.w3c.dom.Text;

public class ZiStatsFragment extends Fragment {
    private FragmentZiStatsBinding binding;
    private ZiStatsViewModel ziStatsViewModel;
    private RecyclerView ziStatsListRV;
    TextView ziInfoTextView;
    TextView ziHoursTextView;
    TextView ziDate;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ziStatsViewModel = new ViewModelProvider(this).get(ZiStatsViewModel.class);

        binding = FragmentZiStatsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ziStatsViewModel.init(getContext(), getArguments().getInt("ziID"));
        ziInfoTextView = binding.ziInfo;
        ziHoursTextView = binding.ziHours;
        ziDate= binding.ziDate;


        ziStatsListRV = binding.ziStatsListRV;
        ziStatsListRV.setAdapter(new ZiStatsListAdaptor(requireActivity(), ziStatsViewModel.getID()));

        updateData();

        ziStatsViewModel.getStatus().observe(getViewLifecycleOwner(), zi -> {
            updateData();
        });


        return root;
    }

    public void updateData(){
        ziStatsViewModel.update();
        ziDate.setText(String.valueOf(ziStatsViewModel.getDate()) + " " + ziStatsViewModel.getMonth()+ " ");
        ziInfoTextView.setText(ziStatsViewModel.getInfo());
        ziHoursTextView.setText(String.valueOf(ziStatsViewModel.getHours()));
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}