package com.vasilevkin.catsanddogs.models.localModels

import android.content.Context
import com.vasilevkin.catsanddogs.delegateadapter.diff.IComparableItem


class BigViewpagerLocalModel(
    val context: Context,
    val animals: ArrayList<Animal>
) : IComparableItem {
    override fun id(): Any = animals[0].title.toString()
    override fun content(): Any =
        animals[0].title.toString() + animals[0].subtitle.toString() + animals[0].imageUrl.toString()
}
