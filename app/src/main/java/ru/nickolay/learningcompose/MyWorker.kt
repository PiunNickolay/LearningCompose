package ru.nickolay.learningcompose

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(appContext: Context, params: WorkerParameters): Worker(appContext, params) {
    override fun doWork(): Result {
        Log.d("WorkManaGer", "Work is DONE")

        return Result.success()
    }
// Получение данных
//    override fun doWork(): Result {
//        val name = inputData.getString("username")
//        Log.d("WM", "Привет, $name")
//
//        return Result.success()
//    }
// Что делать при ошибке
//    override fun doWork(): Result {
//        return try {
//            // имитация ошибки
//            throw Exception()
//        } catch (e: Exception) {
//            Result.retry()
//        }
//    }

}