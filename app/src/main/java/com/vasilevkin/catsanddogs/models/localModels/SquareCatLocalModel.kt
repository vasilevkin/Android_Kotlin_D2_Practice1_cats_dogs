package com.vasilevkin.catsanddogs.models.localModels

import android.content.Context
import com.vasilevkin.catsanddogs.delegateadapter.diff.IComparableItem

class SquareCatLocalModel(
    val context: Context,
    val title: String,
    val subtitle: String,
    val imageUrl: String
) : IComparableItem {
    override fun id(): Any = title
    override fun content(): Any = title + subtitle + imageUrl
}
