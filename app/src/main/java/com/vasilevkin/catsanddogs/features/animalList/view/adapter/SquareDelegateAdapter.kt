package com.vasilevkin.catsanddogs.features.animalList.view.adapter

import com.vasilevkin.catsanddogs.R
import com.vasilevkin.catsanddogs.delegateadapter.KDelegateAdapter
import com.vasilevkin.catsanddogs.models.localModels.SquareCatLocalModel
import com.vasilevkin.catsanddogs.utils.downloadImageInView
import kotlinx.android.synthetic.main.square_item.*
import kotlinx.android.synthetic.main.square_item.view.*


class SquareDelegateAdapter : KDelegateAdapter<SquareCatLocalModel>() {

    override fun onBind(item: SquareCatLocalModel, viewHolder: KViewHolder) =
        with(viewHolder) {
            title_text_view.text = item.title
            subtitle_text_view.text = item.subtitle
            downloadImageInView(item.context, itemView.details_image, item.imageUrl)
        }

    override fun isForViewType(items: List<*>, position: Int) =
        items[position] is SquareCatLocalModel

    override fun getLayoutId(): Int = R.layout.square_item
}
