package com.example.dexlight.ui.welcome.view

import android.os.Bundle
import android.view.View
import androidx.navigation.NavArgs
import com.example.dexlight.BR
import com.example.dexlight.R
import com.example.dexlight.base.BaseFragment
import com.example.dexlight.di.welcomeModule
import com.example.dexlight.ui.welcome.Contract
import com.example.lib.components.LayoutId
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinContext
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext
import org.kodein.di.generic.singleton

@LayoutId(R.layout.fragment_welcome)
class WelcomeFragment : BaseFragment(), KodeinAware {
    val TAG = "WelcomeFragment"

    /** Dependency Injection **/
    override val kodeinContext: KodeinContext<*> get() = kcontext(activity)

    override val kodein = Kodein.lazy {
        bind<WelcomeFragment>(TAG) with singleton { this@WelcomeFragment }
        import(welcomeModule)
    }

    private val viewModel by kodein.instance<Contract.ViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.binding.setVariable(BR.viewModel, this.viewModel.getSubmitter())

        val args = WelcomeFragmentArgs.fromBundle(this.arguments!!)
        this.viewModel.setArgsTitle(args.title)
    }
}