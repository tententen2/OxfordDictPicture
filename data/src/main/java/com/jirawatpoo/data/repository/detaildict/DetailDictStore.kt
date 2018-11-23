package com.jirawatpoo.data.repository.detaildict

import com.jirawatpoo.data.model.DataDictDetailData
import com.jirawatpoo.data.model.DataDictImageData
import io.reactivex.Completable
import io.reactivex.Single

interface DetailDictStore {

    fun clearDetailData() : Completable

    fun saveDetailDict() : Completable

    fun getDatailDict(query:String) : Single<DataDictDetailData>

    fun clearDetailImageData() : Completable

    fun saveDetailImageData() : Completable

    fun getDetailImage(query:String) : Single<DataDictImageData>


}