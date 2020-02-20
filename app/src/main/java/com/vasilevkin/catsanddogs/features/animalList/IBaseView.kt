package com.vasilevkin.catsanddogs.features.animalList

interface IBaseView<T> {
    fun setPresenter(presenter: T)
}