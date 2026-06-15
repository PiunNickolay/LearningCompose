package ru.nickolay.learningcompose.vk.domain.state

import ru.nickolay.learningcompose.vk.domain.model.FeedPost
import ru.nickolay.learningcompose.vk.domain.model.PostComment
import ru.nickolay.learningcompose.vk.domain.navigation.NavigationItems

sealed class HomeScreenState {
    object Initial: HomeScreenState()
    data class Posts(val posts: List<FeedPost>): HomeScreenState()
    data class Comments(val feedPost: FeedPost, val comments: List<PostComment>): HomeScreenState()
}