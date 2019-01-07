package com.jirawatpoo.oxforddictpicture.adapter

import android.arch.paging.PagedListAdapter
import android.graphics.Color
import android.support.v7.util.DiffUtil
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jirawatpoo.oxforddictpicture.R
import com.jirawatpoo.oxforddictpicture.main.model.DataDictModel
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView
import javax.inject.Inject

class MainAdapter @Inject constructor() : PagedListAdapter<DataDictModel, MainViewHolder>(DiffUtil()),FastScrollRecyclerView.SectionedAdapter {

    override fun getSectionName(position: Int): String {
        val item = getItem(position)?.title ?: ""
        return item.subSequence(0,1).toString()
    }

    open var listner:Listner? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder =
        MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_list_main, parent, false),listner)

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = getItem(position) ?: return
        if(position%2 == 0)
            holder.bind(item.title,R.color.colorWhite)
        else
            holder.bind(item.title,R.color.colorWhiteDim)
    }

}

interface Listner{
    fun onItemClick(position: String)
}

class DiffUtil : DiffUtil.ItemCallback<DataDictModel>() {
    override fun areItemsTheSame(oldItemPosition: DataDictModel, newItemPosition: DataDictModel): Boolean {
        Log.d("dkosakodskao","areItemsTheSame")
        return oldItemPosition.title == newItemPosition.title
    }

    override fun areContentsTheSame(oldItemPosition: DataDictModel, newItemPosition: DataDictModel): Boolean {
        Log.d("dkosakodskao","areContentsTheSame")
        return oldItemPosition.title == newItemPosition.title
    }

}

