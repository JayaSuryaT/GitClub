package com.digitalcrafts.gitClub.features.repoList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.digitalcrafts.gitClub.R
import com.digitalcrafts.gitClub.common.loadImage
import com.digitalcrafts.gitClub.data.models.Repository
import com.digitalcrafts.gitClub.databinding.ItemRepositoryBinding

class RepositoryListAdapter(
    private val onRepositoryClick: (Repository) -> Unit,
) : ListAdapter<Repository, RepositoryListAdapter.RepositoryViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder =
        ItemRepositoryBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
            .let { RepositoryViewHolder(it) }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class RepositoryViewHolder(private val item: ItemRepositoryBinding) :
        RecyclerView.ViewHolder(item.root) {

        init {
            item.cvRoot.setOnClickListener {
                val position = adapterPosition
                if (position >= 0) onRepositoryClick(getItem(position))
            }
        }

        private fun TextView.setTextAndShow(text: String?) {
            if (text.isNullOrEmpty()) this.visibility = View.GONE
            else this.visibility = View.VISIBLE
            this.text = text
        }

        fun bind(data: Repository) {
            item.apply {
                tvRepoName.setTextAndShow(data.name)
                tvRepoOwnerName.setTextAndShow(data.owner.login)
                tvDescription.setTextAndShow(data.description)
                ivAvatar.loadImage(data.owner.avatarUrl)
                tvLanguage.setTextAndShow(data.language ?: item.root.context.getString(R.string.n_a))
                tvStargazersCount.setTextAndShow(data.stargazersCount.toString())
                tvWatchersCount.setTextAndShow(data.watchersCount.toString())
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