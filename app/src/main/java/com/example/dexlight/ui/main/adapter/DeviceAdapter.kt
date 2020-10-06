package com.example.dexlight.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Switch
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.dexlight.BR
import com.example.dexlight.R
import com.example.dexlight.ui.main.model.bean.Device
import kotlinx.android.synthetic.main.item_device_connected.view.*
import kotlinx.android.synthetic.main.item_device_unconnected.view.*

class DeviceAdapter(private val devices: MutableList<Device>, private val onClickListener: OnClickListener, private val onSwitchListener: OnSwitchListener): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val ITEM_TYPE_DEFAULT = 0x0020
    private val ITEM_TYPE_CONNECTED = 0x0021
    private val ITEM_TYPE_UNCONNECT = 0x0022

    private val ITEM_DEFAULT_COUNT = 1

    interface OnClickListener{
        fun onCreateItem()
        fun onClickListener(device: Device)
        fun onReconnect(device: Device)
    }

    interface OnSwitchListener{
        fun onSwitch(device: Device, isChecked: Boolean)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when(viewType){
            ITEM_TYPE_DEFAULT -> ViewHolderWithDefault(DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), R.layout.item_device_default, parent, false))
            ITEM_TYPE_CONNECTED -> ViewHolderWithConnected(DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), R.layout.item_device_connected, parent, false))
            else -> ViewHolderWithUnConnected(DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), R.layout.item_device_unconnected, parent, false))
        }

    override fun getItemCount(): Int = this.devices.size + ITEM_DEFAULT_COUNT

    override fun getItemViewType(position: Int): Int =
        if(position == 0) ITEM_TYPE_DEFAULT
        else {
            if (this.devices[position - ITEM_DEFAULT_COUNT].isConnected) ITEM_TYPE_CONNECTED
            else ITEM_TYPE_UNCONNECT
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder.itemViewType){
            ITEM_TYPE_DEFAULT -> setDefaultItem((holder as ViewHolderWithDefault).binding)
            ITEM_TYPE_CONNECTED -> setConnectedItem((holder as ViewHolderWithConnected).binding, this.devices[position - ITEM_DEFAULT_COUNT])
            else -> setUnConnectedItem((holder as ViewHolderWithUnConnected).binding, this.devices[position - ITEM_DEFAULT_COUNT])
        }
    }

    private fun setDefaultItem(binding: ViewDataBinding){
        binding.root.setOnClickListener {
            this.onClickListener.onCreateItem()
        }
    }

    private fun setConnectedItem(binding: ViewDataBinding, device: Device){
        binding.setVariable(BR.data, device).let {
            if (!it!!) throw IllegalStateException("Binding $binding data variable has wrong.")
        }
        binding.root.setOnClickListener {
            this.onClickListener.onClickListener(device)
        }
        binding.root.sw_switch.setOnCheckedChangeListener { _, isChecked ->
            this.onSwitchListener.onSwitch(device, isChecked)
        }
    }

    private fun setUnConnectedItem(binding: ViewDataBinding, device: Device){
        binding.setVariable(BR.data, device).let {
            if (!it!!) throw IllegalStateException("Binding $binding data variable has wrong.")
        }
        binding.root.img_reconnect.setOnClickListener {
            this.onClickListener.onReconnect(device)
        }
    }

    private class ViewHolderWithDefault(val binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root)
    private class ViewHolderWithConnected(val binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root)
    private class ViewHolderWithUnConnected(val binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root)
}