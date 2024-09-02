package com.nutsu7.BivolManager.ui.struguri;


import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.nutsu7.BivolManager.db.struguri.Struguri;
import com.nutsu7.BivolManager.db.struguri.StruguriRepo;

public class StruguriViewModel extends ViewModel {
    private StruguriRepo repo;
    private Struguri struguri;
    private LiveData<Struguri> struguriLiveData;
    public void init(Context context){
        repo = new StruguriRepo(context);
        struguriLiveData = repo.getLiveStruguri();
    }
    public void update(){ struguri = repo.get(); }
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

    public int getMoneyTotal(){
        return struguri.getMoneyTotal();
    }

    public int getMoneyNRTotal(){
        return struguri.getMoneyNRTotal();
    }

    public LiveData<Struguri> getStruguriLiveData(){ return struguriLiveData; }



}
