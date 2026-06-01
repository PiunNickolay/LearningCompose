package ru.nickolay.learningcompose.vk.domain.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import ru.nickolay.learningcompose.vk.domain.FeedPost
import ru.nickolay.learningcompose.vk.domain.VKViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun vkNewsClient(viewModel: VKViewModel) {

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
        val feedPost = viewModel.feedPost.observeAsState(FeedPost())

        Remember(
            modifier = Modifier.padding(8.dp),
            feedPost = feedPost.value,
            onLikeClickListener =  viewModel::update,
            onCommentClickListener = { viewModel.update(it) },
            onShareClickListener = { viewModel.update(it) },
            onViewsClickListener = viewModel::update
        )
    }
}

@Preview
@Composable
fun PreviewVkNewsClient() {
    vkNewsClient(viewModel = VKViewModel())
}