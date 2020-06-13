package com.jain.manu.experiment.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.jain.manu.experiment.R
import com.jain.manu.experiment.utils.Logger
import com.jain.manu.experiment.viewmodel.FragViewModel
import kotlinx.android.synthetic.main.fragment_music_player.*

class MusicFragment private constructor() : Fragment() {

    private val logger : Logger by lazy { Logger(true) }
    private lateinit var mContext : Context
    private lateinit var viewModel: FragViewModel


    override fun onAttach(context: Context) {
        super.onAttach(context)

        mContext = context
        logger.d(TAG,"onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logger.d(TAG,"onCreate")

        // register viewmodel
        viewModel = ViewModelProviders
                    .of(requireActivity())
                    .get(FragViewModel::class.java)

        // network call
        viewModel.makeNetworkCall()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        logger.d(TAG,"onCreateView")
        return inflater.inflate(R.layout.fragment_music_player,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logger.d(TAG,"onViewCreated")

        // observe live data
        viewModel.dogLiveData
            .observe(this, Observer { api_text.text = it[0]})
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        logger.d(TAG,"onActivityCreated")
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
        val TAG = MusicFragment::class.java.simpleName
        val MESSAGE = "message"

        fun getInstance(message : String?) : MusicFragment {
            return MusicFragment().also {
                it.arguments = Bundle().apply {
                    putString(MESSAGE,message)
                }
            }
        }

    }
}

