package ru.nickolay.learningcompose.vk.domain.navigation


import android.media.Image
import androidx.compose.ui.res.painterResource
import ru.nickolay.learningcompose.R

sealed class NavigationItems(
    val screens: Screens,
    val titleResId: Int,
    val image: Int
) {
    object Home: NavigationItems(Screens.NewsFeed,R.string.navigation_item_main,  R.drawable.ic_home)
    object Favorite: NavigationItems(Screens.Favorite, R.string.navigation_item_favorite, image = R.drawable.ic_like_selected)
    object Profile: NavigationItems(Screens.Profile, R.string.navigation_item_profile, R.drawable.ic_profile)
}