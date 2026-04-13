package ru.nickolay.learningcompose.inst

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel: ViewModel() {

    private val initialList = mutableListOf<InstagramModel>().apply {
        repeat(33) {
            add(
                InstagramModel(
                    id = it,
                    title = "This is $it",
                    isFollowed = Random.nextBoolean()
                )
            )
        }
    }

    private val _models = MutableLiveData<List<InstagramModel>>(initialList)
    val models: LiveData<List<InstagramModel>> = _models

    fun followedModifier(model: InstagramModel) {
        val modifiedModel = _models.value?.toMutableList() ?: mutableListOf()
        modifiedModel.replaceAll {
            if (it == model) {
                it.copy(isFollowed = !it.isFollowed)
            } else {
                it
            }
        }
        _models.value = modifiedModel
    }

    fun delete(model: InstagramModel) {
        val modifiedModel = _models.value?.toMutableList() ?: mutableListOf()
        modifiedModel.remove(model)
        _models.value = modifiedModel
    }

}