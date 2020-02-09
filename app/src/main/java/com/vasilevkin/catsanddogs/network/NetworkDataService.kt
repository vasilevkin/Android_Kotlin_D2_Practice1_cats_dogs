package com.vasilevkin.catsanddogs.network

import com.vasilevkin.catsanddogs.models.networkModels.CatRemoteModel
import io.reactivex.Single
import retrofit2.http.GET

interface CatInterface {
    //URL Parameter
    @GET("v1/breeds")
    fun getAllBreeds(): Single<List<CatRemoteModel>>
}


// OLD,  For dogs
//interface NetworkDataService {
//
//    @GET("api/breeds/image/random/3")
//    fun getAnimals(): Single<List<AnimalsRemoteModel>>
//
//
//    @GET("api/breeds/image/random/3")
//    fun getAnimals1(): Single<ResponseBody>
//
//}