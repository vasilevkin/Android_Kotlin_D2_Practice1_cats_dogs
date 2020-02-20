package com.vasilevkin.catsanddogs

import com.vasilevkin.catsanddogs.repository.AnimalRepository
import com.vasilevkin.catsanddogs.repository.IAnimalRepository

class DependencyInjector : IDependencyInjector {
    override fun animalRepository(): IAnimalRepository {
        return AnimalRepository()
    }
}