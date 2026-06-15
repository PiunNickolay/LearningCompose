package ru.nickolay.learningcompose.vk.domain.model

import ru.nickolay.learningcompose.R

data class PostComment(
    val id: Int,
    val authorName: String = "author",
    val authorImage: Int = R.drawable.comment_author_avatar,
    val commentText: String = "Long comment there",
    val publicationTime: String = "14:00"
)
