package com.jirawatpoo.domain.repository

import com.jirawatpoo.domain.model.DataDictDomain
import io.reactivex.Flowable

interface MainRepository {

    fun getDictList(page:Int):Flowable<List<DataDictDomain>>
}