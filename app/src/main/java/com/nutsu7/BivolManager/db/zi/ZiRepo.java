package com.nutsu7.BivolManager.db.zi;

import android.content.Context;
import android.util.Pair;

import androidx.lifecycle.LiveData;

import com.nutsu7.BivolManager.db.AppDB;
import com.nutsu7.BivolManager.db.angajat.Angajat;
import com.nutsu7.BivolManager.db.relations.ZiAngajat;

import java.util.ArrayList;
import java.util.List;

public class ZiRepo {
    private AppDB appDB;
    private Context context;


    public ZiRepo(Context context){
        this.context=context;
        appDB=AppDB.getAppDB(context);
    }


    public void insert(Zi zi){
        if(zi==null) return;
        appDB.ziDao().insert(zi);
    }

    public void insertList(List<Zi> ziList){
        if(getAll().isEmpty()) return;
        appDB.ziDao().insertAll(ziList);
    }

    public Zi getByID(int id){
        if(id<0) return null;
        return appDB.ziDao().getByID(id);
    }
    public LiveData<Zi> getLiveByID(int id){
        if(id<0) return null;
        return appDB.ziDao().getLiveByID(id);
    }

    public List<Zi> getAll(){
        return appDB.ziDao().getAll();
    }

    public void delete(Zi zi){
        if(zi==null) return;
        int id=zi.getId();

        appDB.ziDao().deleteByID(id);

        List<Zi> ziList=appDB.ziDao().getAll();
        if(id==ziList.size()) return;
        int temp=id+1;
        for(Zi a:ziList){

            if(a.getId()>id){
                appDB.ziDao().updateIDByID(temp, temp-1);
                temp++;
            }

        }

        deleteAngajatByZiID(id);


    }

    public void deleteByID(int id){
        if(id<0) return;
        appDB.ziDao().deleteByID(id);
    }


    public void update(Zi zi){
        if(zi==null) return;
        appDB.ziDao().update(zi);
    }
    public List<Angajat> getAngajati(int dayID){
        List<Angajat> angajatList= new ArrayList<>();
        List<ZiAngajat> ziAngajatList = appDB.ziAngajatDao().getAngajatByZiID(dayID);
        for(ZiAngajat ziAngajat:ziAngajatList){
            angajatList.add(appDB.angajatDao().getByID(ziAngajat.getAngajatID()));
        }
        return angajatList;
    }
    public void insertAngajati(int ziID, List<Pair<Integer,Integer>> angajatList){
        for(Pair<Integer,Integer> angajat:angajatList)
            appDB.ziAngajatDao().insert(new ZiAngajat(appDB.ziAngajatDao().getAll().size(), ziID, angajat.first, angajat.second));
    }

    public void deleteAngajatByZiID(int ziID){
        appDB.ziAngajatDao().deleteByZiID(ziID);
        int t=0;
        List<ZiAngajat> ziAngajatList = appDB.ziAngajatDao().getAll();
        for(ZiAngajat ziAngajat:ziAngajatList){
            appDB.ziAngajatDao().updateIDByID(ziAngajat.getId(),t++);
            if(ziAngajat.getZiID()>ziID){
                appDB.ziAngajatDao().updateZiIDByZiID(ziAngajat.getZiID(), ziAngajat.getZiID()-1);
            }
        }
    }

}
