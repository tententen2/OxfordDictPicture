package com.jirawatpoo.oxforddictpicture.main.paging

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import com.jirawatpoo.domain.interactor.main.GetDictList
import com.jirawatpoo.oxforddictpicture.main.mapper.MainPresentMapper
import com.jirawatpoo.oxforddictpicture.main.model.DataDictModel
import javax.inject.Inject

class MainDataSourceFactory constructor(
    private val useCase: GetDictList,
    private val mapper: MainPresentMapper,
    private val query:String
):DataSource.Factory<Int, DataDictModel>() {

    val sourceLiveData = MutableLiveData<MainDataSource>()
    override fun create(): DataSource<Int, DataDictModel> {
        val dataSource = MainDataSource(useCase, mapper,query)
        sourceLiveData.postValue(dataSource)
        return dataSource
    }
}