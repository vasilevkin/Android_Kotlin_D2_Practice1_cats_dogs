package com.vasilevkin.catsanddogs.di

import com.vasilevkin.catsanddogs.features.animalList.IMainContract
import com.vasilevkin.catsanddogs.features.animalList.presenter.MainPresenter
import com.vasilevkin.catsanddogs.features.splash.ISplashContract
import com.vasilevkin.catsanddogs.features.splash.presenter.SplashPresenter
import com.vasilevkin.catsanddogs.repository.AnimalRepository
import com.vasilevkin.catsanddogs.repository.IAnimalRepository
import org.koin.dsl.module


val animalListModule = module {

    // single instance of IAnimalRepository
    single<IAnimalRepository> { AnimalRepository() }

    factory<IMainContract.Presenter> { (view: IMainContract.View) ->
        MainPresenter(view, get())
    }
}

val splashModule = module {

    factory<ISplashContract.Presenter> { SplashPresenter() }
}
