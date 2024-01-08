package com.nutsu7.BivolManager.ui.muncitori;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MuncitoriViewModel extends ViewModel {

    ArrayList<Muncitor> muncitorList;
    MutableLiveData<ArrayList<Muncitor>> muncitorLiveData;
    public MuncitoriViewModel() {

        // call your Rest API in init method
        init();
    }

    public MutableLiveData<ArrayList<Muncitor>> getMuncitorMutableLiveData() {
        return muncitorLiveData;
    }

    public void init(){
        populateList();
        muncitorLiveData=new MutableLiveData<>();
        muncitorLiveData.setValue(muncitorList);
    }

    public void populateList(){

        Muncitor mun1 = new Muncitor("Liviu");

        muncitorList = new ArrayList<>();
        muncitorList.add(mun1);
        muncitorList.add(mun1);
        muncitorList.add(mun1);
        muncitorList.add(mun1);
        muncitorList.add(mun1);
        muncitorList.add(mun1);
        muncitorList.add(mun1);
        muncitorList.add(mun1);
        muncitorList.add(mun1);
        muncitorList.add(mun1);
        muncitorList.add(mun1);

    }



}