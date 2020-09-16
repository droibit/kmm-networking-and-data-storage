package com.github.droibit.sample.kmmapp.androidApp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.droibit.sample.kmmapp.shared.entity.RocketLaunch

class LaunchesRvAdapter() :
    ListAdapter<RocketLaunch, LaunchViewHolder>(
        ITEM_CALLBACK
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return inflater.inflate(R.layout.item_launch, parent, false)
            .run(::LaunchViewHolder)
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    companion object {
        private val ITEM_CALLBACK = object : DiffUtil.ItemCallback<RocketLaunch>() {
            override fun areItemsTheSame(oldItem: RocketLaunch, newItem: RocketLaunch): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: RocketLaunch, newItem: RocketLaunch): Boolean {
                return oldItem == newItem
            }
        }
    }
}

class LaunchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val missionNameTextView = itemView.findViewById<TextView>(R.id.missionName)
    private val launchYearTextView = itemView.findViewById<TextView>(R.id.launchYear)
    private val launchSuccessTextView = itemView.findViewById<TextView>(R.id.launchSuccess)
    private val missionDetailsTextView = itemView.findViewById<TextView>(R.id.details)

    fun bindData(launch: RocketLaunch) {
        val ctx = itemView.context
        missionNameTextView.text = ctx.getString(R.string.mission_name_field, launch.missionName)
        launchYearTextView.text = ctx.getString(R.string.launch_year_field, launch.launchYear.toString())
        missionDetailsTextView.text = ctx.getString(R.string.details_field, launch.details ?: "")
        val launchSuccess = launch.launchSuccess
        if (launchSuccess != null ) {
            if (launchSuccess) {
                launchSuccessTextView.text = ctx.getString(R.string.successful)
                launchSuccessTextView.setTextColor((ContextCompat.getColor(itemView.context, R.color.colorSuccessful)))
            } else {
                launchSuccessTextView.text = ctx.getString(R.string.unsuccessful)
                launchSuccessTextView.setTextColor((ContextCompat.getColor(itemView.context, R.color.colorUnsuccessful)))
            }
        } else {
            launchSuccessTextView.text = ctx.getString(R.string.no_data)
            launchSuccessTextView.setTextColor((ContextCompat.getColor(itemView.context, R.color.colorNoData)))
        }
    }
}