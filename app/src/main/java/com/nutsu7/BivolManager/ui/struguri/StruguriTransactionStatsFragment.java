package com.nutsu7.BivolManager.ui.struguri;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nutsu7.BivolManager.R;

public class StruguriTransactionStatsFragment extends Fragment {


    public static StruguriTransactionStatsFragment newInstance() {
        return new StruguriTransactionStatsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_struguri_transaction_stats, container, false);
    }


}