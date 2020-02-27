package com.vasilevkin.catsanddogs.features.animalList.presenter

import android.app.Activity
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
//    , dependencyInjector: IDependencyInjector
) : IMainContract.Presenter {

//    private val animalRepository: IAnimalRepository = AnimalRepository()
//        dependencyInjector.animalRepository()

    private var view: IMainContract.View? = view

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
                    var item: IComparableItem? = null

                    when (i % 6) {
                        0 -> item = LongHorizontalCatLocalModel(
                            view as Activity,
                            cats[i].title ?: "Empty title",
                            cats[i].subtitle ?: "Empty subtitle",
                            cats[i].imageUrl ?: ""
                        )
                        1, 2 -> item = SquareCatLocalModel(
                            view as Activity,
                            cats[i].title ?: "Empty title",
                            cats[i].subtitle ?: "Empty subtitle",
                            cats[i].imageUrl ?: ""
                        )
                        5 -> item = BigViewpagerLocalModel(
                            view as Activity, arrayListOf(
                                Animal(
                                    cats[i - 2].title ?: "Empty title",
                                    cats[i - 2].subtitle ?: "Empty subtitle",
                                    cats[i - 2].imageUrl ?: ""
                                ), Animal(
                                    cats[i - 1].title ?: "Empty title",
                                    cats[i - 1].subtitle ?: "Empty subtitle",
                                    cats[i - 1].imageUrl ?: ""
                                ), Animal(
                                    cats[i].title ?: "Empty title",
                                    cats[i].subtitle ?: "Empty subtitle",
                                    cats[i].imageUrl ?: ""
                                )
                            )
                        )
                        else -> item = null
//                        else -> item = BigViewpagerLocalModel(
//                            view as Activity, arrayListOf(Animal(
//                            cats[i].title ?: "Empty title",
//                            cats[i].subtitle ?: "Empty subtitle",
//                            cats[i].imageUrl ?: ""
//                            ))
//                        )
                    }
                    if (item != null) {
                        objects.add(item)
                    }
                }

                view?.displayAnimals(objects)
            }
    }
}


//        val disposable = response
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(IoScheduler())
//            .subscribe { cats ->
//                //                this.cats = cats
//                //                catList.adapter = CatAdapter(cats, this)
//
//
//                val objects = ArrayList<IComparableItem>(20)
//                val random = Random()
//                for (i in 0 until cats.size) {
//                    val item: IComparableItem
//                    val type = random.nextInt(3)
//                    if (type == 0) {
////                    item = SquareCatLocalModel(
//                        item = LongHorizontalCatLocalModel(
//                            view as Activity,
//                            cats[i].breeds?.get(0)?.name!!,
//                            cats[i].breeds?.get(0)?.origin!!,
//                            cats[i].imageUrl!!
//                        )
//                    } else if (type == 1) {
//                        item = BigViewpagerLocalModel(
//                            view as Activity,
//                            cats[i].breeds?.get(0)?.name!!,
//                            cats[i].breeds?.get(0)?.origin!!,
//                            cats[i].imageUrl!!
//                        )
//
//                    } else {
//                        item = SquareCatLocalModel(
////                    item = LongHorizontalCatLocalModel(
//                            view as Activity,
//                            cats[i].breeds?.get(0)?.name!!,
//                            cats[i].breeds?.get(0)?.origin!!,
//                            cats[i].imageUrl!!
//                        )
//                    }
//                    objects.add(item)
//                }
////                return objects
//
//                view?.displayAnimals(objects)
//
//            }
