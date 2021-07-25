package com.digitalcrafts.gitClub.features.repoList

import android.content.Context.INPUT_METHOD_SERVICE
import android.content.Intent
import android.net.Uri
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.digitalcrafts.gitClub.common.arch.BaseAbsFragment
import com.digitalcrafts.gitClub.common.toggleVisibility
import com.digitalcrafts.gitClub.data.dataSources.models.Repository
import com.digitalcrafts.gitClub.databinding.FragmentRepositoriesListBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RepositoriesListFragment : BaseAbsFragment<RepoListViewModel,
        FragmentRepositoriesListBinding>(FragmentRepositoriesListBinding::inflate) {

    private val repoAdapter: RepositoryListAdapter by lazy { RepositoryListAdapter(::onItemSelected) }

    override val viewModel: RepoListViewModel by viewModels()

    override fun setupViews(): FragmentRepositoriesListBinding.() -> Unit = {

        rvReposList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = repoAdapter
        }

        etSearch.setOnEditorActionListener { _, actionId, _ ->

            if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                val searchKey = etSearch.text?.toString()
                if (!searchKey.isNullOrEmpty()) viewModel.searchForRepositories(searchKey)

                val imm: InputMethodManager =
                    activity?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(etSearch.windowToken, 0)
                return@setOnEditorActionListener true
            }
            false
        }
    }

    override fun setupObservers(): RepoListViewModel.() -> Unit = {

        obsRepositories.observe(viewLifecycleOwner) { repos ->
            binding.ivSearchRepositories.toggleVisibility(repos.isNullOrEmpty())
            repoAdapter.submitList(repos ?: listOf())
        }

        obsIsDataLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.pbLoading.toggleVisibility(isLoading == true)
        }
    }

    private fun onItemSelected(repository: Repository) {
        val url = repository.htmlUrl.takeIf { it.isNotEmpty() } ?: return
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }
}