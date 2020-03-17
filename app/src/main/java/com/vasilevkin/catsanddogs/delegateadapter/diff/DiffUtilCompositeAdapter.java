package com.vasilevkin.catsanddogs.delegateadapter.diff;

import android.util.SparseArray;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.vasilevkin.catsanddogs.delegateadapter.CompositeDelegateAdapter;
import com.vasilevkin.catsanddogs.delegateadapter.IDelegateAdapter;

import java.util.List;

/**
 * @author dumchev on 16.11.17.
 */
public class DiffUtilCompositeAdapter extends CompositeDelegateAdapter<IComparableItem> {

    protected DiffUtilCompositeAdapter(@NonNull SparseArray<IDelegateAdapter<RecyclerView.ViewHolder, IComparableItem>> typeToAdapterMap) {
        super(typeToAdapterMap);
    }

    @Override
    public void swapData(@NonNull List<IComparableItem> data) {
        final DiffUtilCallback diffCallback = new DiffUtilCallback(this.data, data);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);
        this.data.clear();
        this.data.addAll(data);
        diffResult.dispatchUpdatesTo(this);
    }


    public static class Builder {

        private int count;
        private final SparseArray<IDelegateAdapter<RecyclerView.ViewHolder, IComparableItem>> typeToAdapterMap;

        public Builder() {
            typeToAdapterMap = new SparseArray<>();
        }

        public Builder add(
            @NonNull IDelegateAdapter<RecyclerView.ViewHolder, IComparableItem> delegateAdapter) {
            typeToAdapterMap.put(count++, delegateAdapter);
            return this;
        }

        public DiffUtilCompositeAdapter build() {
            if (count == 0) throw new IllegalArgumentException("Register at least one adapter");
            return new DiffUtilCompositeAdapter(typeToAdapterMap);
        }
    }
}
