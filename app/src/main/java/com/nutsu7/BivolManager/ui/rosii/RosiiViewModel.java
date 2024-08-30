package com.nutsu7.BivolManager.ui.rosii;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RosiiViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RosiiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is rosii fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}