package com.nutsu7.BivolManager.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.nutsu7.BivolManager.db.angajat.Angajat;
import com.nutsu7.BivolManager.db.angajat.AngajatDao;
import com.nutsu7.BivolManager.db.relations.ZiAngajat;
import com.nutsu7.BivolManager.db.relations.ZiAngajatDao;
import com.nutsu7.BivolManager.db.rosii.Rosii;
import com.nutsu7.BivolManager.db.rosii.RosiiDao;
import com.nutsu7.BivolManager.db.rosii.RosiiTransaction;
import com.nutsu7.BivolManager.db.struguri.Struguri;
import com.nutsu7.BivolManager.db.struguri.StruguriDao;
import com.nutsu7.BivolManager.db.struguri.StruguriTransaction;
import com.nutsu7.BivolManager.db.zi.Zi;
import com.nutsu7.BivolManager.db.zi.ZiDao;

@Database(version = 1, entities = {Angajat.class, Zi.class, ZiAngajat.class, Struguri.class, StruguriTransaction.class, Rosii.class, RosiiTransaction.class})
public abstract class AppDB extends RoomDatabase {
    public abstract AngajatDao angajatDao();
    public abstract ZiDao ziDao();
    public abstract ZiAngajatDao ziAngajatDao();
    public abstract StruguriDao struguriDao();
    public abstract RosiiDao rosiiDao();
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
