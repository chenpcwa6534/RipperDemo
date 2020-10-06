package com.example.dexlight

import android.os.Bundle
import com.example.dexlight.base.BaseActivity
import com.example.lib.components.LayoutId
import com.example.lib.components.NavHosttId

@LayoutId(R.layout.activity_main)
@NavHosttId(R.id.mainFragment)
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}