package com.example.lib.image.slidesview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.lib.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.layout_slides_view.view.*

class SlidesView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null): FrameLayout(context, attributeSet){

    init {
        onCreatedView()
    }

    private fun onCreatedView(){
        val view = LayoutInflater.from(this.context).inflate(R.layout.layout_slides_view, null)
        this.addView(view)
    }

    fun setAdapter(adapter: Adapter<*>?) {
        viewpager.adapter = adapter
        TabLayoutMediator(dot, viewpager){ tab, position ->

        }.attach()
    }
}