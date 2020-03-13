package com.vasilevkin.catsanddogs.models.localModels

import android.content.Context
import com.vasilevkin.catsanddogs.delegateadapter.diff.IComparableItem
import com.vasilevkin.catsanddogs.features.animalList.IMainContract


class SquareCatLocalModel(
    val context: IMainContract.View?,
    val title: String,
    val subtitle: String,
    val imageUrl: String
) : IComparableItem {
    override fun id(): Any = title
    override fun content(): Any = title + subtitle + imageUrl
}
