package com.vasilevkin.catsanddogs.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGetter {
//    https://dog.ceo/api/breeds/image/random/3

    private val okCLientInstance: OkHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(StethoInterceptor())
        .build()

    private val retrofitInstance: NetworkDataService = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okCLientInstance)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://dog.ceo/")
        .build()
        .create(NetworkDataService::class.java)

    fun getDataService(): NetworkDataService {
        return retrofitInstance
    }
}