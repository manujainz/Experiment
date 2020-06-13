package com.jain.manu.experiment.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {

    private val client = OkHttpClient.Builder()

    private val builder = Retrofit.Builder()
        .baseUrl("http://shibe.online/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client.build())

    private val retrofit = builder.build()

    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }

}