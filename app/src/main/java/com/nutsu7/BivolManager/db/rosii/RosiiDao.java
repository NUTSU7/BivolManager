package com.nutsu7.BivolManager.db.rosii;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RosiiDao {
    @Insert
    public void insert(Rosii Rosii);

    @Update
    public void update(Rosii Rosii);

    @Query("SELECT * FROM Rosii WHERE id=0")
    public Rosii get();

    @Query("SELECT * FROM Rosii WHERE id=0")
    public LiveData<Rosii> getLiveRosii();


    @Insert
    public void insert(RosiiTransaction RosiiTransaction);

    @Insert
    public void insertAll(List<RosiiTransaction> RosiiTransactionList);

    @Delete
    public void delete(RosiiTransaction RosiiTransaction);

    @Query("DELETE FROM RosiiTransaction WHERE id=:id")
    public void deleteTransactionByID(int id);

    @Update
    public void update(RosiiTransaction RosiiTransaction);

    @Query("UPDATE RosiiTransaction SET id=:id2 WHERE id=:id1")
    public void updateTransactionIDByID(int id1, int id2);

    @Query("SELECT * FROM RosiiTransaction")
    public List<RosiiTransaction> getAllTransaction();

    @Query("SELECT * FROM RosiiTransaction WHERE id=:id")
    public RosiiTransaction getTransactionByID(int id);
}
