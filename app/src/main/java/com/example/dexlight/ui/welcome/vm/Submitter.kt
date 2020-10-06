package com.example.dexlight.ui.welcome.vm

import android.view.View
import androidx.lifecycle.MutableLiveData


class Submitter {
    val onClickListener = MutableLiveData<View.OnClickListener>()
    val title = MutableLiveData<String>()
}