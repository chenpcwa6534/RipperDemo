package com.example.dexlight.ui.main.model

import com.example.dexlight.base.BaseModel
import com.example.dexlight.datacenter.Repository
import com.example.dexlight.ui.main.Contract
import com.example.dexlight.ui.main.model.bean.Device
import com.example.dexlight.ui.main.model.bean.Room
import com.example.dexlight.utils.TypeUtils

class MainModel constructor(val repository: Repository): BaseModel(), Contract.ModelImpl{
    companion object{
        fun getInstance(repository: Repository) = MainModel(repository)
    }

    override fun getAllDevice(): MutableList<Room> {
        val response = this.repository.getDeviceList()
        return DataFilter().filterRooms(response)
//        val devices1 = mutableListOf<Device>(
//            Device("Device1", 1, TypeUtils.DeviceType.DESKLAMP.typeCode, false),
//            Device("Device2", 1, TypeUtils.DeviceType.DESKLAMP.typeCode, false),
//            Device("Device3", 1, TypeUtils.DeviceType.DESKLAMP.typeCode, false),
//            Device("Device4", 1, TypeUtils.DeviceType.DESKLAMP.typeCode, false),
//            Device("Device5", 1, TypeUtils.DeviceType.DESKLAMP.typeCode, false),
//            Device("Device6", 1, TypeUtils.DeviceType.DESKLAMP.typeCode, false)
//        )
//
//        val devices2 = mutableListOf<Device>(
//            Device("DeviceA", 1, TypeUtils.DeviceType.DESKLAMP.typeCode, false),
//            Device("DeviceB", 1, TypeUtils.DeviceType.DESKLAMP.typeCode, false),
//            Device("DeviceC", 1, TypeUtils.DeviceType.DESKLAMP.typeCode, false),
//            Device("DeviceD", 1, TypeUtils.DeviceType.DESKLAMP.typeCode, false),
//            Device("DeviceE", 1, TypeUtils.DeviceType.DESKLAMP.typeCode, false),
//            Device("DeviceF", 1, TypeUtils.DeviceType.DESKLAMP.typeCode, false)
//        )
//        return mutableListOf(Room("ALL", devices1), Room("Kitchen", devices2))
    }
}