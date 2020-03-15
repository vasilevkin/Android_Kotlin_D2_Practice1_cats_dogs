package com.vasilevkin.catsanddogs.delegateadapter

import android.util.SparseArray
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*


open class CompositeDelegateAdapter<T> constructor(val typeToAdapterMap: SparseArray<IDelegateAdapter<RecyclerView.ViewHolder?, T>>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    @JvmField
    protected val data: MutableList<T> = ArrayList()

    override fun getItemViewType(position: Int): Int {
        for (i in FIRST_VIEW_TYPE until typeToAdapterMap.size()) {
            val delegate = typeToAdapterMap.valueAt(i)
            if (delegate.isForViewType(data, position)) {
                return typeToAdapterMap.keyAt(i)
            }
        }
        throw NullPointerException("Can not get viewType for position $position")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return typeToAdapterMap[viewType].onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val delegateAdapter =
            typeToAdapterMap[getItemViewType(position)]
        if (delegateAdapter != null) {
            delegateAdapter.onBindViewHolder(holder, data, position)
        } else {
            throw NullPointerException("can not find adapter for position $position")
        }
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        typeToAdapterMap[holder.itemViewType].onRecycled(holder)
    }

    open fun swapData(data: MutableList<T>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return data.size
    }


    companion object {
        private val TAG = CompositeDelegateAdapter::class.java.simpleName
        private const val FIRST_VIEW_TYPE = 0
    }

}