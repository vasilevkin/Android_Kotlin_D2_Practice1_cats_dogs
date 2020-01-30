package com.vasilevkin.catsanddogs.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vasilevkin.catsanddogs.R
import com.vasilevkin.catsanddogs.features.animalList.CatsAndDogsAdapter
import com.vasilevkin.catsanddogs.models.Animal

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: CatsAndDogsAdapter

    private lateinit var catsAndDogs: List<Animal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        catsAndDogs = arrayListOf(
            Animal(
                "hound",
                "https://images.dog.ceo/breeds/terrier-wheaten/n02098105_1777.jpg"
            ),
            Animal(
                "hound-afghan",
                "https://images.dog.ceo/breeds/terrier-wheaten/n02098105_1777.jpg"
            )
        )

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
}
