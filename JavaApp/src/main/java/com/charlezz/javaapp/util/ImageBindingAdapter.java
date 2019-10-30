package com.charlezz.javaapp.util;

import androidx.databinding.BindingAdapter;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class ImageBindingAdapter {


    @BindingAdapter("bind:image")
    public static void setImage(ImageView imageView, String path){
        if(!TextUtils.isEmpty(path)){
            Glide.with(imageView).load(path).transition(DrawableTransitionOptions.withCrossFade()).into(imageView);
        }
    }
}
