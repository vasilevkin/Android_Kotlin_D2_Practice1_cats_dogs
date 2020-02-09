package com.vasilevkin.catsanddogs.network

import com.vasilevkin.catsanddogs.models.networkModels.CatImageRemoteModel
import com.vasilevkin.catsanddogs.models.networkModels.CatRemoteModel
import io.reactivex.Single
import retrofit2.http.GET


interface CatInterface {
    // https://api.thecatapi.com/

    //URL Parameter
    @GET("v1/breeds")
    fun getAllBreeds(): Single<List<CatRemoteModel>>


    @GET("v1/images/search?limit=30&breed_id=abys")
    fun getBreedWithImages(): Single<List<CatImageRemoteModel>>
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