package com.nutsu7.BivolManager.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.nutsu7.BivolManager.db.angajat.Angajat;
import com.nutsu7.BivolManager.db.angajat.AngajatDao;
import com.nutsu7.BivolManager.db.angajat.Zi;

@Database(version = 4, entities = {Angajat.class, Zi.class})
public abstract class AppDB extends RoomDatabase {
    public abstract AngajatDao angajatDao();
    private static AppDB appDB;

    public static AppDB getAppDB(final Context context){
        if(appDB==null){
            synchronized (AppDB.class){
                appDB = Room.databaseBuilder(context,
                        AppDB.class, "BivolM_DB").allowMainThreadQueries().build();
            }
        }
        return appDB;
    }
}
