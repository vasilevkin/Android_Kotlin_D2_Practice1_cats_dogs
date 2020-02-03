package com.vasilevkin.catsanddogs.features.animalList

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vasilevkin.catsanddogs.R
import com.vasilevkin.catsanddogs.models.localModels.Animal
import com.vasilevkin.catsanddogs.utils.downloadImageInView


class CatsAndDogsAdapter
internal constructor(context: Context, private val catsAndDogsDataset: List<Animal>) :
    RecyclerView.Adapter<CatsAndDogsHolder>() {

    private val inflater: LayoutInflater
    private val con = context

    init {
        this.inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsAndDogsHolder {
        val view = inflater.inflate(R.layout.long_horizontal_item, parent, false)
        return CatsAndDogsHolder(view)
    }

    // binds the data to the TextView in each row
    override fun onBindViewHolder(holder: CatsAndDogsHolder, position: Int) {
        val title = catsAndDogsDataset[position].title
//        val description = catsAndDogsDataset[position].description
        val imageUrl = catsAndDogsDataset[position].imageUrl

        holder.titleTextView.text = title
//        holder.descriptionTextView.text = description

        downloadImageInView(con, holder.detailsImage, "https://images.dog.ceo/breeds/terrier-wheaten/n02098105_1777.jpg")
//        Glide.with(con).load("https://images.dog.ceo/breeds/terrier-wheaten/n02098105_1777.jpg").into(holder.detailsImage)

//        Picasso.get().load("https://images.dog.ceo/breeds/terrier-wheaten/n02098105_1777.jpg").into(holder.detailsImage)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = catsAndDogsDataset.size


}