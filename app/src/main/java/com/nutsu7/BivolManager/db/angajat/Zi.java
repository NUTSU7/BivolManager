package com.nutsu7.BivolManager.db.angajat;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Zile")
public class Zi {
    @PrimaryKey
    private String date;

    @ColumnInfo(name = "hours")
    private int hours;

}
