package ru.nickolay.learningcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import ru.nickolay.learningcompose.inst.InstagramProfileCard
import ru.nickolay.learningcompose.inst.MainViewModel
import ru.nickolay.learningcompose.ui.theme.LearningComposeTheme
import ru.nickolay.learningcompose.vk.domain.presentation.MainScreen.MainScreen
import ru.nickolay.learningcompose.vk.domain.viewModel.NewsFeedViewModel
import ru.nickolay.learningcompose.vk.domain.presentation.VKNewsClient



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[NewsFeedViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            VKNewsClient()
        }
    }
}












