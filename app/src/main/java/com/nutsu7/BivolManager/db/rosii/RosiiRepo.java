package com.nutsu7.BivolManager.db.rosii;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.nutsu7.BivolManager.db.AppDB;
import com.nutsu7.BivolManager.db.rosii.Rosii;
import com.nutsu7.BivolManager.db.rosii.RosiiTransaction;

import java.util.List;

public class RosiiRepo {
    private AppDB appDB;
    private Context context;

    public RosiiRepo(Context context){
        this.context=context;
        appDB=AppDB.getAppDB(context);
    }

    public void insert(Rosii rosii){
        if(rosii==null) return;
        appDB.rosiiDao().insert(rosii);
    }

    public Rosii get(){
        Rosii rosii = appDB.rosiiDao().get();
        if(rosii==null){
            Rosii rosii1 = new Rosii();
            appDB.rosiiDao().insert(rosii1);
            return rosii1;
        }
        return rosii;
    }

    public void update(Rosii rosii){
        if(rosii==null) return;
        appDB.rosiiDao().update(rosii);
    }

    public LiveData<Rosii> getLiveRosii(){
        return appDB.rosiiDao().getLiveRosii();
    }



    //Transaction part

    public void insert(RosiiTransaction rosiiTransaction){
        if(rosiiTransaction ==null) return;
        appDB.rosiiDao().insert(rosiiTransaction);
    }

    public void insertList(List<RosiiTransaction> rosiiTransactionList){
        if(getAllTransaction().isEmpty()) return;
        appDB.rosiiDao().insertAll(rosiiTransactionList);
    }

    public RosiiTransaction getTransactionByID(int id){
        if(id<0) return null;
        return appDB.rosiiDao().getTransactionByID(id);
    }

    public List<RosiiTransaction> getAllTransaction(){
        return appDB.rosiiDao().getAllTransaction();
    }


    public void deleteTransaction(RosiiTransaction rosiiTransaction) {
        if (rosiiTransaction == null) return;
        int id = rosiiTransaction.getId();

        appDB.rosiiDao().deleteTransactionByID(id);

        List<RosiiTransaction> rosiiTransactionList = appDB.rosiiDao().getAllTransaction();
        if (id != rosiiTransactionList.size()) {
            int temp = id + 1;
            for (RosiiTransaction a : rosiiTransactionList) {

                if (a.getId() > id) {
                    appDB.rosiiDao().updateTransactionIDByID(temp, temp - 1);
                    temp++;
                }
            }
        }

    }

    public void deleteTransactionByID(int id){
        if(id<0) return;
        appDB.rosiiDao().deleteTransactionByID(id);
    }


    public void update(RosiiTransaction rosiiTransaction){
        if(rosiiTransaction ==null) return;
        appDB.rosiiDao().update(rosiiTransaction);
    }
}
