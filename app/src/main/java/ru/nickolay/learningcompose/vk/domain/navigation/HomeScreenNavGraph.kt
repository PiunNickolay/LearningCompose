package ru.nickolay.learningcompose.vk.domain.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
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
                navArgument(Screens.KEY_FEED_POST_ID) {
                    type = NavType.IntType
                }
            )
        ) {
            val feedPostId = it.arguments?.getInt(Screens.KEY_FEED_POST_ID ) ?: 0
            commentsScreen(FeedPost(feedPostId))
        }
    }
}