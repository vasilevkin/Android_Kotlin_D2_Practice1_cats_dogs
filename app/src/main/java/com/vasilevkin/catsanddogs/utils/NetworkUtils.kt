package com.vasilevkin.catsanddogs.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.vasilevkin.catsanddogs.R
import com.vasilevkin.catsanddogs.network.CatInterface
import com.vasilevkin.catsanddogs.network.ServiceGetter


fun getDataServiceCommon(): CatInterface = ServiceGetter.getDataService()

fun downloadImageInView(context: Context, view: ImageView, url: String) {
    Glide
        .with(context)
        .load(url)
        .placeholder(R.mipmap.ic_launcher)
        .error(R.mipmap.ic_launcher)
        .into(view)
}