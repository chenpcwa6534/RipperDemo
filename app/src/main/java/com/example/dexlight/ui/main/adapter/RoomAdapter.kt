package com.example.dexlight.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.dexlight.BR
import com.example.dexlight.R
import com.example.dexlight.ui.main.model.bean.Room

class RoomAdapter(private val rooms: MutableList<Room>, private val onClickListener: DeviceAdapter.OnClickListener, private val onSwitchListener: DeviceAdapter.OnSwitchListener): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolderItem(DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), R.layout.item_room, parent, false))

    override fun getItemCount(): Int = this.rooms.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewDataBinding = (holder as ViewHolderItem).binding
        viewDataBinding.setVariable(BR.data, this.rooms[position]).let {
            if (!it!!) throw IllegalStateException("Binding $viewDataBinding data variable has wrong.")
        }
        viewDataBinding.setVariable(BR.onClick, this.onClickListener)
        viewDataBinding.setVariable(BR.onSwitch, this.onSwitchListener)
    }

    private class ViewHolderItem(val binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root)
}