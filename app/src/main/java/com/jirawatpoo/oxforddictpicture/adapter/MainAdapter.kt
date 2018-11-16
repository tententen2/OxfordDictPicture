package com.jirawatpoo.oxforddictpicture.adapter

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jirawatpoo.oxforddictpicture.R
import com.jirawatpoo.oxforddictpicture.main.model.DataDictModel
import javax.inject.Inject

class MainAdapter @Inject constructor() : PagedListAdapter<DataDictModel, MainViewHolder>(DiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder =
        MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_list_main, parent, false))

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) = holder.bind(getItem(position)?.title ?: "")

}

class DiffUtil : DiffUtil.ItemCallback<DataDictModel>() {
    override fun areItemsTheSame(oldItemPosition: DataDictModel, newItemPosition: DataDictModel): Boolean {
        return oldItemPosition.title == newItemPosition.title
    }

    override fun areContentsTheSame(oldItemPosition: DataDictModel, newItemPosition: DataDictModel): Boolean {
        return oldItemPosition.title == newItemPosition.title
    }

}

