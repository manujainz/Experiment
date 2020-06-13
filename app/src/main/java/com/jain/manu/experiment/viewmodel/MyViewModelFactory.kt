package com.jain.manu.experiment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyViewModelFactory(private val id: Int): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass
                    .getConstructor(Int::class.java)
                    .newInstance(id)
    }
}