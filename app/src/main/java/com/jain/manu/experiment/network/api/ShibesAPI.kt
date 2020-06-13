package com.jain.manu.experiment.network.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ShibesAPI {

    @GET("api/shibes")
    fun retrieveUrl(
                @Query("count") count: Int,
                @Query("url") url: Boolean
    ) : Call<ArrayList<String>>
}