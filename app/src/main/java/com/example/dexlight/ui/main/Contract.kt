package com.example.dexlight.ui.main

import com.example.dexlight.base.BaseViewModelImpl
import com.example.dexlight.ui.main.model.bean.Room
import com.example.dexlight.ui.main.vm.Submitter

class Contract {
    interface ModelImpl{
        fun getAllDevice(): MutableList<Room>
    }

    interface ViewModelImpl: BaseViewModelImpl<Submitter>{

    }
}