package com.vasilevkin.catsanddogs.delegateadapter.diff

import android.util.SparseArray
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.vasilevkin.catsanddogs.delegateadapter.CompositeDelegateAdapter
import com.vasilevkin.catsanddogs.delegateadapter.IDelegateAdapter


class DiffUtilCompositeAdapter private constructor(typeToAdapterMap: SparseArray<IDelegateAdapter<RecyclerView.ViewHolder, IComparableItem>>) :
    CompositeDelegateAdapter<IComparableItem>(typeToAdapterMap) {

    override fun swapData(data: MutableList<IComparableItem>) {
        val diffCallback = DiffUtilCallback(this.data, data)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.data.clear()
        this.data.addAll(data)
        diffResult.dispatchUpdatesTo(this)
    }

    class Builder {
        private var count = 0
        private val typeToAdapterMap: SparseArray<IDelegateAdapter<RecyclerView.ViewHolder, IComparableItem>> =
            SparseArray()

        fun add(
            delegateAdapter: IDelegateAdapter<RecyclerView.ViewHolder, IComparableItem>
        ): Builder {
            typeToAdapterMap.put(count++, delegateAdapter)
            return this
        }

        fun build(): DiffUtilCompositeAdapter {
            require(count != 0) { "Register at least one adapter" }
            return DiffUtilCompositeAdapter(typeToAdapterMap)
        }
    }
}