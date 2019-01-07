package com.jirawatpoo.data.source

import com.jirawatpoo.data.model.DataDictDetailData
import com.jirawatpoo.data.model.DataDictImageData
import com.jirawatpoo.data.repository.detaildict.DetailDictCache
import com.jirawatpoo.data.repository.detaildict.DetailDictStore
import io.reactivex.Completable
import io.reactivex.Single
import java.lang.Exception
import java.lang.UnsupportedOperationException
import javax.inject.Inject

open class DetailDataCacheStore @Inject constructor(
    private val cache: DetailDictCache
):DetailDictStore {
    override fun clearDetailImageData(): Completable {
        return throw UnsupportedOperationException("ClearDetailData Not found operation")
    }

    override fun saveDetailImageData(): Completable {
        return Completable.complete()
    }

    override fun getDetailImage(query: String): Single<DataDictImageData> {
        return throw UnsupportedOperationException("getDetailImage Not found operation")
    }

    override fun clearDetailData(): Completable
            = throw UnsupportedOperationException("clearDetailData Not found operation")

    override fun saveDetailDict(): Completable
            = Completable.complete()

    override fun getDatailDict(query: String): Single<DataDictDetailData>
            = throw Exception("kdsoakodkos")
}