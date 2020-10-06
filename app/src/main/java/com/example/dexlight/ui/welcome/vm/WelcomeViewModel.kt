package com.example.dexlight.ui.welcome.vm

import android.app.Application
import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.dexlight.R
import com.example.dexlight.base.BaseActivity
import com.example.dexlight.base.BaseViewModel
import com.example.dexlight.ui.welcome.Contract

class WelcomeViewModel constructor(application: Application, context: Context, val model: Contract.ModelImpl, navController: NavController) : BaseViewModel(application, context, navController), Contract.ViewModelImpl, View.OnClickListener {

    private val submitter = Submitter()

    companion object{
        fun getInstance(application: Application, context: Context, model: Contract.ModelImpl, navController: NavController) =
            WelcomeViewModel(application, context, model, navController)
    }

    override fun getSubmitter(): Submitter = this.submitter

    init {
        this.submitter.onClickListener.value = this
    }

    override fun onClick(view: View?) {
        when(view!!.id){
            R.id.btn_search -> {
                this.transActivity(R.id.mainActivity)
                (this.context!! as BaseActivity).finish()
            }
        }
    }

    class Factory(val application: Application, val context: Context, val model: Contract.ModelImpl, val navController: NavController): ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T = getInstance(application, context, model, navController) as T
    }
}