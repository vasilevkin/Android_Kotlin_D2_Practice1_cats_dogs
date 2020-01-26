package com.vasilevkin.catsanddogs

import io.reactivex.Single

class AnimalRepository(
    private val webService: WebService
) {

    fun getAllAnimals(): Single<List<Animal>> {
        return Single.just(arrayListOf(Animal("test animal", "some desc")))
    }

    fun getAllDogs(): Single<List<Animal>> {
        return Single.just(arrayListOf(Animal("test animal", "some desc")))
    }

    fun getAllCats(): Single<List<Animal>> {
        return Single.just(arrayListOf(Animal("test animal", "some desc")))
    }

}