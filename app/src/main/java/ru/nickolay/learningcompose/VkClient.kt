package ru.nickolay.learningcompose

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.nickolay.learningcompose.domain.FeedPost
import ru.nickolay.learningcompose.domain.StatisticItem
import ru.nickolay.learningcompose.domain.StatisticType

@Composable
fun Remember(
    modifier: Modifier = Modifier,
    feedPost: FeedPost,
    onStatisticksClickListener: (StatisticItem)->Unit
) {
    Card(modifier = modifier) {
        Column(modifier = Modifier.padding(8.dp)) {
            PostHeader(feedPost)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = feedPost.contentText)
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = painterResource(feedPost.contentImage),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(8.dp))
            Statistics(feedPost.statistic, onItemClickListener = onStatisticksClickListener)
        }

    }
}

@Composable
private fun PostHeader(feedPost: FeedPost) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            painter = painterResource(feedPost.avatar),
            contentDescription = " "
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(text = feedPost.publicName)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = feedPost.publishedTime)
        }
        Icon(
            painterResource(R.drawable.ic_menu),
            contentDescription = null,
            tint = Color.Gray
        )
    }
}

@Composable
private fun Statistics(
    statisticks: List<StatisticItem>,
    onItemClickListener: (StatisticItem) -> Unit
) {
    Row {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            val viewsItem = statisticks.getItemByType(StatisticType.VIEWS)
            IconAndText(
                R.drawable.ic_views_count,
                viewsItem.count.toString(),
                { onItemClickListener(viewsItem) })
        }
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val shareItem = statisticks.getItemByType(StatisticType.SHARE)
            IconAndText(
                R.drawable.ic_share,
                shareItem.count.toString(),
                { onItemClickListener(shareItem) })
            val commentItem = statisticks.getItemByType(StatisticType.COMMENT)
            IconAndText(
                R.drawable.ic_comment,
                commentItem.count.toString(),
                { onItemClickListener(commentItem) })
            val likeItem = statisticks.getItemByType(StatisticType.LIKE)
            IconAndText(
                R.drawable.ic_like,
                likeItem.count.toString(),
                { onItemClickListener(likeItem) })
        }
    }
}

private fun List<StatisticItem>.getItemByType(type: StatisticType): StatisticItem {
    return this.find { it.type == type } ?: throw IllegalArgumentException()
}

@Composable
private fun IconAndText(
    iconrResId: Int,
    text: String,
    onItemClickListener: () -> Unit
) {
    Row(
        modifier = Modifier.clickable {
            onItemClickListener()
        },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painterResource(id = iconrResId), contentDescription = null)
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = text)
    }
}

@Preview
@Composable
fun RememberPreview() {
    Remember(
        feedPost = FeedPost(
            "/dev/null",
            "14:00",
            R.drawable.post_comunity_thumbnail,
            "Кабаныч, когда узнал, что если не платить сотрудникам, то они умрут с голода",
            R.drawable.post_content_image,
            listOf(
                StatisticItem(StatisticType.LIKE, 500),
                StatisticItem(StatisticType.SHARE, 100),
                StatisticItem(StatisticType.COMMENT, 50),
                StatisticItem(StatisticType.VIEWS, 966)
            )
        ),
        onStatisticksClickListener = {}
    )
}