package ru.nickolay.learningcompose.vk.domain.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.nickolay.learningcompose.vk.domain.model.FeedPost
import ru.nickolay.learningcompose.vk.domain.navigation.AppNavGraph
import ru.nickolay.learningcompose.vk.domain.navigation.NavigationItems
import ru.nickolay.learningcompose.vk.domain.navigation.Screens
import ru.nickolay.learningcompose.vk.domain.navigation.rememberNavigationState
import ru.nickolay.learningcompose.vk.domain.presentation.MainScreen.CommentScreen
import ru.nickolay.learningcompose.vk.domain.presentation.MainScreen.MainScreen
import ru.nickolay.learningcompose.vk.domain.viewModel.NewsFeedViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun VKNewsClient() {
    val navigationState = rememberNavigationState()
    val commentsToPost: MutableState<FeedPost?> = remember {
        mutableStateOf(null)
    }
    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                val items =
                    listOf(NavigationItems.Home, NavigationItems.Favorite, NavigationItems.Profile)
                items.forEach { items ->
                    NavigationBarItem(
                        selected = currentRoute == items.screens.route,
                        onClick = { navigationState.navigateTo(items.screens.route) },
                        icon = { Icon(painterResource(items.image), null) },
                        label = { Text(stringResource(items.titleResId)) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Black,
                            selectedTextColor = Color.Black,
                            indicatorColor = Color.LightGray
                        )
                    )
                }
            }
        }
    ) {
        AppNavGraph(
            navHostController = navigationState.navHostController,
            newsScreen = {
                MainScreen(
                    paddingValues = PaddingValues(),
                    onCommentClickListener = {
                        commentsToPost.value = it
                        navigationState.navigateTo(Screens.Comments.route)
                    }
                )
            },
            commentsScreen = {
                CommentScreen(
                    onBackPressed = {
                        commentsToPost.value = null
                    },
                    feedPost = commentsToPost.value!!
                )
            },
            profileScreen = {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Profile", color = Color.Black)
                }
            },
            favoriteScreen = {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Favorite", color = Color.Black)
                }
            }
        )
    }
}

