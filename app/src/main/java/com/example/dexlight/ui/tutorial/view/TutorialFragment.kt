package com.example.dexlight.ui.tutorial.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinContext
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext
import org.kodein.di.generic.singleton
import com.example.lib.components.LayoutId
import com.example.dexlight.BR
import com.example.dexlight.R
import com.example.dexlight.base.BaseFragment
import com.example.dexlight.di.tutorialModule
import com.example.dexlight.ui.tutorial.Contract

@LayoutId(R.layout.fragment_tutorial)
class TutorialFragment : BaseFragment(), KodeinAware {
    val TAG = "TutorialFragment"

    /** Dependency Injection **/
    override val kodeinContext: KodeinContext<*> get() = kcontext(activity)

    override val kodein = Kodein.lazy {
        bind<TutorialFragment>(TAG) with singleton { this@TutorialFragment }
        import(tutorialModule)
    }

    private val viewModel by kodein.instance<Contract.ViewModelImpl>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
         super.onCreateView(inflater, container, savedInstanceState)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.binding.setVariable(BR.viewModel, this.viewModel.getSubmitter())
    }
}