package ru.nickolay.learningcompose.vk.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class VKViewModel: ViewModel() {
    private val _feedPost = MutableLiveData(FeedPost())
    var feedPost: LiveData<FeedPost> = _feedPost

    fun update(item: StatisticItem) {
        val oldStatistics = feedPost.value?.statistic ?: throw IllegalArgumentException("This argument is exist")
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll {oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count+1)
                } else {
                    oldItem
                }
            }
        }
        _feedPost.value = feedPost.value?.copy(statistic = newStatistics)
    }
}