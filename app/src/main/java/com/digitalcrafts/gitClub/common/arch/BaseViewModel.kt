package com.digitalcrafts.gitClub.common.arch

import android.util.Log
import androidx.lifecycle.ViewModel
import com.digitalcrafts.gitClub.data.models.KResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob

open class BaseViewModel : ViewModel() {

    @Suppress("PropertyName")
    protected val TAG: String by lazy { javaClass.simpleName }

    private val jobDelegate: Lazy<Job> = lazy { SupervisorJob() }
    private val job by jobDelegate
    protected val ioScope: CoroutineScope by lazy { CoroutineScope(Dispatchers.IO + job) }

    protected inline fun <reified T> KResult<T>.logError(): KResult<T> {
        if (this is KResult.Error) Log.e(TAG, this.toString())
        return this
    }

    override fun onCleared() {
        super.onCleared()
        if (jobDelegate.isInitialized()) jobDelegate.value.cancel()
    }
}