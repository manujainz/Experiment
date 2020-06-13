package com.jain.manu.experiment.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jain.manu.experiment.R
import com.jain.manu.experiment.base.BaseActivity
import com.jain.manu.experiment.ui.fragment.MusicFragment
import com.jain.manu.experiment.ui.fragment.ProfileFragment
import com.jain.manu.experiment.utils.Logger
import com.jain.manu.experiment.viewmodel.FragViewModel
import kotlinx.android.synthetic.main.activity_frag.*

class FragActivity: BaseActivity() {

    private val logger: Logger by lazy { Logger(isEnabled = true) }

    private val fm : FragmentManager by lazy { supportFragmentManager }

    private lateinit var mViewModel : FragViewModel

    private lateinit var scoreTV : TextView
    private lateinit var scoreButton : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frag)

        mViewModel = ViewModelProviders
                        .of(this)
                        .get(FragViewModel::class.java)

        logger.d(TAG, "onCreate")

        initUI()
    }

    private fun initUI() {

        scoreTV = findViewById(R.id.score)
        scoreButton = findViewById(R.id.add_score)

        // fragment transaction

        add.setOnClickListener{ performFragmentTransaction(0) }

        replace.setOnClickListener{ performFragmentTransaction(1) }

        remove.setOnClickListener{ performFragmentTransaction(2) }

        // observe score

        mViewModel.getScore()
                .observe(this,
                    Observer {
                        scoreTV.text = it.toString()
                    }
                )

        // update score

        scoreButton.setOnClickListener{ mViewModel.updateScore() }

    }

    private fun performFragmentTransaction(mode : Int) {
        val transaction = fm.beginTransaction()

        when(mode) {
            0 -> transaction.add(R.id.container_one, ProfileFragment.getInstance(null),"ProfileFragment" + " " + fm.backStackEntryCount)
            1 -> transaction.replace(R.id.container_one,MusicFragment.getInstance(null),"MusicFragment")
            else -> transaction.remove(fm.fragments[0])
        }
        transaction.commit()
        transaction.addToBackStack("fragment " + fm.backStackEntryCount)
        updateFragmentCount()
    }

    private fun updateFragmentCount() {
        fragment_count.text = fm.backStackEntryCount.toString()
    }


    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
        logger.d(TAG, "onAttachFragment")
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
        val TAG = FragActivity::class.java.simpleName
        val ID = "SAMPLE ID"
    }
}