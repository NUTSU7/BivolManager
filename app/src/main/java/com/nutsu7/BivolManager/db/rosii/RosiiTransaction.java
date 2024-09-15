package com.nutsu7.BivolManager.db.rosii;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Entity(tableName = "RosiiTransaction")
public class RosiiTransaction {
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "quantity1")
    private String quantity1;

    @ColumnInfo(name = "quantity2")
    private String quantity2;

    @ColumnInfo(name = "boxNr1")
    private Integer boxNr1;

    @ColumnInfo(name = "boxNr2")
    private Integer boxNr2;

    @ColumnInfo(name = "price1")
    private Double price1;

    @ColumnInfo(name = "price2")
    private Double price2;

    @ColumnInfo(name = "day")
    private Integer day;

    @ColumnInfo(name = "month")
    private String month;

    @ColumnInfo(name = "year")
    private Integer year;


    public RosiiTransaction(){

    }

    public RosiiTransaction(int id, List<Double> quantity1, List<Double> quantity2, Integer boxNr1, Integer boxNr2, Double price1, Double price2, Integer day, String month, Integer year) {
        this.id = id;
        setQuantity1(quantity1);
        setQuantity2(quantity2);
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

    public List<Double> getQuantity1List() {
        List<Double> list = Arrays.stream(quantity1.split("/"))
                .mapToDouble(Double::parseDouble)
                .boxed().collect(Collectors.toList());
        return list;
    }

    public void setQuantity1(List<Double> quantity1) {
        this.quantity1 = String.valueOf(rouding(quantity1.get(0)))+"/"+
                String.valueOf(rouding(quantity1.get(1)))+"/"+
                String.valueOf(rouding(quantity1.get(2)));
    }

    public List<Double> getQuantity2List() {
        List<Double> list = Arrays.stream(quantity2.split("/"))
                .mapToDouble(Double::parseDouble)
                .boxed().collect(Collectors.toList());
        return list;
    }

    public void setQuantity2(List<Double> quantity2) {
        this.quantity2 = String.valueOf(rouding(quantity2.get(0)))+"/"+
                String.valueOf(rouding(quantity2.get(1)))+"/"+
                String.valueOf(rouding(quantity2.get(2)));
    }

    public Integer getBoxNr1() {
        return boxNr1;
    }

    public void setBoxNr1(Integer boxNr1) {
        this.boxNr1 = boxNr1;
    }

    public Integer getBoxNr2() {
        return boxNr2;
    }

    public void setBoxNr2(Integer boxNr2) {
        this.boxNr2 = boxNr2;
    }

    public Double getPrice1() {
        return price1;
    }

    public void setPrice1(Double price1) {
        this.price1 = rouding(price1);
    }

    public Double getPrice2() {
        return price2;
    }

    public void setPrice2(Double price2) {
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

    //


    public void setQuantity1(String quantity1) {
        this.quantity1 = quantity1;
    }

    public void setQuantity2(String quantity2) {
        this.quantity2 = quantity2;
    }

    public String getQuantity1() {
        return quantity1;
    }

    public String getQuantity2() {
        return quantity2;
    }
}
