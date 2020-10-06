package com.example.dexlight.ui.main.view

import android.os.Bundle
import com.example.dexlight.BR
import com.example.dexlight.R
import com.example.dexlight.di.mainModule
import com.example.dexlight.ui.main.Contract
import com.example.lib.components.LayoutId
import com.example.lib.rigger.FragmentRigger
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinContext
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext
import org.kodein.di.generic.singleton

@LayoutId(R.layout.fragment_main)
class MainFragment : FragmentRigger(), KodeinAware {
    val TAG = "MainFragment"

    /** Dependency Injection **/
    override val kodeinContext: KodeinContext<*> get() = kcontext(activity)

    override val kodein = Kodein.lazy {
        bind<MainFragment>(TAG) with singleton { this@MainFragment }
        import(mainModule)
    }

    private val viewModel by kodein.instance<Contract.ViewModelImpl>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.binding.setVariable(BR.viewModel, this.viewModel.getSubmitter())
    }
}