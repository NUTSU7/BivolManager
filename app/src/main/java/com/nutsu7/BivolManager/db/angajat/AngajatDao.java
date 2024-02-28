package com.nutsu7.BivolManager.db.angajat;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

@Dao
public interface AngajatDao {
    @Insert
    public void insert(Angajat angajat);

    @Delete
    public void delete(Angajat angajat);

    @Update
    public void update(Angajat angajat);
}
