package com.example.dexlight.extension

import androidx.databinding.BindingAdapter
import com.example.dexlight.ui.main.adapter.DeviceAdapter
import com.example.dexlight.ui.main.adapter.RoomAdapter
import com.example.dexlight.ui.main.model.bean.Device
import com.example.dexlight.ui.main.model.bean.Room
import com.example.dexlight.widget.LayoutRecyclerView

object Adapter{
    @JvmStatic
    @BindingAdapter("adapter_data_room", "adapter_onClick", "adapter_onSwitch")
    fun LayoutRecyclerView.setRoomListAdapter(data: MutableList<Room>, onClickListener: DeviceAdapter.OnClickListener, onSwitchListener: DeviceAdapter.OnSwitchListener){
        val adapter = RoomAdapter(data, onClickListener, onSwitchListener)
        this.adapter = adapter
    }

    @JvmStatic
    @BindingAdapter("adapter_data_device", "adapter_onClick", "adapter_onSwitch")
    fun LayoutRecyclerView.setDeviceListAdapter(data: MutableList<Device>, onClickListener: DeviceAdapter.OnClickListener, onSwitchListener: DeviceAdapter.OnSwitchListener){
        val adapter = DeviceAdapter(data, onClickListener, onSwitchListener)
        this.adapter = adapter
    }
}