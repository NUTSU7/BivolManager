package com.nutsu7.BivolManager.db.angajat;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Angajat")
public class Angajat {
    @PrimaryKey()
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "surname")
    private String surname;

    @ColumnInfo(name = "salary")
    private int salary;

    @ColumnInfo(name = "debt")
    private int debt;

    @ColumnInfo(name = "totalDays")
    private int totalDays;

    @ColumnInfo(name = "totalHours")
    private int totalHours;
    public Angajat(int id, String surname, String name, int salary, int debt) {
        this.id=id;
        this.name = name;
        this.surname = surname;
        addSalary(salary);
        addDebt(debt);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public void decreaseSalary(int salary) {
        this.salary -= salary;
    }

    public int getDebt() {
        return debt;
    }

    public void addDebt(int debt) {
        this.debt += debt;
    }
    public void decreaseDebt(int debt) {
        this.debt -= debt;
    }

    public void decreaseTotalDays(int days) {
        this.totalDays -= days;
    }

    public void decreaseTotalHours(int hours) {
        this.totalHours -= hours;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void addTotalDays(int days) {
        this.totalDays += days;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void addTotalHours(int hours) {
        this.totalHours += hours;
    }


    //not needed


    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }
}

