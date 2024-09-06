package com.nutsu7.BivolManager.db.struguri;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@Entity(tableName = "StruguriTransaction")
public class StruguriTransaction {
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "buyer")
    private String buyer;

    @ColumnInfo(name = "quantity")
    private double quantity;

    @ColumnInfo(name = "quantityNoReceipt")
    private double quantityNoReceipt;

    @ColumnInfo(name = "boxWeight")
    private double boxWeight;

    @ColumnInfo(name = "boxNr")
    private int boxNr;

    @ColumnInfo(name = "boxNRNr")
    private int boxNRNr;

    @ColumnInfo(name = "price")
    private double price;

    @ColumnInfo(name = "priceNoReceipt")
    private double priceNoReceipt;

    @ColumnInfo(name = "day")
    private Integer day;

    @ColumnInfo(name = "month")
    private String month;

    @ColumnInfo(name = "year")
    private Integer year;

    public StruguriTransaction(int id, String buyer, double quantity, double quantityNoReceipt, int boxNr, int boxNRNr, double boxWeight, double price, double priceNoReceipt, Integer day, String month, Integer year) {
        this.id = id;
        this.buyer = buyer;
        this.quantity =  getNetQuantity(quantity, boxNr, boxWeight);
        this.quantityNoReceipt = getNetQuantity(quantityNoReceipt, boxNRNr, boxWeight);
        this.boxNr = boxNr;
        this.boxNRNr = boxNRNr;
        this.boxWeight = rouding(boxWeight);
        this.price = rouding(price);
        this.priceNoReceipt = rouding(priceNoReceipt);
        this.day = day;
        this.month = month;
        this.year = year;
    }

    private double getNetQuantity(double quantity, int boxNr, double boxWeight){
        return rouding(quantity-(boxNr*boxWeight));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public double getBoxWeight() {
        return boxWeight;
    }

    public void setBoxWeight(double boxWeight) {
        this.boxWeight = rouding(boxWeight);
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = rouding(quantity);
    }

    public double getQuantityNoReceipt() {
        return quantityNoReceipt;
    }

    public void setQuantityNoReceipt(double quantityNoReceipt) {
        this.quantityNoReceipt = rouding(quantityNoReceipt);
    }

    public int getBoxNr() {
        return boxNr;
    }

    public void setBoxNr(int boxNr) {
        this.boxNr = boxNr;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = rouding(price);
    }

    public double getPriceNoReceipt() {
        return priceNoReceipt;
    }

    public void setPriceNoReceipt(double priceNoReceipt) {
        this.priceNoReceipt = rouding(priceNoReceipt);
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

    public int getBoxNRNr() {
        return boxNRNr;
    }

    public void setBoxNRNr(int boxNRNr) {
        this.boxNRNr = boxNRNr;
    }

    private double rouding(Double a){
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        String formatResult = decimalFormat.format(a);
        return Double.parseDouble(formatResult);
    }
}
