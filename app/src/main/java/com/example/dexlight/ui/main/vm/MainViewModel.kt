package com.example.dexlight.ui.main.vm

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.dexlight.ui.main.Contract
import com.example.dexlight.ui.main.adapter.DeviceAdapter
import com.example.dexlight.ui.main.model.bean.Device
import com.example.lib.rigger.ViewModelRigger

class MainViewModel  constructor(application: Application, context: Context, val model: Contract.ModelImpl, navController: NavController) : ViewModelRigger(application, context, navController), Contract.ViewModelImpl, DeviceAdapter.OnClickListener, DeviceAdapter.OnSwitchListener {

    private val submitter = Submitter()

    companion object{
        fun getInstance(application: Application, context: Context, model: Contract.ModelImpl, navController: NavController) = MainViewModel(application, context, model, navController)
    }

    override fun getSubmitter(): Submitter = this.submitter

    init {
        this.submitter.roomList.value = this.model.getAllDevice()
        this.submitter.onAdapterClickListener.value = this
        this.submitter.onAdapterSwitchListener.value = this
    }

    override fun onCreateItem() {

    }

    override fun onClickListener(device: Device) {
        
    }

    override fun onReconnect(device: Device) {

    }

    override fun onSwitch(device: Device, isChecked: Boolean) {

    }

    class Factory(val application: Application, val context: Context, val model: Contract.ModelImpl, val navController: NavController): ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T = getInstance(application, context, model, navController) as T
    }


}