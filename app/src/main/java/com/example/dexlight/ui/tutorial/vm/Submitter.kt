package com.example.dexlight.ui.tutorial.vm

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.dexlight.utils.Config
import com.example.lib.extension.default

class Submitter {
    val tutorialList = MutableLiveData<MutableList<Int>>().default(Config.tutorials)
    val tutorialTitleList = MutableLiveData<MutableList<Int>>().default(Config.tutorialTitles)

    val onClickListener = MutableLiveData<View.OnClickListener>()
}