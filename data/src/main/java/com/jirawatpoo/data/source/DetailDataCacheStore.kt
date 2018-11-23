package com.jirawatpoo.data.source

import com.jirawatpoo.data.model.DataDictDetailData
import com.jirawatpoo.data.repository.detaildict.DetailDictStore
import io.reactivex.Completable
import io.reactivex.Single
import java.lang.Exception
import java.lang.UnsupportedOperationException
import javax.inject.Inject

class DetailDataCacheStore @Inject constructor():DetailDictStore {
    override fun clearDetailData(): Completable
            = throw UnsupportedOperationException("ClearDetailData Not found operation")

    override fun saveDetailDict(): Completable
            = throw UnsupportedOperationException("SaveDetailDict Not found operation")

    override fun getDatailDict(query: String): Single<DataDictDetailData>
            = throw Exception("kdsoakodkos")
}