package com.digitalcrafts.gitClub.features.repoList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.digitalcrafts.gitClub.common.arch.BaseViewModel
import com.digitalcrafts.gitClub.data.dataSources.definitons.DataSourceRepositories
import com.digitalcrafts.gitClub.data.dataSources.models.Repository
import kotlinx.coroutines.launch

class RepoListViewModel(
    private val repoRepositories: DataSourceRepositories
) : BaseViewModel() {

    private val _obsRepositories: MutableLiveData<List<Repository>> = MutableLiveData()
    val obsRepositories: LiveData<List<Repository>> get() = _obsRepositories

    init {
        ioScope.launch { doWhileLoading { loadAllReposFromCache() } }
    }

    fun searchForRepositories(searchKey: String) {

        ioScope.launch {

            doWhileLoading {

                val repos = repoRepositories
                    .getRepositoriesFor(searchKey)
                    .logError()
                    .getOrNull()
                    ?.sortedByDescending { it.stargazersCount }

                _obsRepositories.postValue(repos)
            }
        }
    }

    private suspend fun loadAllReposFromCache() {

        val repos = repoRepositories
            .getAllCachedRepositories()
            .logError()
            .getOrNull()
            ?.sortedByDescending { it.stargazersCount }

        _obsRepositories.postValue(repos)
    }
}