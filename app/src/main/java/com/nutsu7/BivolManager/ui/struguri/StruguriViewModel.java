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
    public int getBoxCurrent(){
        return struguri.getBoxCurrent();
    }

    public int getBoxSold(){
        return struguri.getBoxSold();
    }

    public int getBoxHarvested(){
        return struguri.getBoxHarvested();
    }

    public int getQuantitySold(){
        return struguri.getQuantitySold();
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
