package com.jirawatpoo.oxforddictpicture.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.jirawatpoo.oxforddictpicture.R

class MainViewHolder(view:View):RecyclerView.ViewHolder(view) {

    private val textView:TextView = view.findViewById(R.id.tv_title)

    fun bind(data:String){
        textView.text = data
    }
}
