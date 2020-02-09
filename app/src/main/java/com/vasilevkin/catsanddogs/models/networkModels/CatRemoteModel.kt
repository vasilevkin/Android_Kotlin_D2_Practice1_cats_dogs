package com.vasilevkin.catsanddogs.models.networkModels

import com.google.gson.annotations.SerializedName


data class CatRemoteModel(
    @SerializedName("name") val name: String,
    @SerializedName("origin") val origin: String
)