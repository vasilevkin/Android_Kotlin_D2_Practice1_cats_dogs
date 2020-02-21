package com.vasilevkin.catsanddogs.features.animalList

import com.vasilevkin.catsanddogs.delegateadapter.diff.IComparableItem

interface IMainContract {

    interface Presenter : IBasePresenter {
        fun onViewCreated()
        fun onLoadMoreAnimalsTapped()
    }

    interface View : IBaseView<Presenter> {
        fun displayAnimals(list: List<IComparableItem>)
//        fun displayAnimals(list: Single<List<Animal>>)
    }
}