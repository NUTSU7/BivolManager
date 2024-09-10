package com.nutsu7.BivolManager.db.rosii;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@Entity(tableName = "RosiiTransaction")
public class RosiiTransaction {
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "quantity1")
    private String quantity1;

    @ColumnInfo(name = "quantity2")
    private String quantity2;

    @ColumnInfo(name = "boxNr1")
    private String boxNr1;

    @ColumnInfo(name = "boxNr2")
    private String boxNr2;

    @ColumnInfo(name = "price1")
    private double price1;

    @ColumnInfo(name = "price2")
    private double price2;

    @ColumnInfo(name = "day")
    private Integer day;

    @ColumnInfo(name = "month")
    private String month;

    @ColumnInfo(name = "year")
    private Integer year;


    public RosiiTransaction(int id, String quantity1, String quantity2, String boxNr1, String boxNr2, double price1, double price2, Integer day, String month, Integer year) {
        this.id = id;
        this.quantity1 = quantity1;
        this.quantity2 = quantity2;
        this.boxNr1 = boxNr1;
        this.boxNr2 = boxNr2;
        this.price1 = rouding(price1);
        this.price2 = rouding(price2);
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuantity1() {
        return quantity1;
    }

    public void setQuantity1(String quantity1) {
        this.quantity1 = quantity1;
    }

    public String getQuantity2() {
        return quantity2;
    }

    public void setQuantity2(String quantity2) {
        this.quantity2 = quantity2;
    }

    public String getBoxNr1() {
        return boxNr1;
    }

    public void setBoxNr1(String boxNr1) {
        this.boxNr1 = boxNr1;
    }

    public String getBoxNr2() {
        return boxNr2;
    }

    public void setBoxNr2(String boxNr2) {
        this.boxNr2 = boxNr2;
    }

    public double getPrice1() {
        return price1;
    }

    public void setPrice1(double price1) {
        this.price1 = rouding(price1);
    }

    public double getPrice2() {
        return price2;
    }

    public void setPrice2(double price2) {
        this.price2 = rouding(price2);
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    private double rouding(Double a){
        DecimalFormat decimalFormat = new DecimalFormat("##.#");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        String formatResult = decimalFormat.format(a);
        return Double.parseDouble(formatResult);
    }
}
