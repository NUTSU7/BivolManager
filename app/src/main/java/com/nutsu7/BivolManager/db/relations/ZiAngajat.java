package com.nutsu7.BivolManager.db.relations;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ZiAngajat")
public class ZiAngajat {
    @PrimaryKey
    private int id;
    private int ziID;
    private int angajatID;
    private int hours;

    public ZiAngajat(int id, int ziID, int angajatID, int hours) {
        this.id = id;
        this.ziID = ziID;
        this.angajatID = angajatID;
        this.hours = hours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getZiID() {
        return ziID;
    }

    public void setZiID(int ziID) {
        this.ziID = ziID;
    }

    public int getAngajatID() {
        return angajatID;
    }

    public void setAngajatID(int angajatID) {
        this.angajatID = angajatID;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
