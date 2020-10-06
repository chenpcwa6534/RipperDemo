package com.example.dexlight.utils

class TypeUtils {
    enum class DeviceType(val typeCode: Int){
        DESKLAMP(0)
    }

    enum class DeviceMode(val modeCode: Int){
        NORMAL(0),
        SAVING(1),
        SUN(2),
        READ(3),
        DIGIT(4),
        CUSTOM1(5),
        CUSTOM2(6),
        CUSTOM3(7)
    }
}