package com.vasilevkin.catsanddogs.network

import retrofit2.Call
import retrofit2.http.GET

interface DogWebService {
    /**
     * @GET declares an HTTP GET request
     * @Path("user") annotation on the userId parameter marks it as a
     * replacement for the {user} placeholder in the @GET path
     */
    @GET("/api/breeds/list/all")
    fun getAllBreeds(): Call<List<Dog>>

//    @GET("/api/breeds/image/random")
//    fun getRandomImage(@Path("user") userId: String): Call<User>
//
//    @GET("/api/breed/{breed}/images")
//    fun getImagesByBreed(@Path("breed") breed: String): Call<User>


}