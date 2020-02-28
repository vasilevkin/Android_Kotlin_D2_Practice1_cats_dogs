package com.vasilevkin.catsanddogs.features.animalList.view.ui

import android.os.Bundle
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


class MainActivity : AppCompatActivity(), IMainContract.View {

    private var cats: List<IComparableItem> = emptyList()
    private val presenter: IMainContract.Presenter by inject { parametersOf(this) }

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

    override fun displayAnimals(list: List<IComparableItem>) {
        this.cats = list

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
        for (i in 0 until SIZE) {
            val item = SquareCatLocalModel(
                this,
                "Title $i",
                "Description $i",
                "1"
            )
            objects.add(item)
        }
        return objects
    }
}
