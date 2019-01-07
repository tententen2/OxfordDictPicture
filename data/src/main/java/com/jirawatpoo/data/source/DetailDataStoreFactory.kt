package com.jirawatpoo.data.source

import com.jirawatpoo.data.repository.detaildict.DetailDictCache
import com.jirawatpoo.data.repository.detaildict.DetailDictStore
import io.reactivex.Completable
import javax.inject.Inject

open class DetailDataStoreFactory @Inject constructor(
    private val bufferroCache:DetailDictCache,
    private val remote:DetailDataStoreRemote,
    private val dataBase:DetailDataCacheStore
) {
    fun saveData() : Completable = retrieveCacheDataStore().saveDetailDict()

    fun retrieveDetailData(isCache:Boolean = false):DetailDictStore{
        return if(isCache && bufferroCache.isCache()){
            retrieveCacheDataStore()
        }else{
            retrieveRemoteDataStore()
        }
    }
    /**
     * Return an instance of the Cache Data Store
     */
    open fun retrieveCacheDataStore(): DetailDictStore {
        return dataBase
    }

    /**
     * Return an instance of the Remote Data Store
     */
    open fun retrieveRemoteDataStore(): DetailDictStore {
        return remote
    }


}