package com.nutsu7.BivolManager.db.angajat;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.nutsu7.BivolManager.db.AppDB;
import com.nutsu7.BivolManager.db.relations.ZiAngajat;

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

    public int getHoursByZi(int ziID, int angajatID){
        ZiAngajat ziAngajat = appDB.ziAngajatDao().getByZiIDAndAngajatID(ziID, angajatID);
        return ziAngajat.getHours();
    }

    public void delete(Angajat angajat){
        if(angajat==null) return;
        int id=angajat.getId();

        appDB.angajatDao().deleteByID(id);

        List<Angajat> angajatList=appDB.angajatDao().getAll();
        if(id==angajatList.size()) return;
        int temp=id+1;
        for(Angajat a:angajatList){

            if(a.getId()>id){
                appDB.angajatDao().updateIDByID(temp, temp-1);
                temp++;
            }

        }

        deleteZiByAngajatID(id);
    }

    public void deleteByID(int id){
        if(id<0) return;
        appDB.angajatDao().deleteByID(id);
    }


    public void update(Angajat angajat){
        if(angajat==null) return;
        appDB.angajatDao().update(angajat);
    }

    public void deleteZiByAngajatID(int angajatID) {
        appDB.ziAngajatDao().deleteByAngajatID(angajatID);
        int t = 0;
        List<ZiAngajat> ziAngajatList = appDB.ziAngajatDao().getAll();
        for (ZiAngajat ziAngajat : ziAngajatList) {
            appDB.ziAngajatDao().updateIDByID(ziAngajat.getId(), t++);
            if (ziAngajat.getAngajatID() > angajatID) {
                appDB.ziAngajatDao().updateAngajatIDByAngajatID(ziAngajat.getAngajatID(), ziAngajat.getAngajatID() - 1);
            }
        }
    }

}
