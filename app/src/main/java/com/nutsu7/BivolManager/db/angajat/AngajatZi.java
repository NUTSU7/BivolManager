package com.nutsu7.BivolManager.db.angajat;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class AngajatZi {
    @Embedded
    public Angajat angajat;
    @Relation(
            parentColumn = "id",
            entityColumn = "angajatID"
    )
    public List<Zi> angajatZile;
}
