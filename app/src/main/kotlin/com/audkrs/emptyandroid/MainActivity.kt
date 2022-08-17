package com.audkrs.emptyandroid

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.add_work).setOnClickListener { startWork() }

        WorkManager.getInstance(this).getWorkInfosForUniqueWorkLiveData(WORK_ID)
            .observe(this) {
                val workList = it.map { it.tags.joinToString() + " " + "state: "  + it.state.name}
                println("=== Work list: $workList")

                findViewById<TextView>(R.id.work_log).text = workList.joinToString("\n")
            }
    }

    private fun startWork() {
        val workManager = WorkManager.getInstance(this)

        OneTimeWorkRequestBuilder<ExampleWorker>()
            .setInputData(workDataOf(
                ExampleWorker.PARAM_SHOULD_SUCCEED to true,
            ))
            .keepResultsForAtLeast(1, TimeUnit.DAYS)
            .addTag("job1")
            .build()
            .also { workRequest ->
                workManager
                    .beginUniqueWork(WORK_ID, ExistingWorkPolicy.REPLACE, workRequest)
                    .enqueue()
            }

        OneTimeWorkRequestBuilder<ExampleWorker>()
            .setInputData(workDataOf(
                ExampleWorker.PARAM_SHOULD_SUCCEED to false,
            ))
            .keepResultsForAtLeast(1, TimeUnit.DAYS)
            .addTag("job2")
            .build()
            .also { workRequest ->
                workManager
                    .beginUniqueWork(WORK_ID, ExistingWorkPolicy.APPEND, workRequest)
                    .enqueue()
            }

        OneTimeWorkRequestBuilder<ExampleWorker>()
            .setInputData(workDataOf(
                ExampleWorker.PARAM_SHOULD_SUCCEED to true,
            ))
            .keepResultsForAtLeast(1, TimeUnit.DAYS)
            .addTag("job3")
            .build()
            .also { workRequest ->
                workManager
                    .beginUniqueWork(WORK_ID, ExistingWorkPolicy.APPEND, workRequest)
                    .enqueue()
            }
    }

    companion object {
        const val WORK_ID = "workId"
    }
}
