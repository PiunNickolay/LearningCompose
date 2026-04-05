package ru.nickolay.learningcompose.navigation

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import ru.nickolay.learningcompose.R

@Composable
fun vkNewsClient() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val fabIsVisisble = remember {
        mutableStateOf(true)
    }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            if (fabIsVisisble.value == true) {
                FloatingActionButton(
                    onClick = {
                        scope.launch {
                            val action = snackbarHostState.showSnackbar(
                                message = "This is snackbar",
                                actionLabel = "Hide FAB",
                                duration = SnackbarDuration.Long
                            )
                            if (action == SnackbarResult.ActionPerformed) {
                                fabIsVisisble.value = false
                            }
                        }
                    }
                ) {
                    Icon(painter = painterResource(R.drawable.ic_like_selected), null)
                }
            }
        },
        bottomBar = {
            NavigationBar {
                var selectedItemPosition = remember {
                    mutableStateOf(0)
                }

                val items =
                    listOf(NavigationItems.Home, NavigationItems.Favorite, NavigationItems.Profile)
                items.forEachIndexed { index, items ->
                    NavigationBarItem(
                        selected = selectedItemPosition.value == index,
                        onClick = { selectedItemPosition.value = index },
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
        Box(Modifier.padding(it))
    }
}

@Preview
@Composable
fun PreviewVkNewsClient() {
    vkNewsClient()
}