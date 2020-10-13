package com.charlezz.android.feature.post

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.charlezz.android.BR
import com.charlezz.android.CategoryRepository
import com.charlezz.android.R
import com.charlezz.android.UserRepository
import com.charlezz.android.db.entity.Post
import com.charlezz.android.core.recyclerview.LayoutAware
import kotlinx.coroutines.*

class PostItem
constructor(
        val post: Post,
        val userRepository: UserRepository,
        val categoryRepository: CategoryRepository,
        val postListener: PostListener
) : BaseObservable(), LayoutAware {

    //fixme: 다수의 카테고리 표시
    val title = HtmlCompat.fromHtml(post.title, HtmlCompat.FROM_HTML_MODE_LEGACY)
    val excerpt = HtmlCompat.fromHtml(post.excerpt, HtmlCompat.FROM_HTML_MODE_LEGACY)
    var author: String? = null @Bindable get
    var category: String? = null @Bindable get

    fun getRandomColor(context:Context):Int{
        return ContextCompat.getColor(context,
                when(post.id.toInt()%6){
                    0-> R.color.tag_01
                    1-> R.color.tag_02
                    2-> R.color.tag_03
                    3-> R.color.tag_04
                    4-> R.color.tag_05
                    5-> R.color.tag_06
                    else -> R.color.tag_01
                }
        )
    }

    init {
        CoroutineScope(Dispatchers.IO).launch {
            author = userRepository.getUser(post.author)?.name
            notifyPropertyChanged(BR.author)
        }

        CoroutineScope(Dispatchers.IO).launch {
            if (post.categories.isNotEmpty()) {
                category = categoryRepository.getCategory(post.categories[0])?.name
                notifyPropertyChanged(BR.category)
            }
        }

    }

    override fun getViewType() = R.layout.view_post_item

    override fun getBindingResId() = BR.viewModel

    interface PostListener {
        fun onPostClick(postItem: PostItem)
        fun onPostLongClick(postItem: PostItem):Boolean
    }

}