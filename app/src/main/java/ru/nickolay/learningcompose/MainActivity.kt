package ru.nickolay.learningcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Test() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = { Text("TopAppBar") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(painter = painterResource(R.drawable.ic_menu), contentDescription = null)
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(painterResource(R.drawable.ic_like), contentDescription = null)
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = {}) {Icon(painterResource(R.drawable.ic_like), contentDescription = null) }
                    IconButton(onClick = {}) {Icon(painterResource(R.drawable.ic_comment), contentDescription = null) }
                    IconButton(onClick = {}) {Icon(painterResource(R.drawable.ic_share), contentDescription = null) }
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = {},
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(painterResource(R.drawable.ic_launcher_foreground), "Localize description")
                    }
                }
            )
        },

    ) {
        Text(
            modifier = Modifier.padding(it),
            text = "This is scaffold test"
        )
    }
}



//@Composable
//fun Example1() {
//    OutlinedButton(onClick = {}) {
//        Text(text = "Hello World")
//    }
//}
//
//@Composable
//fun Example2() {
//    TextField(
//        value = "Value",
//        onValueChange = {},
//        label = { Text(text = "Label") }
//    )
//}
//
//@Composable
//fun Example3() {
//    AlertDialog(
//        onDismissRequest = {},
//        confirmButton = {
//            Text(
//                modifier = Modifier.padding(8.dp),
//                text = "Yes"
//            )
//        },
//        title = {
//            Text(
//                text = "Are you sure?"
//            )
//        },
//        text = {
//            Text(
//                text = "Do you want to delete this file?"
//            )
//        },
//        dismissButton = {
//            Text(
//                modifier = Modifier.padding(8.dp),
//                text = "No"
//            )
//        }
//    )
//}

@Preview
@Composable
fun PreviewCheckBox() {
    Test()
}





