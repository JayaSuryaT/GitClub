package com.digitalcrafts.gitClub.features.repoList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.digitalcrafts.gitClub.common.arch.BaseViewModel
import com.digitalcrafts.gitClub.data.dataSources.definitions.DataSourceRepositories
import com.digitalcrafts.gitClub.data.dataSources.repos.RepoRepositories
import com.digitalcrafts.gitClub.data.models.Repository
import kotlinx.coroutines.launch

class RepoListViewModel(
    private val repoRepositories: DataSourceRepositories = RepoRepositories()
) : BaseViewModel() {

    private val _obsRepositories: MutableLiveData<List<Repository>> = MutableLiveData()
    val obsRepositories: LiveData<List<Repository>> get() = _obsRepositories

    init {
        ioScope.launch { loadRepos() }
    }

    private suspend fun loadRepos() {

        val repos = repoRepositories
            .getRepositoriesFor("flocking")
            .logError()
            .getOrNull()

        Log.d(TAG, "Received list of ${repos?.size}")

        _obsRepositories.postValue(repos)
    }
}