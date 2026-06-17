package ru.nickolay.learningcompose.vk.domain.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.google.gson.Gson
import ru.nickolay.learningcompose.vk.domain.model.FeedPost

fun NavGraphBuilder.homeScreenNavGraph(
    newsScreen: @Composable () -> Unit,
    commentsScreen: @Composable (FeedPost) -> Unit
) {
    navigation(
        startDestination = Screens.NewsFeed.route,
        route = Screens.Home.route
    ) {
        composable(Screens.NewsFeed.route) {
            newsScreen()
        }

        composable(
            route = Screens.Comments.route,
            arguments = listOf(
                navArgument(Screens.KEY_FEED_POST) {
                    type = FeedPost.NavigationType
                }
            )
        ) {
            val feedPost = it.arguments?.getParcelable<FeedPost>(Screens.KEY_FEED_POST)
                ?: throw RuntimeException("ERROR")
            commentsScreen(feedPost)
        }
    }
}