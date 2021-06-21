package com.digitalcrafts.gitClub.common.arch

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob

open class BaseViewModel : ViewModel() {

    private val jobDelegate: Lazy<Job> = lazy { SupervisorJob() }
    private val job by jobDelegate
    private val ioScope: CoroutineScope by lazy { CoroutineScope(Dispatchers.IO + job) }

    override fun onCleared() {
        super.onCleared()
        if (jobDelegate.isInitialized()) jobDelegate.value.cancel()
    }
}