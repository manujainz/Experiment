package com.jain.manu.experiment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jain.manu.experiment.network.ServiceBuilder
import com.jain.manu.experiment.network.api.ShibesAPI
import com.jain.manu.experiment.utils.Logger
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragViewModel : ViewModel() {

    private val logger: Logger by lazy { Logger(isEnabled = true) }
    private val score = MutableLiveData<Int>()
    var dogLiveData = MutableLiveData<ArrayList<String>>()

    fun getScore() : LiveData<Int> {
        logger.d(TAG,"getScore")
        return score
    }

    fun updateScore() {
        score.value = score.value?.plus(1) ?: 1

        logger.d(TAG,"updateScore")
    }

    fun makeNetworkCall() {
        val request = ServiceBuilder.buildService((ShibesAPI::class.java))
        val call = request.retrieveUrl(10,true)
        call.enqueue(object : Callback<ArrayList<String>>{
            override fun onResponse(call: Call<ArrayList<String>>,
                                    response: Response<ArrayList<String>>) {
                dogLiveData.postValue(response.body())
                logger.d(TAG,response.message())
            }

            override fun onFailure(call: Call<ArrayList<String>>, t: Throwable) {
                logger.d(TAG,t.message.toString())
            }
        })
    }

    override fun onCleared() {
        super.onCleared()
        logger.d(TAG,"onCleared")
    }

    companion object{
        val TAG = FragViewModel::class.java.simpleName
    }
}