package com.vasilevkin.catsanddogs.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGetter {
//    https://dog.ceo/api/breeds/image/random/3

    private val interceptor = run {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private val okCLientInstance: OkHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(StethoInterceptor())
        .addNetworkInterceptor(interceptor)
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