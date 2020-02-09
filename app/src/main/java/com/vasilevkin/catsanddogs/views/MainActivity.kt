package com.vasilevkin.catsanddogs.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.vasilevkin.catsanddogs.R
import com.vasilevkin.catsanddogs.features.animalList.CatAdapter
import com.vasilevkin.catsanddogs.models.networkModels.CatRemoteModel
import com.vasilevkin.catsanddogs.utils.getDataServiceCommon
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var cats: List<CatRemoteModel> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        catList.layoutManager = LinearLayoutManager(this)

        val catsApi = getDataServiceCommon()
        val response = catsApi.getAllBreeds()

        response
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(IoScheduler())
            .subscribe({ cats ->
                this.cats = cats
                catList.adapter = CatAdapter(cats, this)
            })
    }
}


//        catsAndDogs = ArrayList<Animal>()


//        val downloads = AnimalRepository(CloudDataSource()).getAllAnimals()
//        downloads
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe { t ->
//
//                val dlString = t
//                Log.d("a1:7", "dlString = $dlString")
//
//            catsAndDogs = t as ArrayList<Animal>
//            Log.d("a1:7", "ccatsAndDogs = $catsAndDogs")
//        }

//        return list

//        catsAndDogs = arrayListOf(
//            Animal(
//                "hound",
//                "https://images.dog.ceo/breeds/terrier-wheaten/n02098105_1777.jpg"
//            ),
//            Animal(
//                "hound-afghan",
//                "https://images.dog.ceo/breeds/terrier-wheaten/n02098105_1777.jpg"
//            )
//        )

// set up the RecyclerView
//        recyclerView = findViewById(R.id.cats_and_dogs_recyclerview)
//        layoutManager = LinearLayoutManager(this)
//        recyclerView.layoutManager = layoutManager
//
//        adapter =
//            CatsAndDogsAdapter(this, catsAndDogs)
//        recyclerView.adapter = adapter
//
//        val dividerItemDecoration = DividerItemDecoration(
//            recyclerView.context,
//            layoutManager.orientation
//        )
//        recyclerView.addItemDecoration(dividerItemDecoration)
//    }

//    override fun onResume() {
//        super.onResume()
//
//        val okCLientInstance1: OkHttpClient = OkHttpClient.Builder()
//            .addNetworkInterceptor(StethoInterceptor())
//            .build()
//
//        val retrofitInstance1: NetworkDataService = Retrofit.Builder()
////            .baseUrl("https://api.myjson.com/")
//            .baseUrl("https://dog.ceo/")
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
////            .client(okCLientInstance1)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(NetworkDataService::class.java)
//
//        val catsAndDogs1 = retrofitInstance1.getAnimals1()
////        val catsAndDogs1 = retrofitInstance1.getAnimals1()
//
//        Log.d("a1:7", "catsAndDogs1 = $catsAndDogs1")
//
//        catsAndDogs1
//            .subscribeOn(Schedulers.single())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({ t ->
//
//                Log.d("a1:7", "ResponseBody = ${t.string()}")
//
////                catsAndDogs = t as ArrayList<Animal>
////            Log.d("a1:7", "ccatsAndDogs = $catsAndDogs")
//
//            },
//                { error -> Log.e("a1:7", "{$error.message}")}
//            )
//
//    }
//}
