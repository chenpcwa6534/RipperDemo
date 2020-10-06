package com.example.dexlight.base

import android.app.Application
import android.content.Context
import androidx.navigation.NavController
import com.example.lib.rigger.ViewModelRigger

open class BaseViewModel constructor(application: Application, context: Context, navController: NavController) : ViewModelRigger(application, context, navController) {

}