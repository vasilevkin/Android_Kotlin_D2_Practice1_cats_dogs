package com.vasilevkin.catsanddogs.repository.dataSource

import com.vasilevkin.catsanddogs.models.networkModels.AnimalsRemoteModel
import com.vasilevkin.catsanddogs.utils.getDataServiceCommon
import io.reactivex.Single


class CloudDataSource : ICloudDataSource {

    override fun getAnimals(): Single<List<AnimalsRemoteModel>> {
        return getDataServiceCommon().getAnimals()
    }
}