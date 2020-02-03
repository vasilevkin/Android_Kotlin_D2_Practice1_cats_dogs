package com.vasilevkin.catsanddogs.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.vasilevkin.catsanddogs.R
import com.vasilevkin.catsanddogs.features.animalList.CatsAndDogsAdapter
import com.vasilevkin.catsanddogs.models.localModels.Animal
import com.vasilevkin.catsanddogs.network.NetworkDataService
import com.vasilevkin.catsanddogs.network.ServiceGetter
import com.vasilevkin.catsanddogs.repository.AnimalRepository
import com.vasilevkin.catsanddogs.repository.dataSource.CloudDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: CatsAndDogsAdapter

    private lateinit var catsAndDogs: List<Animal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        catsAndDogs = ArrayList<Animal>()


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
        recyclerView = findViewById(R.id.cats_and_dogs_recyclerview)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter =
            CatsAndDogsAdapter(this, catsAndDogs)
        recyclerView.adapter = adapter

        val dividerItemDecoration = DividerItemDecoration(
            recyclerView.context,
            layoutManager.orientation
        )
        recyclerView.addItemDecoration(dividerItemDecoration)
    }

    override fun onResume() {
        super.onResume()

        val okCLientInstance1: OkHttpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .build()

        val retrofitInstance1: NetworkDataService = Retrofit.Builder()
//            .baseUrl("https://api.myjson.com/")
            .baseUrl("https://dog.ceo/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .client(okCLientInstance1)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetworkDataService::class.java)

        val catsAndDogs1 = retrofitInstance1.getAnimals1()
//        val catsAndDogs1 = retrofitInstance1.getAnimals1()

        Log.d("a1:7", "catsAndDogs1 = $catsAndDogs1")

        catsAndDogs1
            .subscribeOn(Schedulers.single())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t ->

                Log.d("a1:7", "ResponseBody = ${t.string()}")

//                catsAndDogs = t as ArrayList<Animal>
//            Log.d("a1:7", "ccatsAndDogs = $catsAndDogs")

            },
                { error -> Log.e("a1:7", "{$error.message}")}
            )

    }


}
