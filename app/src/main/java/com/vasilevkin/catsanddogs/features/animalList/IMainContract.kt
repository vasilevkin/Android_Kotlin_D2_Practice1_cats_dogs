package com.vasilevkin.catsanddogs.features.animalList

import com.vasilevkin.catsanddogs.base.BaseContract
import com.vasilevkin.catsanddogs.delegateadapter.diff.IComparableItem


interface IMainContract {

    interface Presenter : BaseContract.Presenter {
        fun onLoadMoreAnimalsTapped()
        fun onDestroy()
    }

    interface View : BaseContract.View {
        fun displayAnimals(list: MutableList<IComparableItem>)
    }
}