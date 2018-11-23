package com.jirawatpoo.data.repository.detaildict

import com.jirawatpoo.data.model.DataDictDetailData
import io.reactivex.Single

interface DetailDictRemote {

    fun getDetailDict(query:String):Single<DataDictDetailData>
}