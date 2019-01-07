package com.jirawatpoo.oxforddictpicture.main.viewmodel

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.jirawatpoo.domain.interactor.main.GetDictList
import com.jirawatpoo.oxforddictpicture.main.mapper.MainPresentMapper
import com.jirawatpoo.oxforddictpicture.main.paging.MainDataSourceFactory
import com.jirawatpoo.oxforddictpicture.main.model.DataDictModel
import com.jirawatpoo.oxforddictpicture.main.state.NetworkState
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val useCase: GetDictList,
    private val mapper: MainPresentMapper
):ViewModel() {

    private var pagedList:LiveData<PagedList<DataDictModel>>
    lateinit var stateLoading:LiveData<NetworkState>

    init {
        pagedList = searchData("")
    }

    private fun searchData(query:String):LiveData<PagedList<DataDictModel>>{
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(60)
            .setPageSize(20)
            .setPrefetchDistance(60)
            .build()

        val factory = MainDataSourceFactory(useCase,mapper,query)

        pagedList = LivePagedListBuilder(factory,config)
            .build()
        stateLoading = Transformations.switchMap(factory.sourceLiveData){ it.networkState }
        return pagedList
    }

    fun replaceSubscription(lifecycleOwner: LifecycleOwner,query:String){
        pagedList.removeObservers(lifecycleOwner)
        pagedList = searchData(query)
    }

    fun getListData():LiveData<PagedList<DataDictModel>> = pagedList

}