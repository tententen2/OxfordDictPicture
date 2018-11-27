package com.jirawatpoo.oxforddictpicture.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.jirawatpoo.oxforddictpicture.R
import com.jirawatpoo.oxforddictpicture.main.model.InsideDetailData
import javax.inject.Inject

class DetailDataAdapter @Inject constructor():RecyclerView.Adapter<DetailDataViewHolder>() {

    private var list = arrayListOf<InsideDetailData>()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): DetailDataViewHolder =
        DetailDataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_detail_data,null))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: DetailDataViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun updateList(list:ArrayList<InsideDetailData>){
        this.list = list
        notifyDataSetChanged()
    }
}

class DetailDataViewHolder(view:View) : RecyclerView.ViewHolder(view){

    private val titleText:TextView = view.findViewById(R.id.subject_text)

    private val descText:TextView = view.findViewById(R.id.desc_text)

    fun bind(data : InsideDetailData){
        titleText.text = data.lexicalCategory
        descText.text = data.definition
    }
}