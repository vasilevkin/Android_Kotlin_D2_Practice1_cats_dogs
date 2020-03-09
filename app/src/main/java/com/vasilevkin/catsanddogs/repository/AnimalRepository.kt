package com.vasilevkin.catsanddogs.repository

import com.vasilevkin.catsanddogs.models.localModels.Animal
import com.vasilevkin.catsanddogs.models.networkModels.CatImageRemoteModel
import com.vasilevkin.catsanddogs.utils.getDataServiceCommon
import io.reactivex.Single


class AnimalRepository : IAnimalRepository {

    override fun getAllAnimals(): Single<List<Animal>> {
        val catsApi = getDataServiceCommon()
        val response = catsApi.getAllBreeds()

        return response
            .map { list ->
                val arr = ArrayList<CatImageRemoteModel>(5)
                for (cat in list.indices) {
                    catsApi.getImageForBreedId(1, list[cat].breedId ?: "")
                        .subscribe { singleCatlist ->
                            arr.add(singleCatlist.first())
                        }
                }
                return@map arr
            }
            .map { catsFromNetwork ->
                catsFromNetwork.map {
                    Animal(
                        it.breeds?.get(0)?.name,
                        it.breeds?.get(0)?.origin,
                        it.imageUrl ?: ""
                    )
                }
            }
    }
}
