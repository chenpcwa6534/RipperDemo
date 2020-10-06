package com.example.dexlight.ui.main.model

import com.example.dexlight.datacenter.network.response.RoomInfo
import com.example.dexlight.ui.main.model.bean.Device
import com.example.dexlight.ui.main.model.bean.Room

class DataFilter{
    fun filterRooms(data: MutableList<RoomInfo.Room>): MutableList<Room>{
        val modelRooms = mutableListOf<Room>()
        data.forEach {
            val modelDevices = mutableListOf<Device>()
            it.deviceList.forEach {
                val device = Device(it.name, it.mode, it.type, false)
                modelDevices.add(device)
            }
            val room = Room(it.name, modelDevices)
            modelRooms.add(room)
        }
        return modelRooms
    }
}