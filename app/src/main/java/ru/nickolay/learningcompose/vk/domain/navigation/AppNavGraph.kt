package ru.nickolay.learningcompose.vk.domain.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.nickolay.learningcompose.vk.domain.navigation.Screens


@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    homeScreen: @Composable () -> Unit,
    profileScreen: @Composable () -> Unit,
    favoriteScreen: @Composable () -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.NewsFeed.route
    ) {
        composable(Screens.NewsFeed.route) {
            homeScreen()
        }
        composable(Screens.Favorite.route) {
            favoriteScreen()
        }
        composable(Screens.Profile.route) {
            profileScreen()
        }
    }
}