package com.vasilevkin.catsanddogs.features.animalList.presenter

import android.app.Activity
import com.vasilevkin.catsanddogs.base.BasePresenter
import com.vasilevkin.catsanddogs.delegateadapter.diff.IComparableItem
import com.vasilevkin.catsanddogs.features.animalList.IMainContract
import com.vasilevkin.catsanddogs.models.localModels.Animal
import com.vasilevkin.catsanddogs.models.localModels.BigViewpagerLocalModel
import com.vasilevkin.catsanddogs.models.localModels.LongHorizontalCatLocalModel
import com.vasilevkin.catsanddogs.models.localModels.SquareCatLocalModel
import com.vasilevkin.catsanddogs.repository.IAnimalRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.internal.schedulers.IoScheduler


class MainPresenter(
    view: IMainContract.View,
    private val animalRepository: IAnimalRepository
) : BasePresenter<IMainContract.View>(), IMainContract.Presenter {

    override var view: IMainContract.View? = view

    private var disposable: Disposable? = null

    // IMainContract methods

    override fun onViewCreated() {
        loadAnimals()
    }

    override fun onLoadMoreAnimalsTapped() {
        loadAnimals()
    }

    override fun onDestroy() {
        this.view = null
        this.disposable?.dispose()
    }

    // Private methods

    private fun loadAnimals() {
        val animals = animalRepository.getAllAnimals()

        this.disposable = animals
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(IoScheduler())
            .subscribe { cats ->
                val objects = ArrayList<IComparableItem>(20)
                for (i in cats.indices) {
                    var item: IComparableItem?

                    when (i % 6) {
                        0 -> item = LongHorizontalCatLocalModel(
                            view as Activity,
                            cats[i].title.orEmpty(),
                            cats[i].subtitle.orEmpty(),
                            cats[i].imageUrl.orEmpty()
                        )
                        1, 2 -> item = SquareCatLocalModel(
                            view as Activity,
                            cats[i].title.orEmpty(),
                            cats[i].subtitle.orEmpty(),
                            cats[i].imageUrl.orEmpty()
                        )
                        5 -> item = BigViewpagerLocalModel(
                            view as Activity, arrayListOf(
                                Animal(
                                    cats[i - 2].title.orEmpty(),
                                    cats[i - 2].subtitle.orEmpty(),
                                    cats[i - 2].imageUrl.orEmpty()
                                ), Animal(
                                    cats[i - 1].title.orEmpty(),
                                    cats[i - 1].subtitle.orEmpty(),
                                    cats[i - 1].imageUrl.orEmpty()
                                ), Animal(
                                    cats[i].title.orEmpty(),
                                    cats[i].subtitle.orEmpty(),
                                    cats[i].imageUrl.orEmpty()
                                )
                            )
                        )
                        else -> item = null
                    }
                    if (item != null) {
                        objects.add(item)
                    }
                }

                view?.displayAnimals(objects)
            }
    }
}
