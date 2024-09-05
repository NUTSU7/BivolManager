package com.nutsu7.BivolManager.ui.home;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.nutsu7.BivolManager.db.zi.Zi;
import com.nutsu7.BivolManager.db.zi.ZiRepo;

public class ZiStatsViewModel extends ViewModel {
    ZiRepo repo;
    private Integer id;
    private Zi zi;
    private LiveData<Zi> ziLive;
    public void init(Context context, Integer ziID){
        repo = new ZiRepo(context);
        this.id=ziID;
        ziLive = repo.getLiveByID(id);
    }

    public void update(){
        zi=repo.getByID(id);
    }

    public LiveData<Zi> getStatus(){
        return ziLive;
    }

    public int getHours(){
        return zi.getHours();
    }

    public int getID() {
        return id;
    }

    public String getInfo(){
        return zi.getInfo();
    }

    public int getDate(){
        return zi.getDay();
    }

    public String getMonth(){
        return zi.getMonth();
    }
    public int getYear(){
        return zi.getYear();
    }

    public String getWork(){ return zi.getWork(); }

    public int getQuantity1(){ return zi.getQuantity1(); }

    public int getQuantity2(){ return zi.getQuantity2(); }
}
