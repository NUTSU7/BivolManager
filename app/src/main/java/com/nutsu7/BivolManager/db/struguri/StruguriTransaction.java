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

    @ColumnInfo(name = "netQuant")
    private int netQuant;

    @ColumnInfo(name = "paletteNr")
    private int paletteNr;

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

    public StruguriTransaction(int id, String buyer, int quantity, int paletteNr, int price, int priceNoReceipt, Integer day, String month, Integer year) {
        this.id = id;
        this.buyer = buyer;
        this.quantity = quantity;
        this.paletteNr = paletteNr;
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

    public int getNetQuant() {
        return netQuant;
    }

    public void setNetQuant(int netQuant) {
        this.netQuant = netQuant;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPaletteNr() {
        return paletteNr;
    }

    public void setPaletteNr(int paletteNr) {
        this.paletteNr = paletteNr;
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
}
