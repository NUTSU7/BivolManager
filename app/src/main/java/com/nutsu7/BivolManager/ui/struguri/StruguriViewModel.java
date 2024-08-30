package com.nutsu7.BivolManager.ui.struguri;


import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.nutsu7.BivolManager.db.struguri.Struguri;
import com.nutsu7.BivolManager.db.struguri.StruguriRepo;

public class StruguriViewModel extends ViewModel {
    private StruguriRepo repo;
    private Struguri struguri;
    public void init(Context context){
        repo = new StruguriRepo(context);
        struguri = repo.getByID(0);
    }

    public int getQuantityCurrent(){
        return struguri.getQuantityCurrent();
    }

    public int getQuantitySold(){
        return struguri.getQuantitySold();
    }

    public int getQuantityHarvested(){
        return struguri.getQuantityHarvested();
    }

    public int getDaysWorked(){
        return struguri.getDaysWorked();
    }



}
