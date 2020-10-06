package com.example.dexlight.di

import androidx.lifecycle.ViewModelProvider
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.dexlight.datacenter.Repository

import com.example.dexlight.ui.tutorial.Contract.ViewModelImpl as TutorialViewModelImpl
import com.example.dexlight.ui.tutorial.model.TutorialModel
import com.example.dexlight.ui.tutorial.view.TutorialFragment
import com.example.dexlight.ui.tutorial.vm.TutorialViewModel

import com.example.dexlight.ui.welcome.Contract.ViewModelImpl as WelcomeViewModelImpl
import com.example.dexlight.ui.welcome.model.WelcomeModel
import com.example.dexlight.ui.welcome.view.WelcomeFragment
import com.example.dexlight.ui.welcome.vm.WelcomeViewModel

import com.example.dexlight.ui.main.Contract.ViewModelImpl as MainViewModelImpl
import com.example.dexlight.ui.main.model.MainModel
import com.example.dexlight.ui.main.view.MainFragment
import com.example.dexlight.ui.main.vm.MainViewModel

val tutorialModule = Kodein.Module(Contract.ModuleName.TUTORIAL){
    bind<TutorialViewModelImpl>() with singleton {
        getTutorialViewModel(instance(TutorialFragment().TAG))
    }
}

private fun getTutorialViewModel(fragment: TutorialFragment): TutorialViewModelImpl{
    val model = TutorialModel.getInstance()
    val factory = TutorialViewModel.Factory(fragment.activity!!.application, fragment.context!!, model, findNavController(fragment))
    return ViewModelProvider(fragment, factory).get(TutorialViewModel::class.java)
}

val welcomeModule = Kodein.Module(Contract.ModuleName.WELCOME){
    bind<WelcomeViewModelImpl>() with singleton {
        getWelcomeViewModel(instance(WelcomeFragment().TAG))
    }
}

private fun getWelcomeViewModel(fragment: WelcomeFragment): WelcomeViewModelImpl{
    val model = WelcomeModel.getInstance()
    val factory = WelcomeViewModel.Factory(fragment.activity!!.application, fragment.context!!, model, findNavController(fragment))
    return ViewModelProvider(fragment, factory).get(WelcomeViewModel::class.java)
}

val mainModule = Kodein.Module(Contract.ModuleName.MAIN){
    bind<MainViewModelImpl>() with singleton {
        getMainViewModel(instance(MainFragment().TAG))
    }
}

private fun getMainViewModel(fragment: MainFragment): MainViewModelImpl{
    val repository = Repository.getInstance(fragment.context!!)
    val model = MainModel.getInstance(repository)
    val factory = MainViewModel.Factory(fragment.activity!!.application, fragment.context!!, model, findNavController(fragment))
    return ViewModelProvider(fragment, factory).get(MainViewModel::class.java)
}