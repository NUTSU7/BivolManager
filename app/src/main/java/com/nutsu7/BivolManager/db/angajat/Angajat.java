package com.nutsu7.BivolManager.db.angajat;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

@Entity(tableName = "Angajat")
public class Angajat {
    @PrimaryKey
    public static int idC=0;
    @ColumnInfo(name = "id")
    private final int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "surname")
    private String surname;

    @ColumnInfo(name = "salary")
    private int salary;

    @ColumnInfo(name = "hourlyRate")
    private int hourlyRate;

    @ColumnInfo(name = "debt")
    private int debt;
    private Map<LocalDate, Integer> hours = new TreeMap<>();

    public Angajat(int id, String name, String surname, int salary, int hourlyRate, int debt) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.hourlyRate = hourlyRate;
        this.debt = debt;
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

    public void setSalary(int salary) {
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

    public void setDebt(int debt) {
        this.debt += debt;
    }

    public int getHoursWorked(LocalDate date) {
        if(!hours.containsKey(date)) return 0;
        return (int)(hours.get(date));
    }

    public void setHoursWorked(String date, int hours) {
        this.hours.put(LocalDate.parse(date), hours);
    }
}
