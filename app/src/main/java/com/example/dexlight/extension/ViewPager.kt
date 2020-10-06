package com.example.dexlight.extension

import androidx.databinding.BindingAdapter
import com.example.dexlight.ui.tutorial.adapter.TutorialAdapter
import com.example.lib.image.slidesview.SlidesView

object ViewPager {
    @JvmStatic
    @BindingAdapter("tutorial_list", "tutorial_title_list")
    fun SlidesView.setTutorial(tutorialList: MutableList<Int>, tutorialTitleList: MutableList<Int>){
        val adapter = TutorialAdapter(this.context, tutorialList, tutorialTitleList)
        this.setAdapter(adapter)
    }
}