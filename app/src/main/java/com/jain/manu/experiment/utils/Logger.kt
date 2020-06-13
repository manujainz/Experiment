package com.jain.manu.experiment.utils

import android.util.Log

class Logger(private val isEnabled : Boolean) {

    fun d(TAG: String, message: String) {
        if(isEnabled)
            Log.d(TAG,message)
    }
}