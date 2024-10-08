package com.nutsu7.BivolManager.db.angajat;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AngajatDao {
    @Insert
    public void insert(Angajat angajat);

    @Insert
    public void insertAll(List<Angajat> angajatList);

    @Delete
    public void delete(Angajat angajat);

    @Query("DELETE FROM Angajat WHERE id=:id")
    public void deleteByID(int id);

    @Update
    public void update(Angajat angajat);

    @Query("UPDATE Angajat SET id=:id2 WHERE id=:id1")
    public void updateIDByID(int id1, int id2);

    @Query("SELECT * FROM Angajat")
    public List<Angajat> getAll();

    @Query("SELECT * FROM Angajat WHERE id=:id")
    public LiveData<Angajat> getLiveByID(int id);

    @Query("SELECT * FROM Angajat WHERE id=:id")
    public Angajat getByID(int id);

    //@Transaction
    //@Query("SELECT * FROM Angajat")
    //public List<AngajatZi> getAngajatZi();
}
