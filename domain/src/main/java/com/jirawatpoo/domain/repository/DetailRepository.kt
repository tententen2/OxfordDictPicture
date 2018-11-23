package com.jirawatpoo.domain.repository

import com.jirawatpoo.domain.model.DataDictDetailPresent
import io.reactivex.Single

interface DetailRepository {

    fun getDetailDict(query:String):Single<DataDictDetailPresent>
}