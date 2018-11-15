package com.jirawatpoo.oxforddictpicture.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.jirawatpoo.oxforddictpicture.main.model.DataDictModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val pagingSource:MainDataSourceFactory
):ViewModel() {

    private val pagedList = LivePagedListBuilder(pagingSource,10).build()
    private val stateLoading =  Transformations.switchMap(pagingSource.sourceLiveData){ it.networkState }

    fun getListData():LiveData<PagedList<DataDictModel>> = pagedList

}