package ru.nickolay.learningcompose.vk.domain.presentation.MainScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.nickolay.learningcompose.vk.domain.presentation.Remember
import ru.nickolay.learningcompose.vk.domain.viewModel.VKViewModel

@Composable
fun MainScreen(viewModel: VKViewModel) {
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