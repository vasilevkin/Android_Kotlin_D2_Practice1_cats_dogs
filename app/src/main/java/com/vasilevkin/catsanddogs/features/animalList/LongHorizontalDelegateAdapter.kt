package com.vasilevkin.catsanddogs.features.animalList

import com.vasilevkin.catsanddogs.R
import com.vasilevkin.catsanddogs.delegateadapter.KDelegateAdapter
import com.vasilevkin.catsanddogs.viewmodels.CatViewModel
import kotlinx.android.synthetic.main.long_horizontal_item.*

class LongHorizontalDelegateAdapter : KDelegateAdapter<CatViewModel>() {

    override fun onBind(item: CatViewModel, viewHolder: KViewHolder) =
        with(viewHolder) {
            title_text_view.text = item.title
            subtitle_text_view.text = item.subtitle
        }

    override fun isForViewType(items: List<Any>, position: Int) =
        items[position] is CatViewModel

    override fun getLayoutId(): Int = R.layout.long_horizontal_item
}
