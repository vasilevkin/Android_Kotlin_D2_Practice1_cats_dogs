package com.vasilevkin.catsanddogs.repository

import com.vasilevkin.catsanddogs.models.localModels.Animal
import io.reactivex.Single


interface IAnimalRepository {
    fun getAllAnimals(): Single<List<Animal>>
}