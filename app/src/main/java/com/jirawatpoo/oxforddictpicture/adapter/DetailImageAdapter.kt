package com.jirawatpoo.oxforddictpicture.adapter

import android.media.Image
import android.support.v4.view.PagerAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.jirawatpoo.oxforddictpicture.R

class DetailImageAdapter(private val imageList:List<String>) : PagerAdapter() {

    override fun isViewFromObject(view: View, obj: Any): Boolean = view == obj

    override fun getCount(): Int = imageList.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
       val linearLayout = LayoutInflater.from(container.context).inflate(R.layout.layout_item_detail,null)
       val image:ImageView = linearLayout.findViewById(R.id.vh_img)
        Glide.with(container.context).load(imageList[position]).into(image)
        container.addView(linearLayout)
        return linearLayout
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        val linearLayout:LinearLayout = obj as LinearLayout
        container.removeView(linearLayout)
    }
}