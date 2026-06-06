package ru.nickolay.learningcompose.vk.domain.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.nickolay.learningcompose.vk.domain.Remember
import ru.nickolay.learningcompose.vk.domain.VKViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun VKNewsClient(viewModel: VKViewModel) {
    Scaffold(
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
        val feedPosts = viewModel.feedPosts.observeAsState(listOf())
        LazyColumn(
            contentPadding = PaddingValues(
                top = 16.dp,
                start = 8.dp,
                end = 8.dp,
                bottom = 72.dp
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                items = feedPosts.value,
                key = {it.id}
            ) { feedPost ->
                val dismissState  = rememberSwipeToDismissBoxState()
                if (dismissState.currentValue == SwipeToDismissBoxValue.EndToStart) {
                    viewModel.remove(feedPost)
                }
                SwipeToDismissBox(
                    modifier = Modifier.animateItem(),
                    state = dismissState,
                    backgroundContent = {},
                    enableDismissFromStartToEnd = false,
                    enableDismissFromEndToStart = true
                ) {
                    Remember(
                        feedPost = feedPost,
                        onLikeClickListener = { statisticItem ->
                            viewModel.updateCount(feedPost, statisticItem)},
                        onCommentClickListener = { statisticItem ->
                            viewModel.updateCount(feedPost, statisticItem)},
                        onShareClickListener = { statisticItem ->
                            viewModel.updateCount(feedPost, statisticItem) },
                        onViewsClickListener = { statisticItem ->
                            viewModel.updateCount(feedPost, statisticItem) }
                    )
                }
            }
        }

    }
}

//@Preview
//@Composable
//fun PreviewVkNewsClient() {
//    VKNewsClient(viewModel = VKViewModel())
//}