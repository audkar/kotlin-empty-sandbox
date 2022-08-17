package com.audkrs.emptyandroid

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class ExampleWorker(
    appContext: Context,
    workerParams: WorkerParameters,
) : Worker(appContext, workerParams) {

    override fun doWork(): Result {
        val shouldSucceed = inputData.getBoolean(PARAM_SHOULD_SUCCEED, true)
        return if (shouldSucceed) {
            Result.success()
        } else {
            Result.failure()
        }
    }

    companion object {
        const val PARAM_SHOULD_SUCCEED = "shouldSucceed"
    }
}
