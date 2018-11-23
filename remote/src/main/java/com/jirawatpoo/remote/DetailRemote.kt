package com.jirawatpoo.remote

import com.jirawatpoo.data.model.DataDictDetailData
import com.jirawatpoo.data.repository.detaildict.DetailDictRemote
import com.jirawatpoo.remote.mapper.DetailDictMapper
import io.reactivex.Single
import javax.inject.Inject

class DetailRemote @Inject constructor(
    private val service: DetailDictService,
    private val mapper: DetailDictMapper
) : DetailDictRemote {

    override fun getDetailDict(query: String): Single<DataDictDetailData> =
        service.getDetailDict(query).map { mapper.mapFromRemote(it) }

}