package ru.nickolay.learningcompose.vk.domain.navigation

import com.google.gson.Gson
import ru.nickolay.learningcompose.vk.domain.extension.encode
import ru.nickolay.learningcompose.vk.domain.model.FeedPost

sealed class Screens(
    val route: String
) {
    object NewsFeed : Screens(ROUTE_NEWS_FEED)
    object Favorite : Screens(ROUTE_FAVOURITE)
    object Profile : Screens(ROUTE_PROFILE)
    object Home : Screens(ROUTE_HOME)
    object Comments : Screens(ROUTE_COMMENTS) {
        private const val ROUTE_FOR_ARGS = "comments"
        fun getRouteWithArgs(feedPost: FeedPost): String {
            val feedPostJson = Gson().toJson(feedPost)
            return "$ROUTE_FOR_ARGS/${feedPostJson.encode()}"
        }
    }

    companion object {
        const val KEY_FEED_POST = "feed_post"
        const val ROUTE_COMMENTS = "comments/{$KEY_FEED_POST}"
        const val ROUTE_HOME = "home"
        const val ROUTE_NEWS_FEED = "news_feed"
        const val ROUTE_FAVOURITE = "favourite"
        const val ROUTE_PROFILE = "profile"
    }
}

