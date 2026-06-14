package ru.nickolay.learningcompose.vk.domain.presentation

import android.annotation.SuppressLint
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import ru.nickolay.learningcompose.vk.domain.navigation.NavigationItems
import ru.nickolay.learningcompose.vk.domain.presentation.MainScreen.MainScreen
import ru.nickolay.learningcompose.vk.domain.viewModel.VKViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun VKNewsClient(viewModel: VKViewModel) {
    val selectedNavItems by viewModel.selectedItem.observeAsState()
    Scaffold(
        bottomBar = {
            NavigationBar {
                val items =
                    listOf(NavigationItems.Home, NavigationItems.Favorite, NavigationItems.Profile)
                items.forEach { items ->
                    NavigationBarItem(
                        selected = selectedNavItems == items,
                        onClick = { viewModel.selectItem(items) },
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
        when (selectedNavItems) {
            NavigationItems.Home -> MainScreen(viewModel)
            NavigationItems.Favorite -> Text("Favorite", color = Color.Black)
            NavigationItems.Profile -> Text("Profile", color = Color.Black)
            null -> Text("Error", color = Color.Black)
        }
    }
}

