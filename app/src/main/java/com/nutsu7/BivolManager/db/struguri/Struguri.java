package com.nutsu7.BivolManager.db.struguri;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@Entity(tableName = "Struguri")
public class Struguri {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "boxCurrent")
    public int boxCurrent;

    @ColumnInfo(name = "boxHarvested")
    public int boxHarvested;

    @ColumnInfo(name = "boxSold")
    public int boxSold;
    
    @ColumnInfo(name = "quantitySold")
    public double quantitySold;

    @ColumnInfo(name = "daysWorked")
    public int daysWorked;

    @ColumnInfo(name = "moneyTotal")
    public double moneyTotal;

    @ColumnInfo(name = "moneyNRTotal")
    public double moneyNRTotal;

    public Struguri() {
        this.id = 0;
        this.boxCurrent = 0;
        this.boxHarvested = 0;
        this.boxSold=0;
        this.quantitySold = 0;
        this.daysWorked = 0;
        this.moneyTotal = 0;
        this.moneyNRTotal = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBoxCurrent() {
        return boxCurrent;
    }

    public void addBoxCurrent(int boxCurrent) {
        this.boxCurrent += boxCurrent;
    }

    public void decBoxCurrent(int boxCurrent) {
        this.boxCurrent -= boxCurrent;
    }

    public int getBoxHarvested() {
        return boxHarvested;
    }

    public void addBoxHarvested(int boxHarvested) {
        this.boxHarvested += boxHarvested;
    }

    public void decBoxHarvested(int boxHarvested) {
        this.boxHarvested -= boxHarvested;
    }

    public double getQuantitySold() {
        return quantitySold;
    }

    public void addQuantitySold(double quantitySold) {
        this.quantitySold += rouding(quantitySold);
    }

    public void decQuantitySold(double quantitySold) {
        this.quantitySold -= rouding(quantitySold);
    }

    public int getDaysWorked() {
        return daysWorked;
    }

    public void addDaysWorked(int daysWorked) {
        this.daysWorked += daysWorked;
    }

    public void decDaysWorked(int daysWorked) {
        this.daysWorked -= daysWorked;
    }

    public double getMoneyTotal() {
        return moneyTotal;
    }

    public void addMoneyTotal(double moneyTotal) {
        this.moneyTotal += rouding(moneyTotal);
    }

    public void decMoneyTotal(double moneyTotal) {
        this.moneyTotal -= rouding(moneyTotal);
    }

    public double getMoneyNRTotal() {
        return moneyNRTotal;
    }

    public void addMoneyNRTotal(double moneyNRTotal) {
        this.moneyNRTotal += rouding(moneyNRTotal);
    }

    public void decMoneyNRTotal(double moneyNRTotal) {
        this.moneyNRTotal -= rouding(moneyNRTotal);
    }

    public int getBoxSold() {
        return boxSold;
    }

    public void addBoxSold(int boxSold) {
        this.boxSold += boxSold;
    }

    public void decBoxSold(int boxSold) {
        this.boxSold -= boxSold;
    }

    private double rouding(Double a){
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        String formatResult = decimalFormat.format(a);
        return Double.parseDouble(formatResult);
    }
}