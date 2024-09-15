package com.nutsu7.BivolManager.ui.rosii;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RosiiPagerViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RosiiPagerViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is rosii fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}