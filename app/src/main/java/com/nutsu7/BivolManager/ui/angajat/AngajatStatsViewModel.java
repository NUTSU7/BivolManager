package com.nutsu7.BivolManager.ui.angajat;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.nutsu7.BivolManager.db.angajat.Angajat;
import com.nutsu7.BivolManager.db.angajat.AngajatRepo;

public class AngajatStatsViewModel extends ViewModel {
    AngajatRepo repo;
    private Integer id;
    private Angajat angajat;
    private LiveData<Angajat> angajatLive;
    public void init(Context context, Integer angajatID){
        repo = new AngajatRepo(context);
        this.id=angajatID;
        angajatLive = repo.getLiveByID(id);
    }

    public void update(){
        angajat=repo.getByID(id);
    }

    public LiveData<Angajat> getStatus(){
        return angajatLive;
    }

    public Integer getID() {
        return id;
    }

    public String getName() {
        return angajat.getName();
    }

    public String getSurname() {
        return angajat.getSurname();
    }

    public Integer getSalary() {
        return angajat.getSalary();
    }

    public Integer getDebt() {
        return angajat.getDebt();
    }

    public Integer getTotalDays() {
        return angajat.getTotalDays();
    }

    public Integer getTotalHours() {
        return angajat.getTotalHours();
    }


}