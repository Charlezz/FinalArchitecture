package com.charlezz.android.feature.detail

import android.app.Application
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.text.Html
import android.text.Spanned
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.charlezz.android.R
import com.charlezz.android.core.SingleLiveEvent
import com.charlezz.android.core.extention.toDp
import com.charlezz.android.db.entity.Post
import com.charlezz.htmltextview.*
import kotlinx.coroutines.launch
import timber.log.Timber


class PostDetailViewModel
@ViewModelInject constructor(
        val app: Application,
        @Assisted private val savedStateHandle: SavedStateHandle)
    : AndroidViewModel(app), Html.ImageGetter {

    companion object {
        const val CONTENT_VIEW_PADDING = 16f
        const val KEY_TITLE = "title"
        const val KEY_CONTENT = "content"
        const val KEY_URL = "url"
        const val KEY_RAW_CONTENT = "raw_content"
    }

    private val imageWidth: Int = app.resources.displayMetrics.widthPixels - (CONTENT_VIEW_PADDING * 2f).toDp(app)

    val title = savedStateHandle.getLiveData<String>(KEY_TITLE)
    val content = savedStateHandle.getLiveData<Spanned>(KEY_CONTENT)
    val rawContent = savedStateHandle.getLiveData<String>(KEY_RAW_CONTENT)
    val url = savedStateHandle.getLiveData<String>(KEY_URL)
    val invalidateEvent = MutableLiveData<Boolean>()

    val backEvent = SingleLiveEvent<Void>()
    val optionMenuEvent = SingleLiveEvent<Void>()

    fun load(post: Post) {
        post.title.run {
            title.value = HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
            savedStateHandle.set(KEY_TITLE, title.value)
        }
        post.content.run {
            rawContent.postValue(this)
            val httpImageGetter = HttpImageGetter(
                    app,
                    imageWidth,
                    android.R.drawable.progress_indeterminate_horizontal,
                    R.drawable.broken_image_24px,
                    object : HttpImageGetter.Listener {
                        override fun onDrawableChanged() {
                            invalidateEvent.value = true
                            content.value = content.value
                        }
                    }
            )
            val htmlBuilder = HtmlFormatterBuilder()
                    .setHtml(this)
//                        .setImageGetter(this@PostDetailViewModel)
                    .setImageGetter(httpImageGetter)


            content.value = HtmlFormatter.formatHtml(htmlBuilder)
            viewModelScope.launch {
                savedStateHandle.set(KEY_CONTENT, content.value)
            }
            Timber.d("content has been parsed")
        }
        post.link.run {
            url.value = this
            savedStateHandle.set(KEY_URL, url.value)
        }
    }

    override fun getDrawable(source: String?): Drawable {
        Timber.d("getDrawable = $source")
        return try {
            val bitmap = Glide.with(app).asBitmap().load(source).submit(imageWidth, 0).get()
            val bitmapDrawable = BitmapDrawable(app.resources, bitmap)
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.intrinsicWidth, bitmapDrawable.intrinsicHeight);
            bitmapDrawable
        } catch (e: Exception) {
            ContextCompat.getDrawable(app, R.drawable.broken_image_24px)!!
        }


    }

    fun onBackClick() {
        backEvent.call()
    }

    fun optionMenuClick() {
        optionMenuEvent.call()
    }

}