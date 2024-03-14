package com.nutsu7.BivolManager.db.angajat;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Zi")
public class Zi {
    @PrimaryKey
    private int id;
    @ColumnInfo(name = "angajatID")
    private int angajatID;
    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "hours")
    private int hours;

    public Zi(int id, int angajatID, String date, int hours) {
        this.id = id;
        this.angajatID = angajatID;
        this.date = date;
        this.hours = hours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAngajatID() {
        return angajatID;
    }

    public void setAngajatID(int angajatID) {
        this.angajatID = angajatID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
