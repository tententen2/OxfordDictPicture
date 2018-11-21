package com.jirawatpoo.oxforddictpicture.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.jirawatpoo.oxforddictpicture.R

class MainViewHolder(view:View,listner:Listner?):RecyclerView.ViewHolder(view) {

    private val textView:TextView = view.findViewById(R.id.tv_title)
    private val layout: LinearLayout = view.findViewById(R.id.layout_viewHolder)

    init {
        listner?.let {listner ->
            layout.setOnClickListener {
                listner.onItemClick(textView.text.toString())
            }
        }
    }

    fun bind(data:String,color:Int){
        textView.text = data
        layout.setBackgroundResource(color)
    }
}
