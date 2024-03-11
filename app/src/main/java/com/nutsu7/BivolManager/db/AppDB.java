package com.nutsu7.BivolManager.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.nutsu7.BivolManager.db.angajat.Angajat;
import com.nutsu7.BivolManager.db.angajat.AngajatDao;

@Database(version = 4, entities = {Angajat.class})
public abstract class AppDB extends RoomDatabase {
    public abstract AngajatDao angajatDao();
    private static AppDB appDB;

    static AppDB getAppDB(final Context context){
        if(appDB==null){
            synchronized (AppDB.class){
                AppDB db = Room.databaseBuilder(context,
                        AppDB.class, "database-name").build();
            }
        }
        return appDB;
    }
}
