package com.example.dexlight.ui.tutorial.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.dexlight.BR
import com.example.dexlight.R

class TutorialAdapter constructor(private val context: Context, private val tutorials: MutableList<Int>, private val titles: MutableList<Int>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), R.layout.item_tutorial, parent, false))

    override fun getItemCount(): Int = this.tutorials.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewDataBinding = (holder as ViewHolder).binding
        viewDataBinding.setVariable(BR.tutorial, this.tutorials[position]).let {
            if (it.not()) throw IllegalStateException("Binding $viewDataBinding data variable has wrong.")
        }
        viewDataBinding.setVariable(BR.title, this.context.getString(this.titles[position])).let {
            if (it.not()) throw IllegalStateException("Binding $viewDataBinding data variable has wrong.")
        }
    }

    private class ViewHolder(val binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root)
}