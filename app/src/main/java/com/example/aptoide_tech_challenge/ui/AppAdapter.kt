package com.example.aptoide_tech_challenge.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aptoide_tech_challenge.data.entities.Model
import com.example.aptoide_tech_challenge.databinding.AppRowBinding

class AppAdapter () :
    ListAdapter<Model, AppAdapter.MyViewHolderApp>(CategoryItemDiffCallback()) {


    class MyViewHolderApp(val appRowBinding: AppRowBinding) :
        RecyclerView.ViewHolder(appRowBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderApp {
        val view = LayoutInflater.from(parent.context)
        val binding = AppRowBinding.inflate(view, parent, false)
        return MyViewHolderApp(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolderApp, position: Int) {
        val appList = getItem(position)

        holder.appRowBinding.textView.text = appList.name

        Glide.with(holder.itemView.context)
            .load(appList.graphic)
            .into(holder.appRowBinding.imageView)

    }
}

class CategoryItemDiffCallback : DiffUtil.ItemCallback<Model>() {
    override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean =
        oldItem == newItem
}
