package com.nutsu7.BivolManager.db.angajat;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AngajatDao {
    @Insert
    public void insert(Angajat angajat);

    @Delete
    public void delete(Angajat angajat);

    @Update
    public void update(Angajat angajat);

    @Query("SELECT * FROM Angajat")
    public List<Angajat> getAll();

    //@Transaction
    //@Query("SELECT * FROM Angajat")
    //public List<AngajatZi> getAngajatZi();
}
