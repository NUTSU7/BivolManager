package com.nutsu7.BivolManager.db.zi;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Zi")
public class Zi {
    @PrimaryKey
    private int id;
    @ColumnInfo(name = "day")
    private Integer day;
    @ColumnInfo(name = "month")
    private String month;
    @ColumnInfo(name = "year")
    private Integer year;
    @ColumnInfo(name="info")
    private String info;
    @ColumnInfo(name = "hours")
    private Integer hours;
    @ColumnInfo(name = "Lucru")
    private String work;
    @ColumnInfo(name = "Quantity1")
    private Integer quantity1;
    @ColumnInfo(name = "Quantity2")
    private Integer quantity2;


    public Zi(int id, Integer day, String month,Integer year,String info, Integer hours, String work, Integer quantity1, Integer quantity2) {
        this.id = id;
        this.day = day;
        this.month = month;
        this.year = year;
        this.info = info;
        this.hours = hours;
        this.work = work;
        this.quantity1 = quantity1;
        this.quantity2 = quantity2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public Integer getQuantity1() {
        return quantity1;
    }

    public void setQuantity1(Integer quantity1) {
        this.quantity1 = quantity1;
    }

    public Integer getQuantity2() {
        return quantity2;
    }

    public void setQuantity2(Integer quantity2) {
        this.quantity2 = quantity2;
    }
}
