package com.jirawatpoo.data.repository.detaildict

import com.jirawatpoo.data.model.DataDictDetailData
import com.jirawatpoo.data.model.DataDictImageData
import io.reactivex.Single

interface DetailDictRemote {

    fun getDetailDict(query:String):Single<DataDictDetailData>

    fun getDetailImage(query: String):Single<DataDictImageData>
}