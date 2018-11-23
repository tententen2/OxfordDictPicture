package com.jirawatpoo.domain.repository

import com.jirawatpoo.domain.model.DataDictDetailPresent
import com.jirawatpoo.domain.model.DataDictImagePresent
import io.reactivex.Single

interface DetailRepository {

    fun getDetailDict(query:String):Single<DataDictDetailPresent>

    fun getDetailImage(query: String):Single<DataDictImagePresent>
}