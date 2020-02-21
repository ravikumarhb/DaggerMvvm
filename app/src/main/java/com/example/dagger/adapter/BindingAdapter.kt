package com.example.dagger.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("displayUrl")
fun setDisplayUrl(imageView: ImageView, url: String) {
    Glide.with(imageView.context).load(url).into(imageView)
}