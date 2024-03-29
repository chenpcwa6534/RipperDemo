package com.example.lib.rigger

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.lib.components.AnnotationParse

open abstract class FragmentRigger: Fragment(){

    val binding by lazy {
        val viewDataBinding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(this.context), AnnotationParse.getAnnotatedLayout(this), null, false)
        viewDataBinding.lifecycleOwner = this
        viewDataBinding
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = this.binding.root


}