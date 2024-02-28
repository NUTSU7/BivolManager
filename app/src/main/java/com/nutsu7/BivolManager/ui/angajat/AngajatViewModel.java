package com.nutsu7.BivolManager.ui.angajat;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nutsu7.BivolManager.db.angajat.Angajat;

import java.util.ArrayList;

public class AngajatViewModel extends ViewModel {

    ArrayList<Angajat> angajatList;
    MutableLiveData<ArrayList<Angajat>> angajatLiveData;
    public AngajatViewModel() {

        // call your Rest API in init method
        init();
    }

    public MutableLiveData<ArrayList<Angajat>> getAngajatMutableLiveData() {
        return angajatLiveData;
    }

    public void init(){
        populateList();
        angajatLiveData =new MutableLiveData<>();
        angajatLiveData.setValue(angajatList);
    }

    public void populateList(){

        Angajat mun1 = new Angajat(Angajat.idC++, "Liviu", "Bivol", 100, 50, 200);

        angajatList = new ArrayList<>();
        angajatList.add(mun1);
        angajatList.add(mun1);
        angajatList.add(mun1);
        angajatList.add(mun1);
        angajatList.add(mun1);
        angajatList.add(mun1);
        angajatList.add(mun1);
        angajatList.add(mun1);
        angajatList.add(mun1);
        angajatList.add(mun1);
        angajatList.add(mun1);

    }



}