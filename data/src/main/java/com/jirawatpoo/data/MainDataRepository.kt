package com.jirawatpoo.data

import com.jirawatpoo.data.mapper.MainDataMapper
import com.jirawatpoo.data.repository.main.MainRemote
import com.jirawatpoo.domain.model.DataDictDomain
import com.jirawatpoo.domain.repository.MainRepository
import io.reactivex.Flowable
import javax.inject.Inject

class MainDataRepository @Inject constructor(
    private val remote:MainRemote,
    private val mapper:MainDataMapper
):MainRepository {
    override fun getDictList(page: Int): Flowable<List<DataDictDomain>> =
        remote.getMainDataList(page)
        .flatMap {
            Flowable.just(it.map { mapper.mapFromEntity(it) })
        }
}