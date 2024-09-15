package com.nutsu7.BivolManager.db.rosii;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@Entity(tableName = "Rosii")
public class Rosii {
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "boxCurrent1")
    private int boxCurrent1;

    @ColumnInfo(name = "boxCurrent2")
    private int boxCurrent2;

    @ColumnInfo(name = "boxSold1")
    private int boxSold1;

    @ColumnInfo(name = "boxSold2")
    private int boxSold2;

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
        this.boxSold1=0;
        this.boxSold2=0;
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

    public int getBoxSold1() {
        return boxSold1;
    }

    public void addBoxSold1(int boxSold1) {
        this.boxSold1 += boxSold1;
    }

    public void decBoxSold1(int boxSold1) {
        this.boxSold1-= boxSold1;
    }

    public int getBoxSold2() {
        return boxSold2;
    }

    public void addBoxSold2(int boxSold2) {
        this.boxSold2 += boxSold2;
    }

    public void decBoxSold2(int boxSold2) {
        this.boxSold2-= boxSold2;
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

    public void decDaysWorked(int daysWorked) {
        this.daysWorked -= daysWorked;
    }

    public double getMoneyTotal1() {
        return moneyTotal1;
    }

    public void addMoneyTotal1(double quantity, double price) {
        this.moneyTotal1 += rouding(rouding(quantity)*rouding(price));
    }

    public void decMoneyTotal1(double quantity, double price) {
        this.moneyTotal1 -= rouding(quantity*price);
    }

    public double getMoneyTotal2() {
        return moneyTotal2;
    }

    public void addMoneyTotal2(double quantity, double price) {
        this.moneyTotal2 += rouding(rouding(quantity)*rouding(price));
    }

    public void decMoneyTotal2(double quantity, double price) {
        this.moneyTotal2 -= rouding(quantity*price);
    }

    private double rouding(Double a){
        DecimalFormat decimalFormat = new DecimalFormat("##.#");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        String formatResult = decimalFormat.format(a);
        return Double.parseDouble(formatResult);
    }

    //useless

    public void setBoxCurrent1(int boxCurrent1) {
        this.boxCurrent1 = boxCurrent1;
    }

    public void setBoxCurrent2(int boxCurrent2) {
        this.boxCurrent2 = boxCurrent2;
    }

    public void setQuantitySold1(double quantitySold1) {
        this.quantitySold1 = quantitySold1;
    }

    public void setQuantitySold2(double quantitySold2) {
        this.quantitySold2 = quantitySold2;
    }

    public void setDaysWorked(int daysWorked) {
        this.daysWorked = daysWorked;
    }

    public void setMoneyTotal1(double moneyTotal1) {
        this.moneyTotal1 = moneyTotal1;
    }

    public void setMoneyTotal2(double moneyTotal2) {
        this.moneyTotal2 = moneyTotal2;
    }

    public void setBoxSold1(int boxSold1) {
        this.boxSold1 = boxSold1;
    }

    public void setBoxSold2(int boxSold2) {
        this.boxSold2 = boxSold2;
    }
}
