package com.nutsu7.BivolManager.ui.muncitori;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MuncitoriViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MuncitoriViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is muncitori fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}