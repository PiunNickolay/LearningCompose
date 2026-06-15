package ru.nickolay.learningcompose.vk.domain.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.nickolay.learningcompose.vk.domain.model.FeedPost
import ru.nickolay.learningcompose.vk.domain.model.PostComment
import ru.nickolay.learningcompose.vk.domain.model.StatisticItem
import ru.nickolay.learningcompose.vk.domain.state.HomeScreenState

class VKViewModel: ViewModel() {

    private val comments = mutableListOf<PostComment>().apply {
        repeat(10) {
            add(PostComment(id = it))
        }
    }
    private val sourceList = mutableListOf<FeedPost>().apply {
        repeat(10) {
            add(FeedPost(id = it))
        }
    }
    private val initialState = HomeScreenState.Posts(sourceList)
    private val _screenState = MutableLiveData<HomeScreenState>(initialState)
    val screenState: LiveData<HomeScreenState> = _screenState

    private var savedState: HomeScreenState? = initialState

    fun showComments(feedPost: FeedPost) {
        savedState = _screenState.value
        _screenState.value = HomeScreenState.Comments(feedPost = feedPost, comments = comments)
    }

    fun closeComments() {
        _screenState.value = savedState!!
    }
    fun updateCount(feedPost: FeedPost, item: StatisticItem) {
        val currentState = screenState.value
        if (currentState !is HomeScreenState.Posts) return
        val oldPosts = currentState.posts.toMutableList()
        val oldStatistics = feedPost.statistic
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll {oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count+1)
                } else {
                    oldItem
                }
            }
        }
        val newFeedPost = feedPost.copy(statistic = newStatistics)
        val newPosts = oldPosts.apply {
            replaceAll {
                if (it.id == newFeedPost.id) {
                    newFeedPost
                } else {
                    it
                }
            }
        }
        _screenState.value = HomeScreenState.Posts(posts = newPosts)
    }

    fun remove(feedPost: FeedPost) {
        val currentState = screenState.value
        if (currentState !is HomeScreenState.Posts) return
        val oldPost = currentState.posts.toMutableList()
        oldPost.remove(feedPost)
        _screenState.value = HomeScreenState.Posts(posts = oldPost)
    }
}