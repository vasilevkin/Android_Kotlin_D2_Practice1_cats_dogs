package com.vasilevkin.catsanddogs.network

import com.vasilevkin.catsanddogs.models.networkModels.AnimalsRemoteModel
import io.reactivex.Single
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface NetworkDataService {

    @GET("api/breeds/image/random/3")
    fun getAnimals(): Single<List<AnimalsRemoteModel>>


    @GET("api/breeds/image/random/3")
    fun getAnimals1(): Single<ResponseBody>

}