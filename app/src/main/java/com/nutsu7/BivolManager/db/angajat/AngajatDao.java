package com.nutsu7.BivolManager.db.angajat;

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

    @Query("SELECT * FROM Angajat")
    public List<Angajat> getAll();

    @Query("SELECT * FROM Angajat WHERE id=:id")
    public Angajat getByID(int id);

    @Query("SELECT * FROM Zi")
    public List<Zi> getZiAll();

    @Query("SELECT * FROM Zi WHERE angajatID=:id")
    public List<Zi> getZiByID(int id);

    @Query("DELETE FROM Zi WHERE angajatID=:id")
    public void deleteZiByID(int id);

    @Insert
    public void insertZi(Zi zi);

    //@Transaction
    //@Query("SELECT * FROM Angajat")
    //public List<AngajatZi> getAngajatZi();
}
