package com.vasilevkin.catsanddogs.delegateadapter;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class BaseViewHolder extends RecyclerView.ViewHolder {
    private ItemInflateListener listener;

    public BaseViewHolder(View parent) {
        super(parent);
    }

    public final void setListener(ItemInflateListener listener) {
        this.listener = listener;
    }

    public final void bind(Object item) {
        listener.inflated(item, itemView);
    }

    interface ItemInflateListener {
        void inflated(Object viewType, View view);
    }
}
