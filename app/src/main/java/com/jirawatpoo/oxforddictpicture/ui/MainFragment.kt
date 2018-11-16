package com.jirawatpoo.oxforddictpicture.ui

import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import com.jirawatpoo.oxforddictpicture.R
import com.jirawatpoo.oxforddictpicture.adapter.MainAdapter
import com.jirawatpoo.oxforddictpicture.base.BaseFragment
import com.jirawatpoo.oxforddictpicture.main.MainViewModel
import com.jirawatpoo.oxforddictpicture.main.ViewModelFactory
import com.jirawatpoo.oxforddictpicture.main.model.DataDictModel
import com.jirawatpoo.oxforddictpicture.util.observe
import com.jirawatpoo.oxforddictpicture.util.setSupportActionbar
import kotlinx.android.synthetic.main.fragment_main.*
import java.lang.Exception
import javax.inject.Inject


class MainFragment :BaseFragment() {

    @Inject lateinit var mainAdapter:MainAdapter
    @Inject lateinit var viewModelFactory: ViewModelFactory
    lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = activity?.run {
            ViewModelProviders.of(this,viewModelFactory).get(MainViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        setUpObserver()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setSupportActionbar(toolbar)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }

    private fun setUpView() {
        rc_listWord.adapter = mainAdapter
        rc_listWord.layoutManager = GridLayoutManager(context,6)
        rc_listWord.addItemDecoration(DividerItemDecoration(context, HORIZONTAL))
    }

    private fun setUpObserver() {
        observe(viewModel.getListData()){
            mainAdapter.submitList(it)
        }
        observe(viewModel.stateLoading){
            Log.d("dksokdosakdkoa",it.toString())
        }
    }

    override val contentView: Int = R.layout.fragment_main

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.search,menu)
        val item = menu?.findItem(R.id.action_search)
        search_view.setMenuItem(item)
    }
}