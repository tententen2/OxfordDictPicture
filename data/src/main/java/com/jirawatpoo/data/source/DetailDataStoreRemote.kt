package com.jirawatpoo.data.source

import com.jirawatpoo.data.model.DataDictDetailData
import com.jirawatpoo.data.repository.detaildict.DetailDictRemote
import com.jirawatpoo.data.repository.detaildict.DetailDictStore
import io.reactivex.Completable
import io.reactivex.Single
import java.lang.UnsupportedOperationException
import javax.inject.Inject

class DetailDataStoreRemote @Inject constructor(
    private val detailRemote:DetailDictRemote
):DetailDictStore {
    override fun clearDetailData(): Completable
            = throw UnsupportedOperationException("ClearDetailData Not found operation")

    override fun saveDetailDict(): Completable
            = throw UnsupportedOperationException("SaveDetailDict Not found operation")

    override fun getDatailDict(query: String): Single<DataDictDetailData>
            = detailRemote.getDetailDict(query)
}