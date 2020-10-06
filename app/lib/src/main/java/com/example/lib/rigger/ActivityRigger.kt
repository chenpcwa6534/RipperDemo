package com.example.lib.rigger

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.Navigation
import com.example.lib.components.AnnotationParse
import java.lang.RuntimeException

open class ActivityRigger : AppCompatActivity(){
    private val TAG = "Activity Rigger"

    val binding by lazy {
        val viewDataBinding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(this), AnnotationParse.getAnnotatedLayout(this), null, false)
        viewDataBinding.lifecycleOwner = this
        viewDataBinding
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(this.binding.root)
    }

    fun transActivity(id: Int){
        try {
            val navHostId = AnnotationParse.getAnnotatedNavHost(this)
            Navigation.findNavController(this, navHostId).navigate(id)
        }catch (e: RuntimeException){
            Log.e(TAG, "Can't not find navhostFragment ${e.message}")
        }
    }
}