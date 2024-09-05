package com.nutsu7.BivolManager.db.struguri;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "StruguriTransaction")
public class StruguriTransaction {
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "buyer")
    private String buyer;

    @ColumnInfo(name = "quantity")
    private int quantity;

    @ColumnInfo(name = "quantityNoReceipt")
    private int quantityNoReceipt;

    @ColumnInfo(name = "boxWeight")
    private int boxWeight;

    @ColumnInfo(name = "boxNr")
    private int boxNr;

    @ColumnInfo(name = "boxNRNr")
    private int boxNRNr;

    @ColumnInfo(name = "price")
    private int price;

    @ColumnInfo(name = "priceNoReceipt")
    private int priceNoReceipt;

    @ColumnInfo(name = "day")
    private Integer day;

    @ColumnInfo(name = "month")
    private String month;

    @ColumnInfo(name = "year")
    private Integer year;

    public StruguriTransaction(int id, String buyer, int quantity, int quantityNoReceipt, int boxNr, int boxNRNr, int boxWeight, int price, int priceNoReceipt, Integer day, String month, Integer year) {
        this.id = id;
        this.buyer = buyer;
        this.quantity = quantity;
        this.quantityNoReceipt = quantityNoReceipt;
        this.boxNr = boxNr;
        this.boxNRNr = boxNRNr;
        this.boxWeight = boxWeight;
        this.price = price;
        this.priceNoReceipt = priceNoReceipt;
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

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public int getBoxWeight() {
        return boxWeight;
    }

    public void setBoxWeight(int boxWeight) {
        this.boxWeight = boxWeight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantityNoReceipt() {
        return quantityNoReceipt;
    }

    public void setQuantityNoReceipt(int quantityNoReceipt) {
        this.quantityNoReceipt = quantityNoReceipt;
    }

    public int getBoxNr() {
        return boxNr;
    }

    public void setBoxNr(int boxNr) {
        this.boxNr = boxNr;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPriceNoReceipt() {
        return priceNoReceipt;
    }

    public void setPriceNoReceipt(int priceNoReceipt) {
        this.priceNoReceipt = priceNoReceipt;
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
}
