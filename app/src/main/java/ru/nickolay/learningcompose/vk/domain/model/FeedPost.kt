package ru.nickolay.learningcompose.vk.domain.model

import android.os.Parcelable
import androidx.navigation.NavType
import androidx.savedstate.SavedState
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize
import ru.nickolay.learningcompose.R

@Parcelize
data class FeedPost(
    val id: Int,
    val publicName: String = "/dev/null",
    val publishedTime: String = "14:00",
    val avatar: Int = R.drawable.post_comunity_thumbnail,
    val contentText: String = "Кабаныч, когда узнал, что если не платить сотрудникам, то они умрут с голода",
    val contentImage: Int = R.drawable.post_content_image,
    val statistic: List<StatisticItem> = listOf(
        StatisticItem(StatisticType.LIKE, 500),
        StatisticItem(StatisticType.SHARE, 100),
        StatisticItem(StatisticType.COMMENT, 50),
        StatisticItem(StatisticType.VIEWS, 966)
    )
): Parcelable {
    companion object {
        val NavigationType: NavType<FeedPost> = object : NavType<FeedPost>(false) {
            override fun put(
                bundle: SavedState,
                key: String,
                value: FeedPost
            ) {
                bundle.putParcelable(key, value)
            }

            override fun get(
                bundle: SavedState,
                key: String
            ): FeedPost? {
                return bundle.getParcelable(key)
            }

            override fun parseValue(value: String): FeedPost {
                return Gson().fromJson(value, FeedPost::class.java)
            }

        }
    }
}