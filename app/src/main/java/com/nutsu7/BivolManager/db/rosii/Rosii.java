package com.nutsu7.BivolManager.db.rosii;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@Entity
public class Rosii {
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "boxCurrent1")
    private int boxCurrent1;

    @ColumnInfo(name = "boxCurrent2")
    private int boxCurrent2;

    @ColumnInfo(name = "quantitySold1")
    private double quantitySold1;

    @ColumnInfo(name = "quantitySold2")
    private double quantitySold2;

    @ColumnInfo(name = "daysWorked")
    private int daysWorked;

    @ColumnInfo(name = "moneyTotal1")
    private double moneyTotal1;

    @ColumnInfo(name = "moneyTotal2")
    private double moneyTotal2;

    public Rosii() {
        this.id=0;
        this.boxCurrent1=0;
        this.boxCurrent2=0;
        this.quantitySold1=0;
        this.quantitySold2=0;
        this.moneyTotal1=0;
        this.moneyTotal2=0;
        this.daysWorked=0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBoxCurrent1() {
        return boxCurrent1;
    }

    public void addBoxCurrent1(int boxCurrent1) {
        this.boxCurrent1 += boxCurrent1;
    }

    public void decBoxCurrent1(int boxCurrent1) {
        this.boxCurrent1 -= boxCurrent1;
    }

    public int getBoxCurrent2() {
        return boxCurrent2;
    }

    public void addBoxCurrent2(int boxCurrent2) {
        this.boxCurrent2 += boxCurrent2;
    }

    public void decBoxCurrent2(int boxCurrent2) {
        this.boxCurrent2-= boxCurrent2;
    }

    public double getQuantitySold1() {
        return quantitySold1;
    }

    public void addQuantitySold1(double quantitySold1) {
        this.quantitySold1 += rouding(quantitySold1);
    }

    public void decQuantitySold1(double quantitySold1) {
        this.quantitySold1 -= rouding(quantitySold1);
    }

    public double getQuantitySold2() {
        return quantitySold2;
    }

    public void addQuantitySold2(double quantitySold2) {
        this.quantitySold2 += rouding(quantitySold2);
    }

    public void decQuantitySold2(double quantitySold2) {
        this.quantitySold2 -= rouding(quantitySold2);
    }

    public int getDaysWorked() {
        return daysWorked;
    }

    public void addDaysWorked(int daysWorked) {
        this.daysWorked += daysWorked;
    }

    public double getMoneyTotal1() {
        return moneyTotal1;
    }

    public void addMoneyTotal1(double moneyTotal1) {
        this.moneyTotal1 += rouding(moneyTotal1);
    }

    public void decMoneyTotal1(double moneyTotal1) {
        this.moneyTotal1 -= rouding(moneyTotal1);
    }

    public double getMoneyTotal2() {
        return moneyTotal2;
    }

    public void addMoneyTotal2(double moneyTotal2) {
        this.moneyTotal2 += rouding(moneyTotal2);
    }

    public void decMoneyTotal2(double moneyTotal2) {
        this.moneyTotal2 -= rouding(moneyTotal2);
    }

    private double rouding(Double a){
        DecimalFormat decimalFormat = new DecimalFormat("##.#");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        String formatResult = decimalFormat.format(a);
        return Double.parseDouble(formatResult);
    }
}
