package com.vasilevkin.catsanddogs.features.animalList.view.adapter

import com.vasilevkin.catsanddogs.R
import com.vasilevkin.catsanddogs.delegateadapter.KDelegateAdapter
import com.vasilevkin.catsanddogs.features.animalList.view.viewpager.AnimalsPagerAdapter
import com.vasilevkin.catsanddogs.models.localModels.BigViewpagerLocalModel
import kotlinx.android.synthetic.main.big_viewpager_item.*


class BigViewpagerDelegateAdapter : KDelegateAdapter<BigViewpagerLocalModel>() {

    private lateinit var pagerAdapter: AnimalsPagerAdapter

    override fun onBind(item: BigViewpagerLocalModel, viewHolder: KViewHolder) {

        with(viewHolder) {
            pagerAdapter = AnimalsPagerAdapter(item.context, item.animals)
            animal_view_pager.adapter = pagerAdapter
        }
    }

    override fun isForViewType(items: List<*>, position: Int) =
        items[position] is BigViewpagerLocalModel

    override fun getLayoutId(): Int = R.layout.big_viewpager_item
}
