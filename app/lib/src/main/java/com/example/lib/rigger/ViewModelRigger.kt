package com.example.lib.rigger

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.NavController

open class ViewModelRigger constructor(application: Application, val context: Context, val navController: NavController): AndroidViewModel(application){

    fun transFragment(id: Int){ this.navController.navigate(id) }

    fun transActivity(id: Int){ (this.context as ActivityRigger).transActivity(id) }
}