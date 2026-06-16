package ru.nickolay.learningcompose.vk.domain.navigation

sealed class Screens (
    val route: String
) {
    object NewsFeed: Screens(ROUTE_NEWS_FEED)
    object Favorite: Screens(ROUTE_FAVOURITE)
    object Profile: Screens(ROUTE_PROFILE)
    object Home: Screens(ROUTE_HOME)
    object Comments: Screens(ROUTE_COMMENTS)

    private companion object {
        const val ROUTE_COMMENTS = "comments"
        const val ROUTE_HOME = "home"
        const val ROUTE_NEWS_FEED = "news_feed"
        const val ROUTE_FAVOURITE = "favourite"
        const val ROUTE_PROFILE = "profile"
    }
}