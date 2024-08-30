package com.nutsu7.BivolManager.db.struguri;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Struguri")
public class Struguri {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "quantityCurrent")
    public int quantityCurrent;

    @ColumnInfo(name = "quantityHarvested")
    public int quantityHarvested;

    @ColumnInfo(name = "quantitySold")
    public int quantitySold;

    @ColumnInfo(name = "daysWorked")
    public int daysWorked;

    public Struguri() {
        this.id = 0;
        this.quantityCurrent = 0;
        this.quantityHarvested = 0;
        this.quantitySold = 0;
        this.daysWorked = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantityCurrent() {
        return quantityCurrent;
    }

    public void addQuantityCurrent(int quantityCurrent) {
        this.quantityCurrent += quantityCurrent;
    }

    public void decQuantityCurrent(int quantityCurrent) {
        this.quantityCurrent -= quantityCurrent;
    }

    public int getQuantityHarvested() {
        return quantityHarvested;
    }

    public void addQuantityHarvested(int quantityHarvested) {
        this.quantityHarvested += quantityHarvested;
    }

    public void decQuantityHarvested(int quantityHarvested) {
        this.quantityHarvested += quantityHarvested;
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
}