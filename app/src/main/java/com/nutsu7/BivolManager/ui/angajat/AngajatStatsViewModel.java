package com.nutsu7.BivolManager.ui.angajat;

import android.app.Activity;
import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.nutsu7.BivolManager.db.angajat.Angajat;
import com.nutsu7.BivolManager.db.angajat.AngajatRepo;

public class AngajatStatsViewModel extends ViewModel {
    AngajatRepo repo;
    private Integer id;
    private Angajat angajat;
    public void init(Context context, Integer angajatID){
        repo = new AngajatRepo(context);
        this.id=angajatID;
        this.angajat = repo.getByID(id);
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

    public int getSalary() {
        return angajat.getSalary();
    }


}