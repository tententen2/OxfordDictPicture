package com.jirawatpoo.data

import com.jirawatpoo.data.mapper.DetailDataMapper
import com.jirawatpoo.data.source.DetailDataCacheStore
import com.jirawatpoo.data.source.DetailDataStoreFactory
import com.jirawatpoo.domain.model.DataDictDetailPresent
import com.jirawatpoo.domain.repository.DetailRepository
import io.reactivex.Single
import javax.inject.Inject

class DictDetailRepository @Inject constructor(
    private val mapper:DetailDataMapper,
    private val factory:DetailDataStoreFactory
):DetailRepository {

    override fun getDetailDict(query: String): Single<DataDictDetailPresent> {
        val dataStore = factory.retrieveDetailData()
        return dataStore.getDatailDict(query)
            .flatMap {
                if(dataStore is DetailDataCacheStore){
                    Single.just(mapper.mapToEntity(it))
                }else{
                    factory.saveData().toSingle{ mapper.mapToEntity(it) }
                }
            }

    }
}