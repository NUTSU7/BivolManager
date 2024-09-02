package com.nutsu7.BivolManager.db.struguri;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StruguriDao {

    @Insert
    public void insert(Struguri struguri);

    @Update
    public void update(Struguri struguri);

    @Query("SELECT * FROM Struguri WHERE id=0")
    public Struguri get();

    @Query("SELECT * FROM Struguri WHERE id=0")
    public LiveData<Struguri> getLiveStruguri();


    @Insert
    public void insert(StruguriTransaction struguriTransaction);

    @Insert
    public void insertAll(List<StruguriTransaction> struguriTransactionList);

    @Delete
    public void delete(StruguriTransaction struguriTransaction);

    @Query("DELETE FROM StruguriTransaction WHERE id=:id")
    public void deleteTransactionByID(int id);

    @Update
    public void update(StruguriTransaction struguriTransaction);

    @Query("UPDATE StruguriTransaction SET id=:id2 WHERE id=:id1")
    public void updateTransactionIDByID(int id1, int id2);

    @Query("SELECT * FROM StruguriTransaction")
    public List<StruguriTransaction> getAllTransaction();

    @Query("SELECT * FROM StruguriTransaction WHERE id=:id")
    public StruguriTransaction getTransactionByID(int id);
}
