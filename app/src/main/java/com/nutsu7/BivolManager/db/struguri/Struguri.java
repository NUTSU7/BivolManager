package com.nutsu7.BivolManager.db.struguri;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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
    public int quantitySold;

    @ColumnInfo(name = "daysWorked")
    public int daysWorked;

    @ColumnInfo(name = "moneyTotal")
    public int moneyTotal;

    @ColumnInfo(name = "moneyNRTotal")
    public int moneyNRTotal;

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

    public int getQuantitySold() {
        return quantitySold;
    }

    public void addQuantitySold(int quantitySold) {
        this.quantitySold += quantitySold;
    }

    public void decQuantitySold(int quantitySold) {
        this.quantitySold -= quantitySold;
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

    public int getMoneyTotal() {
        return moneyTotal;
    }

    public void addMoneyTotal(int moneyTotal) {
        this.moneyTotal += moneyTotal;
    }

    public void decMoneyTotal(int moneyTotal) {
        this.moneyTotal -= moneyTotal;
    }

    public int getMoneyNRTotal() {
        return moneyNRTotal;
    }

    public void addMoneyNRTotal(int moneyNRTotal) {
        this.moneyNRTotal += moneyNRTotal;
    }

    public void decMoneyNRTotal(int moneyNRTotal) {
        this.moneyNRTotal -= moneyNRTotal;
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
}