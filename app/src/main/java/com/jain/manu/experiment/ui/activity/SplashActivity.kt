package com.jain.manu.experiment.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle

import com.jain.manu.experiment.R
import com.jain.manu.experiment.base.BaseActivity
import com.jain.manu.experiment.utils.Logger

class SplashActivity: BaseActivity() {

    private val logger: Logger by lazy { Logger(false)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        routing()
        logger.d(TAG, "onCreate")
    }

    private fun routing() {0
        Handler().postDelayed(
            Runnable {
                toHomeScreen()
            },
            1000
        )
    }

    private fun toMaps() {
        val intent = Intent(Intent.ACTION_VIEW,null)
        intent.setPackage("com.google.android.apps.maps")
        intent.resolveActivity(packageManager)?.apply { startActivity(intent) }
    }

    private fun toHomeScreen() {
        val intent = Intent(this, FragActivity::class.java)
        intent.resolveActivity(packageManager)?.apply { startActivity(intent) }
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
        //finish()
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        logger.d(TAG,"onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        logger.d(TAG,"onRestoreInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        logger.d(TAG,"onRestoreInstanceState")
    }


    companion object {
        val TAG = SplashActivity::class.java.simpleName
    }
}