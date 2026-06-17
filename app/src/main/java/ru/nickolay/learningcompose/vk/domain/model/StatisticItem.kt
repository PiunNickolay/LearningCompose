package ru.nickolay.learningcompose.vk.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StatisticItem(
    val type: StatisticType,
    val count: Int = 0,
    val userClicked: Boolean = false
): Parcelable

enum class StatisticType {
    LIKE, SHARE, COMMENT, VIEWS
}
