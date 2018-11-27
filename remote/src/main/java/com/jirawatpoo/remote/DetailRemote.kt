package com.jirawatpoo.remote

import com.jirawatpoo.data.model.DataDictDetailData
import com.jirawatpoo.data.model.DataDictImageData
import com.jirawatpoo.data.repository.detaildict.DetailDictRemote
import com.jirawatpoo.remote.mapper.DetailDictImageMapper
import com.jirawatpoo.remote.mapper.DetailDictMapper
import com.jirawatpoo.remote.service.DetailDictService
import com.jirawatpoo.remote.service.DetailImageService
import io.reactivex.Single
import javax.inject.Inject

class DetailRemote @Inject constructor(
    private val service: DetailDictService,
    private val serviceImage: DetailImageService,
    private val mapper: DetailDictMapper,
    private val mapperImage: DetailDictImageMapper
) : DetailDictRemote {

    override fun getDetailImage(query: String): Single<DataDictImageData> =
        serviceImage.getdetailImage(query).map { mapperImage.mapFromRemote(it) }

    override fun getDetailDict(query: String): Single<DataDictDetailData> =
        service.getDetailDict(query).map { mapper.mapFromRemote(it) }

}