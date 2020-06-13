package com.jain.manu.experiment.ui.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jain.manu.experiment.R
import com.jain.manu.experiment.ui.activity.HomeActivity
import com.jain.manu.experiment.utils.Logger
import kotlinx.android.synthetic.main.fragment_profile_page.*

class ProfileFragment  : Fragment() {

    private val logger : Logger by lazy { Logger(true) }
    private lateinit var mContext : Context

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mContext = context
        logger.d(TAG,"onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logger.d(TAG,"onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        logger.d(TAG,"onCreateView")
        return inflater.inflate(R.layout.fragment_profile_page,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logger.d(TAG,"onViewCreated")

        profile_image.setOnClickListener{
            startActivity(Intent(mContext, HomeActivity::class.java))
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        logger.d(TAG,"onActivityCreated")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        logger.d(TAG,"onViewStateRestored")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        logger.d(TAG, "onSaveInstanceState")
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

    override fun onDestroyView() {
        super.onDestroyView()
        logger.d(TAG,"onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        logger.d(TAG,"onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        logger.d(TAG,"onDetach")
    }

    companion object {
        val TAG = ProfileFragment::class.java.simpleName
        val MESSAGE = "message"

        fun getInstance(message : String?) : ProfileFragment {
            return ProfileFragment().also {
                it.arguments = Bundle().apply {
                    putString(MESSAGE,message)
                }
            }
        }

    }
}

