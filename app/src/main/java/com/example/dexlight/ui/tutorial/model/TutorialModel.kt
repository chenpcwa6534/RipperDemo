package com.example.dexlight.ui.tutorial.model

import com.example.dexlight.base.BaseModel
import com.example.dexlight.ui.tutorial.Contract

class TutorialModel: BaseModel(), Contract.ModelImpl{
    companion object{
        fun getInstance() = TutorialModel()
    }
}