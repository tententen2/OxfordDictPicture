package com.jirawatpoo.data.repository.main

import com.jirawatpoo.data.model.DataDictData
import io.reactivex.Flowable

interface MainRemote {

    fun getMainDataList(page:Int,query:String):Flowable<List<DataDictData>>
}