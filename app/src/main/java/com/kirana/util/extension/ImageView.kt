package com.kirana.util.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.kirana.R

internal fun ImageView.loadImage(url: String){
    Glide.with(this.context)
            .load(url)
            .asBitmap()
            .placeholder(R.drawable.shop_banner)
            .centerCrop()
            .into(this)
}