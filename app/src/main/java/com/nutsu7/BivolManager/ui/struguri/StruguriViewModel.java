package com.nutsu7.BivolManager.ui.struguri;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StruguriViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public StruguriViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Struguri fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}