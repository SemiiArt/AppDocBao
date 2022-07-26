package com.tuyenhoang.appdocbao

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object CommonApp {
    @JvmStatic
    @BindingAdapter(value = arrayOf("loadImage"))
    fun loadImage(imageView: ImageView,linkImage:String?){
        if (linkImage==null){
            imageView.setBackgroundResource(R.drawable.img)
        }
        Glide.with(imageView.context)
            .load(linkImage)
            .error(R.drawable.img)
            .placeholder(R.drawable.img)
            .into(imageView)
    }
}