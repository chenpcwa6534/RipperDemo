package com.example.dexlight.ui.tutorial.vm

import android.app.Application
import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.dexlight.R
import com.example.dexlight.base.BaseViewModel
import com.example.dexlight.ui.tutorial.Contract
import com.example.dexlight.ui.tutorial.view.TutorialFragmentDirections

class TutorialViewModel constructor(application: Application, context: Context, val model: Contract.ModelImpl, navController: NavController) : BaseViewModel(application, context, navController), Contract.ViewModelImpl, View.OnClickListener {

    private val submitter = Submitter()

    init {
        this.submitter.onClickListener.value = this
    }

    companion object{
        fun getInstance(application: Application, context: Context, model: Contract.ModelImpl, navController: NavController) =
            TutorialViewModel(application, context, model, navController)
    }

    override fun getSubmitter(): Submitter = this.submitter

    override fun onClick(view: View?) {
        when(view!!.id){
            R.id.btn_skip ->{
                //Need args
                val action = TutorialFragmentDirections.actionTutorialFragmentToWelcomeFragment("title")
                this.transFragment(action)

                //No args
//                this.transFragment(R.id.action_tutorialFragment_to_welcomeFragment)
            }
        }
    }

    class Factory(val application: Application, val context: Context, val model: Contract.ModelImpl, val navController: NavController): ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T = getInstance(application, context, model, navController) as T
    }
}