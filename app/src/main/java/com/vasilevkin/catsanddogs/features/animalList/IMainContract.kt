package com.vasilevkin.catsanddogs.features.animalList

import com.vasilevkin.catsanddogs.delegateadapter.diff.IComparableItem


interface IMainContract {

    interface Presenter {
        fun onViewCreated()
        fun onLoadMoreAnimalsTapped()
        fun onDestroy()
    }

    interface View {
        fun displayAnimals(list: List<IComparableItem>)
    }
}