package com.vasilevkin.catsanddogs.features.animalList.view.adapter

import com.vasilevkin.catsanddogs.R
import com.vasilevkin.catsanddogs.delegateadapter.KDelegateAdapter
import com.vasilevkin.catsanddogs.models.localModels.BigViewpagerLocalModel
import com.vasilevkin.catsanddogs.utils.downloadImageInView
import kotlinx.android.synthetic.main.big_viewpager_item.*
import kotlinx.android.synthetic.main.big_viewpager_item.view.*

class BigViewpagerDelegateAdapter : KDelegateAdapter<BigViewpagerLocalModel>() {

    override fun onBind(item: BigViewpagerLocalModel, viewHolder: KDelegateAdapter.KViewHolder) =
        with(viewHolder) {
            title_text_view.text = item.title
            subtitle_text_view.text = item.subtitle
            downloadImageInView(item.context, itemView.details_image, item.imageUrl)
        }

    override fun isForViewType(items: List<*>, position: Int) =
        items[position] is BigViewpagerLocalModel

    override fun getLayoutId(): Int = R.layout.big_viewpager_item
}
