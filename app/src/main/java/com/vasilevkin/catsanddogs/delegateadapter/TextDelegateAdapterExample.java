//package com.vasilevkin.catsanddogs.delegateadapter;
//
//import android.view.View;
//import android.widget.TextView;
//
//import com.vasilevkin.catsanddogs.R;
//
//import java.util.List;
//
//public class TextDelegateAdapter extends
//        BaseDelegateAdapter<TextDelegateAdapter.TextViewHolder, TextViewModel> {
//
//    @Override
//    protected void onBindViewHolder(@NonNull View view,
//                                    @NonNull TextViewModel item,
//                                    @NonNull TextViewHolder viewHolder) {
//        viewHolder.tvTitle.setText(item.title);
//        viewHolder.tvDescription.setText(item.description);
//    }
//
//    @Override
//    protected int getLayoutId() {
//        return R.layout.text_item;
//    }
//
//    @Override
//    protected TextViewHolder createViewHolder(View parent) {
//        return new TextViewHolder(parent);
//    }
//
//    @Override
//    public boolean isForViewType(@NonNull List<? extends Object> items, int position) {
//        return items.get(position) instanceof TextViewModel;
//    }
//
//    final static class TextViewHolder extends BaseViewHolder {
//
//        private TextView tvTitle;
//        private TextView tvDescription;
//
//        private TextViewHolder(View parent) {
//            super(parent);
//            tvTitle = parent.findViewById(R.id.tv_title);
//            tvDescription = parent.findViewById(R.id.tv_description);
//        }
//    }
//}
