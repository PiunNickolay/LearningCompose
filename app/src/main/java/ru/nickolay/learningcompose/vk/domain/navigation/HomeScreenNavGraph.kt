package ru.nickolay.learningcompose.vk.domain.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.homeScreenNavGraph(
    newsScreen: @Composable () -> Unit,
    commentsScreen: @Composable () -> Unit
) {
    navigation(
        startDestination = Screens.NewsFeed.route,
        route = Screens.Home.route
    ) {
        composable(Screens.NewsFeed.route) {
            newsScreen()
        }

        composable(Screens.Comments.route) {
            commentsScreen()
        }
    }
}