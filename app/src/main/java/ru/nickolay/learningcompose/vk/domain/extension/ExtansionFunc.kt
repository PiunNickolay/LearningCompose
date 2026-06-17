package ru.nickolay.learningcompose.vk.domain.extension

import android.net.Uri

fun String.encode(): String {
    return Uri.encode(this)
}