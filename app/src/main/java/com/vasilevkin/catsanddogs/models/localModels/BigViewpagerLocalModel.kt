package com.vasilevkin.catsanddogs.models.localModels

import android.content.Context
import com.vasilevkin.catsanddogs.delegateadapter.diff.IComparableItem


class BigViewpagerLocalModel(
    val context: Context,
    val animals: ArrayList<Animal>
) : IComparableItem {
    override fun id(): Any = animals.first().title.toString()
    override fun content(): Any =
        animals.first().title.toString() + animals.first().subtitle.toString() + animals.first().imageUrl.toString()
}
