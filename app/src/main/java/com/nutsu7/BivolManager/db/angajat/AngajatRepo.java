package com.nutsu7.BivolManager.db.angajat;

import android.content.Context;

import com.nutsu7.BivolManager.db.AppDB;

import java.util.List;

public class AngajatRepo {
    private AppDB appDB;
    private Context context;

    //public List<Angajat> angajatList;
    //public List<Zi> ziList;


    public AngajatRepo(Context context){
        this.context=context;
        appDB=AppDB.getAppDB(context);
            //listUpdate();

    }

    /*public void listUpdate(){
        angajatList=getAll();
        ziList=getZiAll();
    } */

    public void insert(Angajat angajat){
        if(angajat==null) return;
        appDB.angajatDao().insert(angajat);
    }

    public void insertList(List<Angajat> angajatList){
        if(getAll().isEmpty()) return;
        appDB.angajatDao().insertAll(angajatList);
    }

    public Angajat getByID(int id){
        if(id<=0) return null;
        return appDB.angajatDao().getByID(id);
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



    //ZI
    public void insert(Zi zi){
        if(zi==null) return;
        appDB.angajatDao().insertZi(zi);
    }

    /*public void insertAll(){
        if(angajatList.isEmpty()) return;
        appDB.angajatDao().insertAll(angajatList);
    } */

    public List<Zi> getZiByID(int id){
        if(id<=0) return null;
        return appDB.angajatDao().getZiByID(id);
    }

    public List<Zi> getZiAll(){
        return appDB.angajatDao().getZiAll();
    }

    public void deleteZiByID(int id){
        if(id<=0) return;
        appDB.angajatDao().deleteZiByID(id);
    }





}
