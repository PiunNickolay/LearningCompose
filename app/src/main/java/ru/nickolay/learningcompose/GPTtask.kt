package ru.nickolay.learningcompose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class User(
    val name: String,
    val dev: String,
    val paint: Int
)

@Composable
fun ProfileCard() {
    val users = listOf(
        User("Ivan Petrov", "Android Dev", R.drawable.post_comunity_thumbnail),
        User("Anna Smirnova", "UI Designer", R.drawable.post_comunity_thumbnail),
        User("Dmitry Volkov", "QA Engineer", R.drawable.post_comunity_thumbnail)
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(users) { user ->
            CardProfileUserLazy(
                name = user.name,
                dev = user.dev,
                paint = user.paint
            )
        }
    }
}

@Composable
fun CardProfileUserLazy(name: String, dev: String, paint: Int) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape),
                painter = painterResource(paint),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = name,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = dev,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(15.dp))
            Button(
                onClick = {},
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(0.6f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Magenta,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Subscribe", fontSize = 18.sp)
            }
        }
    }
}

@Preview
@Composable
fun PreviewForGpt() {
    ProfileCard()
}