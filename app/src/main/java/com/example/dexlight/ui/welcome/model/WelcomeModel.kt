package com.example.dexlight.ui.welcome.model

import com.example.dexlight.base.BaseModel
import com.example.dexlight.ui.welcome.Contract

class WelcomeModel: BaseModel(), Contract.ModelImpl{
    companion object{
        fun getInstance() = WelcomeModel()
    }
}