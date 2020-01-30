package com.vasilevkin.catsanddogs.repository

import com.vasilevkin.catsanddogs.network.DogWebService
import com.vasilevkin.catsanddogs.models.Animal
import io.reactivex.Single

class AnimalRepository(
    private val dogWebService: DogWebService
) {

    fun getAllAnimals(): Single<List<Animal>> {
        return Single.just(arrayListOf(
            Animal(
                "test animal",
                "some desc"
            )
        ))
    }

    fun getAllDogs(): Single<List<Animal>> {
        return Single.just(arrayListOf(
            Animal(
                "test animal",
                "some desc"
            )
        ))
    }

    fun getAllCats(): Single<List<Animal>> {
        return Single.just(arrayListOf(
            Animal(
                "test animal",
                "some desc"
            )
        ))
    }

}