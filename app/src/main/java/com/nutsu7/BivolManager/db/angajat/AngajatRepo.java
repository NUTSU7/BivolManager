package com.nutsu7.BivolManager.db.angajat;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.nutsu7.BivolManager.db.AppDB;

import java.util.List;

public class AngajatRepo {
    private AppDB appDB;
    private Context context;


    public AngajatRepo(Context context){
        this.context=context;
        appDB=AppDB.getAppDB(context);
            //listUpdate();

    }


    public void insert(Angajat angajat){
        if(angajat==null) return;
        appDB.angajatDao().insert(angajat);
    }

    public void insertList(List<Angajat> angajatList){
        if(getAll().isEmpty()) return;
        appDB.angajatDao().insertAll(angajatList);
    }

    public Angajat getByID(int id){
        if(id<0) return null;
        return appDB.angajatDao().getByID(id);
    }
    public LiveData<Angajat> getLiveByID(int id){
        if(id<0) return null;
        return appDB.angajatDao().getLiveByID(id);
    }

    public List<Angajat> getAll(){
        return appDB.angajatDao().getAll();
    }

    public void delete(Angajat angajat){
        if(angajat==null) return;
        int id=angajat.getId();
        List<Angajat> angajatList=appDB.angajatDao().getAll();
        for(int i=id+1; i<angajatList.size(); i++){
            Angajat angajat1 = appDB.angajatDao().getByID(i);
            angajat1.setId(i-1);
            appDB.angajatDao().update(angajat1);
        }
        appDB.angajatDao().deleteByID(angajatList.size()-1);
    }

    public void deleteByID(int id){
        if(id<=0) return;
        appDB.angajatDao().deleteByID(id);
    }


    public void update(Angajat angajat){
        if(angajat==null) return;
        appDB.angajatDao().update(angajat);
    }

}
