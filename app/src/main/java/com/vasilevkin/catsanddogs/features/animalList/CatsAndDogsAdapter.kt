package com.vasilevkin.catsanddogs.features.animalList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vasilevkin.catsanddogs.R
import com.vasilevkin.catsanddogs.models.Animal
import com.vasilevkin.catsanddogs.utils.downloadImageInView


class CatsAndDogsAdapter
internal constructor(context: Context, private val catsAndDogsDataset: List<Animal>) :
    RecyclerView.Adapter<CatsAndDogsAdapter.CatsAndDogsViewHolder>() {

    private val inflater: LayoutInflater
    private val con = context

    init {
        this.inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsAndDogsViewHolder {
        val view = inflater.inflate(R.layout.long_horizontal_item, parent, false)
        return CatsAndDogsViewHolder(view)
    }

    // binds the data to the TextView in each row
    override fun onBindViewHolder(holder: CatsAndDogsViewHolder, position: Int) {
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

    inner class CatsAndDogsViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var titleTextView: TextView
//        internal var descriptionTextView: TextView
        internal var detailsImage: ImageView

        init {
            titleTextView = itemView.findViewById(R.id.title_text_view)
//            descriptionTextView = itemView.findViewById(R.id.description_text_view)
            detailsImage = itemView.findViewById(R.id.details_image)
        }
    }

}