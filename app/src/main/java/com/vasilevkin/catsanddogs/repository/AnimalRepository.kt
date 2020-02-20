package com.vasilevkin.catsanddogs.repository

import com.vasilevkin.catsanddogs.models.localModels.Animal
import com.vasilevkin.catsanddogs.repository.dataSource.ICloudDataSource
import io.reactivex.Single


class AnimalRepository(
//    private val cloudDataSource: ICloudDataSource
) : IAnimalRepository {

    override fun getAllAnimals(): Single<List<Animal>> {
        return Single.just(listOf(Animal()))
//        return cloudDataSource.getAnimals().map {
//                it.map {
//                    Animal(it.photo?.get(0)?.orEmpty())
//                }
//            }
        }


//    fun getAllAnimals(): Single<List<Animal>> {
//        return Single.just(arrayListOf(
//            Animal(
//                "test animal",
//                "some desc"
//            )
//        ))
//    }

//    fun getAllDogs(): Single<List<Animal>> {
//        return Single.just(arrayListOf(
//            Animal(
//                "test animal",
//                "some desc"
//            )
//        ))
//    }
//
//    fun getAllCats(): Single<List<Animal>> {
//        return Single.just(arrayListOf(
//            Animal(
//                "test animal",
//                "some desc"
//            )
//        ))
//    }

}