package com.vasilevkin.catsanddogs.features.animalList

interface IMainContract {

    interface Presenter : IBasePresenter {
        fun onViewCreated()
        fun onLoadMoreAnimalsTapped()
    }

    interface View : IBaseView<Presenter> {
        fun displayMoreAnimals()
    }
}