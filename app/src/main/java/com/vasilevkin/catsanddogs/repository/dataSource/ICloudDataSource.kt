package com.vasilevkin.catsanddogs.repository.dataSource

import com.vasilevkin.catsanddogs.models.networkModels.AnimalsRemoteModel
import io.reactivex.Single


interface ICloudDataSource {
    fun getAnimals(): Single<List<AnimalsRemoteModel>>
}