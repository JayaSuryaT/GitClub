package com.digitalcrafts.gitClub.features.repoList

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.digitalcrafts.gitClub.common.arch.BaseAbsFragment
import com.digitalcrafts.gitClub.databinding.FragmentRepositoriesListBinding


class RepositoriesListFragment : BaseAbsFragment<RepoListViewModel,
        FragmentRepositoriesListBinding>(FragmentRepositoriesListBinding::inflate) {

    private val repoAdapter: RepositoryListAdapter by lazy { RepositoryListAdapter() }

    override val viewModel: RepoListViewModel by viewModels()

    override fun setupViews(): FragmentRepositoriesListBinding.() -> Unit = {

        rvReposList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = repoAdapter
        }
    }

    override fun setupObservers(): RepoListViewModel.() -> Unit = {

        obsRepositories.observe(viewLifecycleOwner) { repos ->
            repoAdapter.submitList(repos ?: listOf())
        }
    }
}