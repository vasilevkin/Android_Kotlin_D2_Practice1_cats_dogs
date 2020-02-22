package com.vasilevkin.catsanddogs.repository

import com.vasilevkin.catsanddogs.models.localModels.Animal
import com.vasilevkin.catsanddogs.models.networkModels.CatImageRemoteModel
import com.vasilevkin.catsanddogs.utils.getDataServiceCommon
import io.reactivex.Single


class AnimalRepository(
//    private val cloudDataSource: ICloudDataSource
) : IAnimalRepository {


    override fun getAllAnimals(): Single<List<Animal>> {

        val catsApi = getDataServiceCommon()

//        val response = catsApi.getBreedWithImages()
//        val response = catsApi.getAllBreeds()

        val response2 = catsApi.getAllBreeds()


        return response2
            .map { list ->

                var arr = ArrayList<CatImageRemoteModel>(5)
                for (cat in list.indices) {
                    catsApi.getImageForBreedId(1, list[cat].breedId ?: "")
                        .subscribe { singleCatlist ->
                            arr.add(singleCatlist[0])
                        }
                }

                return@map arr
            }
            .map { catsFromNetwork ->
                catsFromNetwork.map {
                    Animal(
                        it.breeds?.get(0)?.name,
                        it.breeds?.get(0)?.origin,
                        it.imageUrl ?: ""
                    )
                }
            }


//        var finalArray = ArrayList<CatImageRemoteModel>(5)
//        resp2
////            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(IoScheduler())
//            .subscribe({ list ->
//
////                Log.d("e322", "list = $list")
//
//    var arr = ArrayList<CatImageRemoteModel>(5)
//                for (cat in list.indices) {
//                    catsApi.getImageForBreedId(1, list[cat].breedId?: "")
//                        .subscribe({ list ->
//                                arr.add(list[0])
//
//                        })
//
//                }
//
//                                Log.d("e322", "arr = $arr")
//
//                finalArray = arr
//            })


//        resp2
//            .flatMap { firstResp ->
//                firstResp.flatMap { elem ->
//                    catsApi.getImageForBreedId(1, elem.breedId)
//
//                }
//
////            return@flatMap Single
//        }


//        val resp3 = catsApi.getImageForBreedId(1,"abys")
//
//        resp3
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(IoScheduler())
//            .subscribe({ list ->
//
//                Log.d("e3221", "list2 = $list")
//
//
//                for (cat in list.indices) {
//
//                }
//            })

//        return response
//            .map { catsFromNetwork ->
//                catsFromNetwork.map {
//                    Animal(
//                        it.breeds?.get(0)?.name,
//                        it.breeds?.get(0)?.origin,
//                        it.imageUrl!!
//                    )
//                }
//            }
    }
}


//            .subscribe { catsFromNetwork ->
//                this.cats = cats
//                catList.adapter = CatAdapter(cats, this)


//                val objects = ArrayList<Animal>(20)
////                val random = Random()
//                for (i in 0 until catsFromNetwork.size) {
//                    val item: Animal
//
//                    item = Animal(
//                        catsFromNetwork[i].breeds?.get(0)?.name!!,
//                        catsFromNetwork[i].breeds?.get(0)?.origin!!,
//                        catsFromNetwork[i].imageUrl!!
//                    )
//
//                    objects.add(item)
//
////                    val type = random.nextInt(3)
////                    if (type == 0) {
//////                    item = SquareCatLocalModel(
////                        item = LongHorizontalCatLocalModel(
////                            view as Activity,
////                            cats[i].breeds?.get(0)?.name!!,
////                            cats[i].breeds?.get(0)?.origin!!,
////                            cats[i].imageUrl!!
////                        )
////                    } else if (type == 1) {
////                        item = BigViewpagerLocalModel(
////                            view as Activity,
////                            cats[i].breeds?.get(0)?.name!!,
////                            cats[i].breeds?.get(0)?.origin!!,
////                            cats[i].imageUrl!!
////                        )
////
////                    } else {
////                        item = SquareCatLocalModel(
//////                    item = LongHorizontalCatLocalModel(
////                            view as Activity,
////                            cats[i].breeds?.get(0)?.name!!,
////                            cats[i].breeds?.get(0)?.origin!!,
////                            cats[i].imageUrl!!
////                        )
////                    }
////                    objects.add(item)
//                }
////                return objects
//
////                view?.displayAnimals(objects)
//
//
////                animals =  Single.just(objects)
//
//            }
//
//
//
//return animals
//
////        return Single.just(listOf(Animal()))
////        return cloudDataSource.getAnimals().map {
////                it.map {
////                    Animal(it.photo?.get(0)?.orEmpty())
////                }
////            }
//
//
//
//
//
//
//    }
//
//
//}


//    override fun getAllAnimals(): Single<List<Animal>> {
//        return Single.just(listOf(Animal()))
////        return cloudDataSource.getAnimals().map {
////                it.map {
////                    Animal(it.photo?.get(0)?.orEmpty())
////                }
////            }
//        }

//    fun getAllAnimals(): Single<List<Animal>> {
//        return Single.just(arrayListOf(
//            Animal(
//                "test animal",
//                "some desc"
//            )
//        ))
//    }

//    fun getAllDogs(): Single<List<Animal>> {
//        return Single.just(arrayListOf(
//            Animal(
//                "test animal",
//                "some desc"
//            )
//        ))
//    }
//
//    fun getAllCats(): Single<List<Animal>> {
//        return Single.just(arrayListOf(
//            Animal(
//                "test animal",
//                "some desc"
//            )
//        ))
//    }

