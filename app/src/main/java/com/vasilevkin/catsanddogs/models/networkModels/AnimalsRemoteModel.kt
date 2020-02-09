package com.vasilevkin.catsanddogs.models.networkModels

import com.google.gson.annotations.SerializedName

// OLD, For dogs
data class AnimalsRemoteModel(
    @SerializedName("message") val photo: List<String>
)