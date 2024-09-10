package com.nutsu7.BivolManager.db.zi;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ZiDao {
    @Insert
    public void insert(Zi zi);

    @Insert
    public void insertAll(List<Zi> ziList);

    @Delete
    public void delete(Zi zi);

    @Query("DELETE FROM Zi WHERE day=:day AND month=:month AND year=:year")
    public void deleteByDate(String day, String month, String year);

    @Query("DELETE FROM Zi WHERE id=:id")
    public void deleteByID(int id);

    @Query("UPDATE Zi SET id=:id2 WHERE id=:id1")
    public void updateIDByID(int id1, int id2);

    @Update
    public void update(Zi zi);

    @Query("SELECT * FROM Zi")
    public List<Zi> getAll();

    @Query("SELECT * FROM Zi WHERE day=:day AND month=:month AND year=:year")
    public LiveData<Zi> getLiveByDate(String day, String month, String year);

    @Query("SELECT * FROM Zi WHERE day=:day AND month=:month AND year=:year")
    public Zi getByDate(String day, String month, String year);

    @Query("SELECT * FROM Zi WHERE id=:id")
    public LiveData<Zi> getLiveByID(int id);

    @Query("SELECT * FROM Zi WHERE id=:id")
    public Zi getByID(int id);


}
