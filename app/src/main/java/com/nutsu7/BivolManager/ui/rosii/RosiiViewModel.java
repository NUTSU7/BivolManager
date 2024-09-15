package com.nutsu7.BivolManager.ui.rosii;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.nutsu7.BivolManager.db.rosii.Rosii;
import com.nutsu7.BivolManager.db.rosii.RosiiRepo;

public class RosiiViewModel extends ViewModel {
    private RosiiRepo repo;
    private Rosii rosii;
    private LiveData<Rosii> rosiiLiveData;
    public void init(Context context){
        repo = new RosiiRepo(context);
        rosiiLiveData = repo.getLiveRosii();
    }
    public void update(){ rosii = repo.get(); }

    public int getBoxCurrent1(){
        return rosii.getBoxCurrent1();
    }
    public int getBoxCurrent2(){
        return rosii.getBoxCurrent2();
    }

    public int getBoxSold1(){
        return rosii.getBoxSold1();
    }

    public int getBoxSold2(){
        return rosii.getBoxSold2();
    }

    public double getQuantitySold1(){
        return rosii.getQuantitySold1();
    }

    public double getQuantitySold2(){
        return rosii.getQuantitySold2();
    }

    public int getDaysWorked(){
        return rosii.getDaysWorked();
    }

    public double getMoneyTotal1(){
        return rosii.getMoneyTotal1();
    }

    public double getMoneyTotal2(){
        return rosii.getMoneyTotal2();
    }

    public LiveData<Rosii> getRosiiLiveData(){ return rosiiLiveData; }

}