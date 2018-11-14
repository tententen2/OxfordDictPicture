package com.jirawatpoo.data.repository.main

import com.jirawatpoo.domain.model.DataDict
import io.reactivex.Flowable

interface MainRemote {

    fun getMainDataList(page:Int):Flowable<List<DataDict>>
}