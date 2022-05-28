package com.jmmc.thephrasalgames.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jmmc.thephrasalgames.R

class MenuModel: ViewModel(){
    var positionSelected:Int= R.id.menu_game
    val currentSelection: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun changePosition(newPosition:Int){
        positionSelected=newPosition
        currentSelection.setValue(newPosition)
    }
}