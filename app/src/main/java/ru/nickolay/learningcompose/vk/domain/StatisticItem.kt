package ru.nickolay.learningcompose.vk.domain

data class StatisticItem(
    val type: StatisticType,
    val count: Int = 0,
    val userClicked: Boolean = false
)

enum class StatisticType {
    LIKE, SHARE, COMMENT, VIEWS
}
