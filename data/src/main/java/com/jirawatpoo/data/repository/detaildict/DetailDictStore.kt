package com.jirawatpoo.data.repository.detaildict

import com.jirawatpoo.data.model.DataDictDetailData
import io.reactivex.Completable
import io.reactivex.Single

interface DetailDictStore {

    fun clearDetailData() : Completable

    fun saveDetailDict() : Completable

    fun getDatailDict(query:String) : Single<DataDictDetailData>


}