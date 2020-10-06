package com.example.dexlight.ui

import android.os.Bundle
import com.example.dexlight.R
import com.example.dexlight.base.BaseActivity
import com.example.lib.components.LayoutId
import com.example.lib.components.NavHosttId
import com.example.lib.permission.askSensorsPermission

@LayoutId(R.layout.activity_tutorial)
@NavHosttId(R.id.tutorialFragment)
class TutorialActivity: BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        askSensorsPermission {  }
    }
}