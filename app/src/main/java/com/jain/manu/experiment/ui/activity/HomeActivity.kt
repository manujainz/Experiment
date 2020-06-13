package com.jain.manu.experiment.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.jain.manu.experiment.R
import com.jain.manu.experiment.base.BaseActivity
import com.jain.manu.experiment.utils.Logger
import java.util.*

/**
 *  Home activity to demonstrate rotation configutation changes
 */

class HomeActivity: BaseActivity() {

    private val logger: Logger by lazy { Logger(isEnabled = false) }

    private var mScore : String? = null

    private lateinit var mScoreTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home_screen)

        when{
            savedInstanceState == null -> mScore = Random().nextInt(9).toString()
            else -> mScore = savedInstanceState.getString(SCORE)
        }

        initViews()

        logger.d(TAG, "onCreate")
    }

    private fun initViews() {
        mScoreTextView = findViewById(R.id.value_score)
        mScoreTextView.text = mScore

        mScoreTextView.setOnClickListener{ navigate() }
    }

    private fun navigate() {
        startActivity(Intent(this,FragActivity::class.java))
    }

    override fun onStart() {
        super.onStart()
        logger.d(TAG,"Start")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        logger.d(TAG,"onRestoreInstanceState")
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        logger.d(TAG,"onSaveInstanceState")

        outState.run {
            putString(SCORE,mScore)
        }
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



   companion object {
       val TAG = HomeActivity::class.java.simpleName
       val SCORE = "score"
   }
}