package com.jain.manu.experiment.base

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.jain.manu.experiment.utils.Logger

abstract class BaseActivity: AppCompatActivity() {

    private val logger: Logger by lazy { Logger(isEnabled = false) }

    override fun onCreate(savedInstanceState: Bundle?) {
        initFullScreen()
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        logger.d(TAG,"onCreate")
    }

    override fun onStart() {
        super.onStart()
        logger.d(TAG,"onStart")
    }

    override fun onResume() {
        super.onResume()
        logger.d(TAG,"onResume")
    }

    override fun onPause() {
        super.onPause()
        logger.d(TAG,"onPause")
    }

    override fun onStop() {
        super.onStop()
        logger.d(TAG,"onStop")
    }

    override fun onRestart() {
        super.onRestart()
        logger.d(TAG,"onRestart")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        logger.d(TAG,"onNewIntent")
    }

    override fun onDestroy() {
        super.onDestroy()
        logger.d(TAG,"onDestory")
    }

    open fun initFullScreen() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if(hasFocus) initFullScreen()
    }

    companion object {
        val TAG = BaseActivity::class.java.simpleName
    }

}