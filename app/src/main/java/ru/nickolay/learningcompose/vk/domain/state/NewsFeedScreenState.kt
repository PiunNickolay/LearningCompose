package ru.nickolay.learningcompose.vk.domain.state

import ru.nickolay.learningcompose.vk.domain.model.FeedPost
import ru.nickolay.learningcompose.vk.domain.model.PostComment

sealed class NewsFeedScreenState {
    object Initial: NewsFeedScreenState()
    data class Posts(val posts: List<FeedPost>): NewsFeedScreenState()
}