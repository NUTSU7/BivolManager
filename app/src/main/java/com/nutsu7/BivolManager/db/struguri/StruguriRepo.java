package com.nutsu7.BivolManager.db.struguri;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.nutsu7.BivolManager.db.AppDB;

import java.util.List;

public class StruguriRepo {
    private AppDB appDB;
    private Context context;

    public StruguriRepo(Context context){
        this.context=context;
        appDB=AppDB.getAppDB(context);
    }

    public void insert(Struguri struguri){
        if(struguri==null) return;
        appDB.struguriDao().insert(struguri);
    }

    public Struguri get(){
        Struguri struguri = appDB.struguriDao().get();
        if(struguri==null){
            Struguri struguri1 = new Struguri();
            appDB.struguriDao().insert(struguri1);
            return struguri1;
        }
        return struguri;
    }

    public void update(Struguri struguri){
        if(struguri==null) return;
        appDB.struguriDao().update(struguri);
    }

    public LiveData<Struguri> getLiveStruguri(){
        return appDB.struguriDao().getLiveStruguri();
    }



    //Transaction part

    public void insert(StruguriTransaction struguriTransaction){
        if(struguriTransaction ==null) return;
        appDB.struguriDao().insert(struguriTransaction);
    }

    public void insertList(List<StruguriTransaction> struguriTransactionList){
        if(getAllTransaction().isEmpty()) return;
        appDB.struguriDao().insertAll(struguriTransactionList);
    }

    public StruguriTransaction getTransactionByID(int id){
        if(id<0) return null;
        return appDB.struguriDao().getTransactionByID(id);
    }

    public List<StruguriTransaction> getAllTransaction(){
        return appDB.struguriDao().getAllTransaction();
    }


    public void deleteTransaction(StruguriTransaction struguriTransaction) {
        if (struguriTransaction == null) return;
        int id = struguriTransaction.getId();

        appDB.struguriDao().deleteTransactionByID(id);

        List<StruguriTransaction> struguriTransactionList = appDB.struguriDao().getAllTransaction();
        if (id != struguriTransactionList.size()) {
            int temp = id + 1;
            for (StruguriTransaction a : struguriTransactionList) {

                if (a.getId() > id) {
                    appDB.struguriDao().updateTransactionIDByID(temp, temp - 1);
                    temp++;
                }
            }
        }

    }

    public void deleteTransactionByID(int id){
        if(id<0) return;
        appDB.struguriDao().deleteTransactionByID(id);
    }


    public void update(StruguriTransaction struguriTransaction){
        if(struguriTransaction ==null) return;
        appDB.struguriDao().update(struguriTransaction);
    }
}
