package com.jirawatpoo.oxforddictpicture.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.util.Log
import com.jirawatpoo.oxforddictpicture.main.model.DataDictModel
import com.jirawatpoo.oxforddictpicture.main.state.NetworkState
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val pagingSource:MainDataSourceFactory
):ViewModel() {

    val pagedList:LiveData<PagedList<DataDictModel>>
    val stateLoading:LiveData<NetworkState>

    init {
        Log.d("kdosakodkosa","news")
        pagedList = LivePagedListBuilder(pagingSource,10).build()
        stateLoading = Transformations.switchMap(pagingSource.sourceLiveData){ it.networkState }
    }

    fun getListData():LiveData<PagedList<DataDictModel>> = pagedList


}