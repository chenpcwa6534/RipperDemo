package com.example.dexlight.ui.main.model.bean

data class Device(val name: String, val mode: Int, val type: Int, val isOpen: Boolean = false, val isConnected: Boolean = true)