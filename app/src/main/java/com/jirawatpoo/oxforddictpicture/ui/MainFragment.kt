package com.jirawatpoo.oxforddictpicture.ui

import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import com.jirawatpoo.oxforddictpicture.R
import com.jirawatpoo.oxforddictpicture.adapter.MainAdapter
import com.jirawatpoo.oxforddictpicture.adapter.DataDict
import com.jirawatpoo.oxforddictpicture.base.BaseFragment
import com.jirawatpoo.oxforddictpicture.util.setSupportActionbar
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment :BaseFragment() {

    lateinit var mainAdapter:MainAdapter
    var muta:MutableList<DataDict> = mutableListOf()


    var kdosakod:String? = null

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setSupportActionbar(toolbar)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemDecor = DividerItemDecoration(context, HORIZONTAL)
        mainAdapter = MainAdapter()
        rc_listWord.adapter = mainAdapter
        rc_listWord.layoutManager = GridLayoutManager(context,4)
        rc_listWord.addItemDecoration(itemDecor)
        get()
        mainAdapter.submitList(muta)
        dkosakdo.setOnClickListener {
            get()
            muta.shuffle()
            mainAdapter.submitList(muta)
        }
    }

    fun get(){
        val a = (1..100000).shuffled().last()
        val b = (1..100000).shuffled().last()
        val c = (1..100000).shuffled().last()
        muta.addAll(listOf(DataDict(a,a.toString()),DataDict(b,b.toString()),DataDict(c,c.toString())))
    }

    override val contentView: Int = R.layout.fragment_main

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.search,menu)
        val item = menu?.findItem(R.id.action_search)
        search_view.setMenuItem(item)
    }
}