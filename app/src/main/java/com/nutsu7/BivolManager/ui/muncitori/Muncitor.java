package com.nutsu7.BivolManager.ui.muncitori;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Muncitor {
    private String name;
    private Map<LocalDate, Integer> workedDays;
    private int salary, moneyPaid;

    public Muncitor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<LocalDate, Integer> getWorkedDays() {
        return workedDays;
    }

    public void setWorkedDays(Map<LocalDate, Integer> workedDays) {
        this.workedDays = workedDays;
    }

    public int getMoneyPaid() {
        return moneyPaid;
    }

    public void setMoneyPaid(int moneyPaid) {
        this.moneyPaid = moneyPaid;
    }
}
