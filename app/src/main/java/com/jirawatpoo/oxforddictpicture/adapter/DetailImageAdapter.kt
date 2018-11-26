package com.jirawatpoo.oxforddictpicture.adapter

import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.jirawatpoo.oxforddictpicture.R

class DetailImageAdapter : RecyclerView.Adapter<DetailImageViewHolder>() {
    private var list = listOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailImageViewHolder =
        DetailImageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_detail,parent,false))


    override fun getItemCount(): Int =
        list.size

    override fun onBindViewHolder(viewHolder: DetailImageViewHolder, position: Int) {
        val item = list[position]
        viewHolder.bind(item)
    }

    fun updateView(list:List<String>){
        this.list = list
        notifyDataSetChanged()
    }
}


class DetailImageViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private val image:ImageView = view.findViewById(R.id.vh_img)

    fun bind(url:String){
        Glide.with(itemView).load(url).into(image)
    }
}