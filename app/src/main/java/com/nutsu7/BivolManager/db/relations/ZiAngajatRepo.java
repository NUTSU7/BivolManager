package com.nutsu7.BivolManager.db.relations;

import android.content.Context;

import com.nutsu7.BivolManager.db.AppDB;

import java.util.List;

public class ZiAngajatRepo {
    private AppDB appDB;
    private Context context;


    public ZiAngajatRepo(Context context){
        this.context=context;
        appDB=AppDB.getAppDB(context);
    }


    public void insert(ZiAngajat ziAngajat){
        if(ziAngajat==null) return;
        appDB.ziAngajatDao().insert(ziAngajat);
    }
    public List<ZiAngajat> getAll(){
        return appDB.ziAngajatDao().getAll();
    }

    public List<ZiAngajat> getAngajatByZiID(int id){
        if(id<0) return null;
        return appDB.ziAngajatDao().getAngajatByZiID(id);
    }
    public List<ZiAngajat> getZiByAngajatID(int id){
        if(id<0) return null;
        return appDB.ziAngajatDao().getZiByAngajatID(id);
    }

    public void delete(ZiAngajat ziAngajat){
        if(ziAngajat==null) return;
        int id=ziAngajat.getId();
        List<ZiAngajat> ziAngajatList=appDB.ziAngajatDao().getAll();
        for(int i=id+1; i<ziAngajatList.size(); i++){
            ZiAngajat ziAngajat1 = appDB.ziAngajatDao().getByID(i);
            ziAngajat1.setId(i-1);
            appDB.ziAngajatDao().update(ziAngajat1);
        }
        appDB.ziAngajatDao().deleteByID(ziAngajatList.size()-1);
    }

    public void deleteAngajatByZiID(int id){
        if(id<0) return;
        appDB.ziAngajatDao().deleteByZiID(id);
    }

    public void deleteZiByAngajatID(int id){
        if(id<0) return;
        appDB.ziAngajatDao().deleteByAngajatID(id);
    }


    public void update(ZiAngajat ziAngajat){
        if(ziAngajat==null) return;
        appDB.ziAngajatDao().update(ziAngajat);
    }

}
