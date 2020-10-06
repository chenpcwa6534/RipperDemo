package com.example.dexlight.extension

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.dexlight.R
import com.example.dexlight.utils.TypeUtils

object TextViewUtils {

    @JvmStatic
    @BindingAdapter("device_mode")
    fun TextView.setDeviceMode(mode: Int){
        this.setText(
            when(mode){
                TypeUtils.DeviceMode.SAVING.modeCode -> R.string.mode_saving
                TypeUtils.DeviceMode.SUN.modeCode -> R.string.mode_sun
                TypeUtils.DeviceMode.READ.modeCode -> R.string.mode_read
                TypeUtils.DeviceMode.DIGIT.modeCode -> R.string.mode_digit
                TypeUtils.DeviceMode.CUSTOM1.modeCode -> R.string.mode_custom_1
                TypeUtils.DeviceMode.CUSTOM2.modeCode -> R.string.mode_custom_2
                TypeUtils.DeviceMode.CUSTOM3.modeCode -> R.string.mode_custom_3
                else  -> R.string.mode_normal
            }
        )
    }
}