package com.example.dexlight.ui.main.vm

import androidx.lifecycle.MutableLiveData
import com.example.dexlight.ui.main.adapter.DeviceAdapter
import com.example.dexlight.ui.main.model.bean.Room
import com.example.lib.extension.default

class Submitter {
    val roomList = MutableLiveData<MutableList<Room>>().default(mutableListOf())

    val onAdapterClickListener = MutableLiveData<DeviceAdapter.OnClickListener>()
    val onAdapterSwitchListener = MutableLiveData<DeviceAdapter.OnSwitchListener>()
}