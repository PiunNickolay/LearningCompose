package ru.nickolay.learningcompose.vk.domain.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.nickolay.learningcompose.vk.domain.model.FeedPost
import ru.nickolay.learningcompose.vk.domain.navigation.Screens


@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    newsScreen: @Composable () -> Unit,
    profileScreen: @Composable () -> Unit,
    favoriteScreen: @Composable () -> Unit,
    commentsScreen: @Composable (FeedPost) -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.Home.route
    ) {
        homeScreenNavGraph(
            newsScreen = newsScreen,
            commentsScreen = commentsScreen
        )
        composable(Screens.Favorite.route) {
            favoriteScreen()
        }
        composable(Screens.Profile.route) {
            profileScreen()
        }
    }
}