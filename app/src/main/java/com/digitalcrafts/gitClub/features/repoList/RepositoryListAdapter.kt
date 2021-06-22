package com.digitalcrafts.gitClub.features.repoList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.digitalcrafts.gitClub.data.models.Repository
import com.digitalcrafts.gitClub.databinding.ItemRepositoryBinding

class RepositoryListAdapter : ListAdapter<Repository,
        RepositoryListAdapter.RepositoryViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder =
        ItemRepositoryBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
            .let { RepositoryViewHolder(it) }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class RepositoryViewHolder(private val item: ItemRepositoryBinding) :
        RecyclerView.ViewHolder(item.root) {

        fun bind(data: Repository) {
            item.apply {
                tvRepoName.text = data.name
            }
        }
    }


    private companion object {
        private val diffCallback: DiffUtil.ItemCallback<Repository> by lazy {
            object : DiffUtil.ItemCallback<Repository>() {
                override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean =
                    oldItem.id == newItem.id

                override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean =
                    oldItem == newItem
            }
        }
    }
}