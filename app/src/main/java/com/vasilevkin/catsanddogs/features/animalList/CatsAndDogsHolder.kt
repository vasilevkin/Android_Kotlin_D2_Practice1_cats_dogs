package com.vasilevkin.catsanddogs.features.animalList

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vasilevkin.catsanddogs.R


class CatsAndDogsHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    internal var titleTextView: TextView
    //        internal var descriptionTextView: TextView
    internal var detailsImage: ImageView

    init {
        titleTextView = itemView.findViewById(R.id.title_text_view)
//            descriptionTextView = itemView.findViewById(R.id.description_text_view)
        detailsImage = itemView.findViewById(R.id.details_image)
    }
}
