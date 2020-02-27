package com.vasilevkin.catsanddogs.features.animalList.view.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.vasilevkin.catsanddogs.R
import com.vasilevkin.catsanddogs.delegateadapter.diff.DiffUtilCompositeAdapter
import com.vasilevkin.catsanddogs.delegateadapter.diff.IComparableItem
import com.vasilevkin.catsanddogs.features.animalList.IMainContract
import com.vasilevkin.catsanddogs.features.animalList.view.adapter.BigViewpagerDelegateAdapter
import com.vasilevkin.catsanddogs.features.animalList.view.adapter.LongHorizontalDelegateAdapter
import com.vasilevkin.catsanddogs.features.animalList.view.adapter.SquareDelegateAdapter
import com.vasilevkin.catsanddogs.models.localModels.SquareCatLocalModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity(), IMainContract.View {

    private var cats: List<IComparableItem> = emptyList()

    private val presenter: IMainContract.Presenter by inject { parametersOf(this) }
//    private var presenter: IMainContract.Presenter = MainPresenter(this)

    private val diffAdapter by lazy {
        DiffUtilCompositeAdapter.Builder()
            .add(LongHorizontalDelegateAdapter())
            .add(SquareDelegateAdapter())
            .add(BigViewpagerDelegateAdapter())
            .build()
    }

    private val SIZE = 20

// Lifecycle methods

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        setPresenter(
//            MainPresenter(
//                this
//                ,
//                DependencyInjector()
//            )
//        )
        presenter.onViewCreated()

        this.cats = prepareData()

        catList.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = diffAdapter
            generateNewData()
        }

        val manager = GridLayoutManager(this, 2)
        manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (position % 4) {
                    0 -> 2
                    1, 2 -> 1
                    else -> 2
                }
            }
        }
        catList.layoutManager = manager

    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

// IMainContract methods

//    override fun setPresenter(presenter: IMainContract.Presenter) {
//        this.presenter = presenter
//    }

    override fun displayAnimals(list: List<IComparableItem>) {
        this.cats = list

        Log.d("a1:7", "this.cats = ${this.cats}")

        diffAdapter.swapData(cats)
        catList.scrollToPosition(0)
    }

// Private methods

    private fun generateNewData() {
        diffAdapter.swapData(prepareData())
        catList.scrollToPosition(0)
    }

    private fun prepareData(): List<IComparableItem> {
        val objects = ArrayList<IComparableItem>(SIZE)
        val random = Random()
        for (i in 0 until SIZE) {
            val item: IComparableItem
            val type = random.nextInt(3)
//            if (type == 0) {

            item = SquareCatLocalModel(
//                item = LongHorizontalCatLocalModel(
                this,
                "Title $i",
                "Description $i",
                "1"
            )
//            } else if (type == 1) {
//                item = ImageViewModel("Title $i", R.mipmap.ic_launcher_round)
//            } else {
//                item = CheckViewModel("You still love this lib", true)
//            }
            objects.add(item)
        }
        return objects
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
