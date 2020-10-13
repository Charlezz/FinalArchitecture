package com.charlezz.htmltextview

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.DrawableContainer
import android.text.Html
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

class HttpImageGetter constructor(
        val context: Context,
        val width: Int = context.resources.displayMetrics.widthPixels,
        @DrawableRes val placeholder: Int? = null,
        @DrawableRes val fallback: Int? = null,
        val listener: Listener

) : Html.ImageGetter {

    override fun getDrawable(source: String): Drawable {
        var lazyDrawable = LazyDrawable().apply {
            if (this@HttpImageGetter.placeholder != null) {
                placeholder = ContextCompat.getDrawable(context, this@HttpImageGetter.placeholder)
            }
            if (this@HttpImageGetter.fallback != null) {
                fallback = ContextCompat.getDrawable(context, this@HttpImageGetter.fallback)
            }

        }

        var requestBuilder = Glide.with(context).load(source)

        if (fallback != null) {
            requestBuilder = requestBuilder.fallback(fallback)
        }
        requestBuilder.into(object : CustomTarget<Drawable>(width, 1) {
            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                lazyDrawable.drawable = resource
                setDrawableBounds(lazyDrawable,resource)
                listener.onDrawableChanged()

            }

            override fun onLoadCleared(placeholder: Drawable?) {
                placeholder?.let {
                    lazyDrawable.placeholder = it
                    setDrawableBounds(lazyDrawable,it)
                    listener.onDrawableChanged()
                }

            }

            override fun onLoadFailed(errorDrawable: Drawable?) {
                super.onLoadFailed(errorDrawable)
                errorDrawable?.let {
                    lazyDrawable.fallback = it
                    setDrawableBounds(lazyDrawable,it)
                    listener.onDrawableChanged()
                }
            }
        })

        return lazyDrawable
    }

    private fun setDrawableBounds(lazyDrawable:LazyDrawable,drawable:Drawable?){
        drawable?.let {
            drawable.setBounds(0,0, drawable.intrinsicWidth, drawable.intrinsicHeight )
            lazyDrawable.setBounds(0,0, drawable.intrinsicWidth, drawable.intrinsicHeight)
        }
    }

    inner class LazyDrawable : BitmapDrawable() {
        var drawable: Drawable? = null
        var fallback: Drawable? = null
        var placeholder: Drawable? = null
        override fun draw(canvas: Canvas) {
            when {
                drawable != null -> {
                    drawable?.draw(canvas)
                }
                fallback != null -> {
                    fallback?.draw(canvas)
                }
                placeholder != null -> {
                    placeholder?.draw(canvas)
                }
            }
        }
    }

    interface Listener {
        fun onDrawableChanged()
    }
}