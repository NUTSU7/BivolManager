package com.nutsu7.BivolManager.ui.struguri;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.nutsu7.BivolManager.db.struguri.StruguriRepo;
import com.nutsu7.BivolManager.db.struguri.StruguriTransaction;

public class StruguriTransactionStatsViewModel extends ViewModel {
    private StruguriRepo repo;
    private StruguriTransaction struguriTransaction;
    public void init(Context context, int id){
        repo = new StruguriRepo(context);
        struguriTransaction = repo.getTransactionByID(id);
    }
    public int getID(){
        return struguriTransaction.getId();
    }
    public String getBuyer(){
        return struguriTransaction.getBuyer();
    }

    public int getQuantity(){
        return struguriTransaction.getQuantity();
    }

    public int getQuantityNR(){
        return struguriTransaction.getQuantityNoReceipt();
    }

    public int getBoxWeight(){
        return struguriTransaction.getBoxWeight();
    }

    public int getMoney(){
        return struguriTransaction.getQuantity()*struguriTransaction.getPrice();
    }

    public int getMoneyNC(){
        return struguriTransaction.getQuantityNoReceipt()*struguriTransaction.getPriceNoReceipt();
    }

    public int getPrice(){
        return struguriTransaction.getPrice();
    }

    public int getPriceNC(){
        return struguriTransaction.getPriceNoReceipt();
    }

    public int getBoxNr(){
        return struguriTransaction.getBoxNr();
    }

    public int getBoxNRNr(){
        return struguriTransaction.getBoxNRNr();
    }

    public String getMonth(){
        return struguriTransaction.getMonth();
    }

    public int getDay(){
        return struguriTransaction.getDay();
    }

    public int getYear(){
        return struguriTransaction.getYear();
    }
}