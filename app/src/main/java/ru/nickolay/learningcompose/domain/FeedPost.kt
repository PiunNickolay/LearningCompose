package ru.nickolay.learningcompose.domain

import ru.nickolay.learningcompose.R

data class FeedPost(
    val publicName: String = "/dev/null",
    val publishedTime: String = "14:00",
    val avatar: Int = R.drawable.post_comunity_thumbnail,
    val contentText: String = "Кабаныч, когда узнал, что если не платить сотрудникам, то они умрут с голода",
    val contentImage: Int = R.drawable.post_content_image,
    val statistic: List<StatisticItem> = listOf(
        StatisticItem(StatisticType.LIKE, 500),
        StatisticItem(StatisticType.SHARE, 100),
        StatisticItem(StatisticType.COMMENT, 50),
        StatisticItem(StatisticType.VIEWS, 966)
    )
)
