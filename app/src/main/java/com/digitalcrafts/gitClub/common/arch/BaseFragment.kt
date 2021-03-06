package com.digitalcrafts.gitClub.common.arch

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob

open class BaseFragment : Fragment() {

    private val jobDelegate: Lazy<Job> = lazy { SupervisorJob() }
    private val job by jobDelegate
    protected val uiScope: CoroutineScope by lazy { CoroutineScope(Dispatchers.Main + job) }

    protected fun NavDirections.navigate() = findNavController().navigate(this)

    override fun onDestroy() {
        super.onDestroy()
        if (jobDelegate.isInitialized()) jobDelegate.value.cancel()
    }
}