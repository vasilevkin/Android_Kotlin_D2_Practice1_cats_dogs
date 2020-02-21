package com.vasilevkin.catsanddogs.repository

import com.vasilevkin.catsanddogs.models.localModels.Animal
import com.vasilevkin.catsanddogs.utils.getDataServiceCommon
import io.reactivex.Single


class AnimalRepository(
//    private val cloudDataSource: ICloudDataSource
) : IAnimalRepository {


    override fun getAllAnimals(): Single<List<Animal>> {

        val catsApi = getDataServiceCommon()

        val response = catsApi.getBreedWithImages()
//        val response = catsApi.getAllBreeds()

        return response
            .map { catsFromNetwork ->
                catsFromNetwork.map {
                    Animal(
                        it.breeds?.get(0)?.name,
                        it.breeds?.get(0)?.origin,
                        it.imageUrl!!
                    )
                }
            }
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

