package com.nutsu7.BivolManager.ui.struguri;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.nutsu7.BivolManager.db.struguri.StruguriRepo;
import com.nutsu7.BivolManager.db.struguri.StruguriTransaction;

import java.math.RoundingMode;
import java.text.DecimalFormat;

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

    public double getQuantity(){
        return struguriTransaction.getQuantity();
    }

    public double getQuantityNR(){
        return struguriTransaction.getQuantityNoReceipt();
    }

    public double getBoxWeight(){
        return struguriTransaction.getBoxWeight();
    }

    public double getMoney(){
        return rouding(struguriTransaction.getQuantity()*struguriTransaction.getPrice());
    }

    public double getMoneyNC(){
        return rouding(struguriTransaction.getQuantityNoReceipt()*struguriTransaction.getPriceNoReceipt());
    }

    public double getPrice(){
        return struguriTransaction.getPrice();
    }

    public double getPriceNC(){
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

    private double rouding(Double a){
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        String formatResult = decimalFormat.format(a);
        return Double.parseDouble(formatResult);
    }
}