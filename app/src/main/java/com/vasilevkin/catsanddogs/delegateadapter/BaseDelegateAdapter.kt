package com.vasilevkin.catsanddogs.delegateadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView


abstract class BaseDelegateAdapter<VH : BaseViewHolder?, T> : IDelegateAdapter<VH, T> {

    protected abstract fun onBindViewHolder(view: View, item: T, viewHolder: VH)

    @get:LayoutRes
    protected abstract val layoutId: Int

    /**
     * @param parent inflated view
     */
    protected abstract fun createViewHolder(parent: View): VH

    override fun onRecycled(holder: VH) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context)
            .inflate(layoutId, parent, false)
        val holder = createViewHolder(inflatedView)
        holder!!.setListener { viewType, view -> onBindViewHolder(view, viewType as T, holder) }
        return holder
    }

    override fun onBindViewHolder(holder: VH, items: List<T>, position: Int) {
        (holder as BaseViewHolder).bind(items[position])
    }
}