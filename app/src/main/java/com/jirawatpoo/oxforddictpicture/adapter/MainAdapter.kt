package com.jirawatpoo.oxforddictpicture.adapter

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jirawatpoo.oxforddictpicture.R

class MainAdapter:ListAdapter<DataDict,MainViewHolder>(DiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder
      = MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_list_main,parent,false))

    override fun onBindViewHolder(holder: MainViewHolder, position: Int)
      = holder.bind(getItem(position).title)

    override fun submitList(list: MutableList<DataDict>?) {
        super.submitList(if (list != null) ArrayList(list) else null)
    }
}

class DiffCallBack :DiffUtil.ItemCallback<DataDict>(){
    override fun areItemsTheSame(oldItemPosition: DataDict, newItemPosition: DataDict): Boolean = oldItemPosition.id == newItemPosition.id

    override fun areContentsTheSame(oldItemPosition: DataDict, newItemPosition: DataDict): Boolean = oldItemPosition.title == newItemPosition.title
}

data class DataDict(
    var id:Int = 0,
    var title:String = ""
)