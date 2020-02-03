package com.vasilevkin.catsanddogs.models.networkModels

import com.google.gson.annotations.SerializedName


data class AnimalsRemoteModel(
    @SerializedName("message") val photo: List<String>
)