package com.example.dexlight.widget

import android.content.Context
import android.util.AttributeSet
import com.example.dexlight.R

class LayoutRecyclerView @JvmOverloads constructor(context: Context, val attributeSet: AttributeSet? = null): androidx.recyclerview.widget.RecyclerView(context, attributeSet){

    enum class LayoutManagerMode(val index: Int){
        VERTICAL(0),
        HORIZONTAL(1),
        GRID(2)
    }

    init {
        layoutManagerSetting()
    }

    private fun layoutManagerSetting(){
        val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.LayoutRecyclerView)
        var mode = LayoutManagerMode.VERTICAL.index
        if (attributeSet != null) mode = typedArray.getInt(R.styleable.LayoutRecyclerView_mode, 0)

        when(mode){
            LayoutManagerMode.VERTICAL.index -> this.layoutManager = getLinearLayoutManager(androidx.recyclerview.widget.LinearLayoutManager.VERTICAL)
            LayoutManagerMode.HORIZONTAL.index -> this.layoutManager = getLinearLayoutManager(androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL)
            LayoutManagerMode.GRID.index ->  {
                val column = typedArray.getInt(R.styleable.LayoutRecyclerView_grid_column, 2)
                this.layoutManager = getGridViewLayoutManager(column)
            }
        }
    }

    private fun getLinearLayoutManager(direction: Int): androidx.recyclerview.widget.LinearLayoutManager {
        val lm = androidx.recyclerview.widget.LinearLayoutManager(context)
        lm.orientation = direction
        return lm
    }

    private fun getGridViewLayoutManager(column: Int) = androidx.recyclerview.widget.GridLayoutManager(context, column)
}