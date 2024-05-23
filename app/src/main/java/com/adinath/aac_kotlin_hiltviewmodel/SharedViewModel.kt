package com.adinath.aac_kotlin_hiltviewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor() : ViewModel(){

    var count: Int = 10

    fun increment(): Unit {
        count++
    }


}