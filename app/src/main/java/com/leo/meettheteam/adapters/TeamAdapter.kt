package com.leo.meettheteam.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leo.meettheteam.databinding.TeamItemBinding
import com.leo.meettheteam.models.User
import com.leo.meettheteam.utils.Extensions.openActivity
import com.leo.meettheteam.views.DetailActivity


class TeamAdapter(private val users: List<User>): RecyclerView.Adapter<TeamAdapter.TeamHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val teamItemBinding = TeamItemBinding.inflate(layoutInflater, parent, false)
        return TeamHolder(teamItemBinding, parent.context)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: TeamHolder, position: Int) {
        val user = users[position]
        holder.bind(user)
    }

    class TeamHolder(private val binding: TeamItemBinding, private val context: Context): RecyclerView.ViewHolder(binding.root) {

        companion object {
            const val USER = "user"
        }

        fun bind(user: User) {
            binding.imageUrl = user.profileImage
            binding.name = user.name
            binding.role = user.position
            binding.clickListener = View.OnClickListener {
                context.openActivity(DetailActivity::class.java) {
                    putParcelable(USER, user)
                }
            }
            binding.executePendingBindings()
        }
    }
}