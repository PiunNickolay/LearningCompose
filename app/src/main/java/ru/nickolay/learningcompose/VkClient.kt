package ru.nickolay.learningcompose

import android.media.Image
import androidx.compose.foundation.Image
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

@Composable
fun Remember() {
    Card() {
        Column(modifier = Modifier.padding(8.dp)) {
            PostHeader()
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Кабаныч, когда узнал, что если не платить сотрудникам, то они умрут с голода")
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(R.drawable.post_content_image),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(8.dp))
            Statistics()
        }

    }
}

@Composable
private fun PostHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            painter = painterResource(R.drawable.post_comunity_thumbnail),
            contentDescription = " "
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(text = "/dev/null")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "14:00")
        }
        Icon(
            painterResource(R.drawable.ic_menu),
            contentDescription = null,
            tint = Color.Gray
        )
    }
}

@Composable
private fun Statistics() {
    Row {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            IconAndText(R.drawable.ic_views_count, "10000")
        }
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconAndText(R.drawable.ic_share, "977")
            IconAndText(R.drawable.ic_comment, "50")
            IconAndText(R.drawable.ic_like, "1000")
        }
    }
}

@Composable
private fun IconAndText(
    iconrResId: Int,
    text: String
) {
    Row(
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
    Remember()
}