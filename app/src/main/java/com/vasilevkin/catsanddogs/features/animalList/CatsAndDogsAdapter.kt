package com.vasilevkin.catsanddogs.features.animalList

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vasilevkin.catsanddogs.R
import com.vasilevkin.catsanddogs.models.networkModels.CatImageRemoteModel
import com.vasilevkin.catsanddogs.utils.downloadImageInView
import kotlinx.android.synthetic.main.long_horizontal_item.view.*


class CatAdapter(private val breedList: List<CatImageRemoteModel>, private val context: Context) :
    RecyclerView.Adapter<ViewHolder>() {

    private val HORIZONTAL_ITEM = 0
    private val SQUARE_ITEM = 1

    override fun getItemViewType(position: Int): Int {
        return if (position % 3 == 0) {
            HORIZONTAL_ITEM
        } else {
            SQUARE_ITEM
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        if (viewType == HORIZONTAL_ITEM) {
            return ViewHolder(
            inflater.inflate(
//                R.layout.square_item,
                R.layout.long_horizontal_item,
                parent,
                false
            )
        )
        } else {
            return ViewHolder(
                inflater.inflate(
                R.layout.square_item,
//                    R.layout.long_horizontal_item,
                    parent,
                    false
                )
            )
        }
    }
//    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
//        return ViewHolder(
//            LayoutInflater.from(context).inflate(
//                R.layout.square_item,
////                R.layout.long_horizontal_item,
//                p0,
//                false
//            )
//        )
//    }


//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        when (holder) {
//            is HorizontalViewHolder -> {
//                vh = holder
//                val model = getItems()[position] as SampleModel
//                (vh as MyViewHolder).title.text = model.getId().toString()
//            }
//            else -> {
//                vh = holder
//                val model = getItems()[position] as EmptySampleModel
//                (vh as EmptyMyViewHolder).titleEmpty.text = model.getText()
//            }
//        }
//    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.title_text_view.text = breedList[position].breeds?.get(0)?.name ?: ""

//        holder.itemView.title_text_view.text = breedList.get(position).name

//        holder.itemView.subtitle_text_view.text = breedList.get(position).imageUrl
        holder.itemView.subtitle_text_view.text = breedList[position].breeds?.get(0)?.origin ?: ""

    breedList[position].imageUrl?.let {
        downloadImageInView(context, holder.itemView.details_image, it)
    }

    }

    override fun getItemCount() = breedList.size
}


//class CatsAndDogsAdapter
//internal constructor(context: Context, private val catsAndDogsDataset: List<Animal>) :
//    RecyclerView.Adapter<CatsAndDogsHolder>() {
//
//    private val inflater: LayoutInflater
//    private val con = context
//
//    init {
//        this.inflater = LayoutInflater.from(context)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsAndDogsHolder {
//        val view = inflater.inflate(R.layout.long_horizontal_item, parent, false)
//        return CatsAndDogsHolder(view)
//    }
//
//    // binds the data to the TextView in each row
//    override fun onBindViewHolder(holder: CatsAndDogsHolder, position: Int) {
//        val title = catsAndDogsDataset[position].title
////        val description = catsAndDogsDataset[position].description
////        val imageUrl = catsAndDogsDataset[position].imageUrl
//
//        holder.titleTextView.text = title
////        holder.descriptionTextView.text = description
//
//        downloadImageInView(con, holder.detailsImage, "https://images.dog.ceo/breeds/terrier-wheaten/n02098105_1777.jpg")
////        Glide.with(con).load("https://images.dog.ceo/breeds/terrier-wheaten/n02098105_1777.jpg").into(holder.detailsImage)
//
////        Picasso.get().load("https://images.dog.ceo/breeds/terrier-wheaten/n02098105_1777.jpg").into(holder.detailsImage)
//    }
//
//    // Return the size of your dataset (invoked by the layout manager)
//    override fun getItemCount() = catsAndDogsDataset.size
//
//
//}



