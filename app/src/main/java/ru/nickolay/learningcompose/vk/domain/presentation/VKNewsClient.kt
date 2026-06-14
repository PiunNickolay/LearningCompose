package ru.nickolay.learningcompose.vk.domain.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.nickolay.learningcompose.vk.domain.navigation.AppNavGraph
import ru.nickolay.learningcompose.vk.domain.navigation.NavigationItems
import ru.nickolay.learningcompose.vk.domain.navigation.Screens
import ru.nickolay.learningcompose.vk.domain.presentation.MainScreen.MainScreen
import ru.nickolay.learningcompose.vk.domain.viewModel.VKViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun VKNewsClient(viewModel: VKViewModel) {
    val navHostController = rememberNavController()
    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navHostController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                val items =
                    listOf(NavigationItems.Home, NavigationItems.Favorite, NavigationItems.Profile)
                items.forEach { items ->
                    NavigationBarItem(
                        selected = currentRoute == items.screens.route,
                        onClick = {
                            navHostController.navigate(items.screens.route) {
                                popUpTo(Screens.NewsFeed.route) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
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
            navHostController = navHostController,
            homeScreen = { MainScreen(viewModel) },
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

