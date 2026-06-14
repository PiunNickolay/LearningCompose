package ru.nickolay.learningcompose.vk.domain.navigation

sealed class Screens (
    val route: String
) {
    object NewsFeed: Screens(ROUTE_NEWS_FEED)
    object Favorite: Screens(ROUTE_FAVOURITE)
    object Profile: Screens(ROUTE_PROFILE)

    private companion object {
        const val ROUTE_NEWS_FEED = "news_feed"
        const val ROUTE_FAVOURITE = "favourite"
        const val ROUTE_PROFILE = "profile"
    }
}