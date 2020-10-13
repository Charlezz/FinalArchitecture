package com.charlezz.android.feature.post

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import androidx.paging.map
import com.charlezz.android.CategoryRepository
import com.charlezz.android.UserRepository
import com.charlezz.android.core.SingleLiveEvent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*


class PostViewModel
@ViewModelInject constructor(
        private val postRepository: PostRepository,
        private val userRepository: UserRepository,
        private val categoryRepository: CategoryRepository,
        @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel(),
        PostItem.PostListener {

    private val clearListCh = Channel<Unit>(Channel.CONFLATED)

    val postClickEvent = SingleLiveEvent<PostItem>()
    val postLongClickEvent = SingleLiveEvent<PostItem>()

    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    val posts = flowOf(
            clearListCh.receiveAsFlow().map { PagingData.empty() },
            postRepository.getPosts(3).map { pagingData ->
                pagingData.map { post -> PostItem(post, userRepository, categoryRepository, this@PostViewModel) }
            }
    ).flattenMerge(2)

    override fun onPostClick(postItem: PostItem) {
        postClickEvent.value = postItem
    }

    override fun onPostLongClick(postItem: PostItem): Boolean {
        postLongClickEvent.value = postItem
        return false
    }

    override fun onCleared() {
        super.onCleared()
        clearListCh.close()
    }

}