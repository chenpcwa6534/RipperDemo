package com.example.dexlight.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.dexlight.R
import com.example.dexlight.utils.TypeUtils

object ImageUtils{
    /** Databinding Extension*/
    @JvmStatic
    @BindingAdapter("src_tutorial")
    fun ImageView.setTutorialImage(res: Int){
        this.setImageResource(res)
    }

    @JvmStatic
    @BindingAdapter("src_lamp_type")
    fun ImageView.setLampType(type: Int){
        this.setImageResource(
            when(type){
                TypeUtils.DeviceType.DESKLAMP.typeCode -> R.mipmap.ic_light_on
                else -> -0
            }
        )
    }
}