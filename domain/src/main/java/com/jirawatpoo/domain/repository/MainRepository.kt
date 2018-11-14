package com.jirawatpoo.domain.repository

import com.jirawatpoo.domain.model.DataDict
import io.reactivex.Flowable

interface MainRepository {

    fun getDictList(page:Int):Flowable<List<DataDict>>
}