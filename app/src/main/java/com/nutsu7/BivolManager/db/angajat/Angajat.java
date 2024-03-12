package com.nutsu7.BivolManager.db.angajat;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.nutsu7.BivolManager.ui.angajat.AngajatFragment;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

@Entity(tableName = "Angajat")
public class Angajat {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "surname")
    private String surname;

    @ColumnInfo(name = "salary")
    private int salary=0;

    @ColumnInfo(name = "hourlyRate")
    private int hourlyRate;

    @ColumnInfo(name = "debt")
    private int debt;

    @ColumnInfo(name = "totalHours")
    private int totalHours;
    //private Map<LocalDate, Integer> hours = new TreeMap<>();



    public Angajat(String surname, String name, int salary, int hourlyRate, int debt, int totalHours) {
        this.name = name;
        this.surname = surname;
        addSalary(salary);
        setHourlyRate(hourlyRate);
        addDebt(debt);
        addTotalHours(totalHours);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void addSalary(int salary) {
        this.salary += salary;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getDebt() {
        return debt;
    }

    public void addDebt(int debt) {
        this.debt += debt;
    }

    /*public int getHours(LocalDate date) {
        if(!hours.containsKey(date)) return 0;
        return (int)(hours.get(date));
    }

    public void addHours(String date, int hours) {
        this.hours.put(LocalDate.parse(date), hours);

    } */

    public int getTotalHours() {
        return totalHours;
    }

    public void addTotalHours(int totalHours) {
        this.totalHours += totalHours;
    }
}

