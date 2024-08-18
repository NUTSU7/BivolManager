package com.nutsu7.BivolManager.db.relations;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface ZiAngajatDao {
    @Insert
    public void insert(ZiAngajat ziAngajat);

    @Delete
    public void delete(ZiAngajat ziAngajat);

    @Query("DELETE FROM ZiAngajat WHERE id=:id")
    public void deleteByID(int id);

    @Query("DELETE FROM ZiAngajat WHERE ziID=:id")
    public void deleteByZiID(int id);

    @Query("DELETE FROM ZiAngajat WHERE angajatID=:id")
    public void deleteByAngajatID(int id);

    @Update
    public void update(ZiAngajat ziAngajat);

    @Query("UPDATE ZiAngajat SET id=:id2 WHERE id=:id1")
    public void updateIDByID(int id1, int id2);

    @Query("UPDATE ZiAngajat SET ziID=:id2 WHERE ziID=:id1")
    public void updateZiIDByZiID(int id1, int id2);

    @Query("UPDATE ZiAngajat SET angajatID=:id2 WHERE angajatID=:id1")
    public void updateAngajatIDByAngajatID(int id1, int id2);

    @Query("SELECT * FROM ZiAngajat")
    public List<ZiAngajat> getAll();

    @Query("SELECT * FROM ZiAngajat WHERE id=:id")
    public ZiAngajat getByID(int id);

    @Query("SELECT * FROM ZiAngajat WHERE ziID=:id")
    public List<ZiAngajat> getAngajatByZiID(int id);

    @Query("SELECT * FROM ZiAngajat WHERE angajatID=:id")
    public List<ZiAngajat> getZiByAngajatID(int id);

    @Query("SELECT * FROM ZiAngajat WHERE ziID=:ziID AND angajatID=:angajatID")
    public ZiAngajat getByZiIDAndAngajatID(int ziID, int angajatID);
}
