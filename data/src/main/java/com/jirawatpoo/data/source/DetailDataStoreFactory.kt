package com.jirawatpoo.data.source

import com.jirawatpoo.data.repository.detaildict.DetailDictCache
import com.jirawatpoo.data.repository.detaildict.DetailDictStore
import io.reactivex.Completable
import javax.inject.Inject

class DetailDataStoreFactory @Inject constructor(
    private val bufferroCache:DetailDictCache,
    private val remote:DetailDataStoreRemote,
    private val dataBase:DetailDataCacheStore
) {
    fun saveData() : Completable = dataBase.saveDetailDict()

    fun retrieveDetailData():DetailDictStore{
        return if(bufferroCache.isCache()){
            retrieveCacheDataStore()
        }else{
            retrieveRemoteDataStore()
        }
    }
    /**
     * Return an instance of the Cache Data Store
     */
    private fun retrieveCacheDataStore(): DetailDictStore {
        return dataBase
    }

    /**
     * Return an instance of the Remote Data Store
     */
    private fun retrieveRemoteDataStore(): DetailDictStore {
        return remote
    }


}