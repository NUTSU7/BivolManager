package com.nutsu7.BivolManager.ui.rosii;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.nutsu7.BivolManager.db.rosii.RosiiRepo;
import com.nutsu7.BivolManager.db.rosii.RosiiTransaction;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

public class RosiiTransactionStatsViewModel extends ViewModel {
    private RosiiRepo repo;
    private RosiiTransaction rosiiTransaction;

    public void init(Context context, int id){
        repo = new RosiiRepo(context);
        rosiiTransaction = repo.getTransactionByID(id);
    }

    public int getID(){
        return rosiiTransaction.getId();
    }

    public List<Double> getQuantity1(){
        return rosiiTransaction.getQuantity1List();
    }

    public List<Double> getQuantity2(){
        return rosiiTransaction.getQuantity2List();
    }

    public Integer getBoxNr1(){
        return rosiiTransaction.getBoxNr1();
    }

    public Integer getBoxNr2(){
        return rosiiTransaction.getBoxNr2();
    }

    public Double getPrice1(){
        return rosiiTransaction.getPrice1();
    }

    public Double getPrice2(){
        return rosiiTransaction.getPrice2();
    }

    public Double getMoney1(){
        Double sum = rosiiTransaction.getQuantity1List().stream().mapToDouble(Double::doubleValue).sum();

        return rouding(sum* rosiiTransaction.getPrice1());
    }

    public Double getMoney2(){
        Double sum = rosiiTransaction.getQuantity2List().stream().mapToDouble(Double::doubleValue).sum();

        return rouding(sum* rosiiTransaction.getPrice2());
    }

    public String getMonth(){
        return rosiiTransaction.getMonth();
    }

    public int getDay(){
        return rosiiTransaction.getDay();
    }

    public int getYear(){
        return rosiiTransaction.getYear();
    }


    private double rouding(Double a){
        DecimalFormat decimalFormat = new DecimalFormat("##.#");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        String formatResult = decimalFormat.format(a);
        return Double.parseDouble(formatResult);
    }
}