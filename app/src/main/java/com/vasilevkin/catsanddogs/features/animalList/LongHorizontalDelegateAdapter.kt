package com.vasilevkin.catsanddogs.features.animalList

import com.vasilevkin.catsanddogs.R
import com.vasilevkin.catsanddogs.delegateadapter.KDelegateAdapter
import com.vasilevkin.catsanddogs.utils.downloadImageInView
import com.vasilevkin.catsanddogs.models.localModels.LongHorizontalCatLocalModel
import kotlinx.android.synthetic.main.long_horizontal_item.*
import kotlinx.android.synthetic.main.long_horizontal_item.view.*

class LongHorizontalDelegateAdapter : KDelegateAdapter<LongHorizontalCatLocalModel>() {

    override fun onBind(item: LongHorizontalCatLocalModel, viewHolder: KViewHolder) =
        with(viewHolder) {
            title_text_view.text = item.title
            subtitle_text_view.text = item.subtitle
            downloadImageInView(item.context, itemView.details_image, item.imageUrl)
        }

    override fun isForViewType(items: List<*>, position: Int) =
        items[position] is LongHorizontalCatLocalModel

    override fun getLayoutId(): Int = R.layout.long_horizontal_item
}
