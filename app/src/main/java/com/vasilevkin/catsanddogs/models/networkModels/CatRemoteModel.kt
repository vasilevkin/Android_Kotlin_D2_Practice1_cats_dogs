package com.vasilevkin.catsanddogs.models.networkModels

import com.google.gson.annotations.SerializedName


data class CatRemoteModel(
    @SerializedName("name") val name: String,
    @SerializedName("origin") val origin: String,
    @SerializedName("url") val imageUrl: String
)


data class CatImageRemoteModel(
    @SerializedName("breeds") val breeds: List<Breeds>,
    @SerializedName("url") val imageUrl: String
)

data class Breeds(
    @SerializedName("name") val name: String,
    @SerializedName("origin") val origin: String
)
