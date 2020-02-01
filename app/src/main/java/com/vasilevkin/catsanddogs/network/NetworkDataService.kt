package com.vasilevkin.catsanddogs.network

import com.vasilevkin.catsanddogs.models.networkModels.AnimalsRemoteModel
import io.reactivex.Single
import retrofit2.http.GET

interface NetworkDataService {

    @GET("/api/breeds/image/random/3")
    fun getAnimals(): Single<List<AnimalsRemoteModel>>
}