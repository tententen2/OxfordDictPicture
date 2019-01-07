package com.jirawatpoo.data

import com.jirawatpoo.data.factory.DetailDataImageFactory
import com.jirawatpoo.data.mapper.DetailDataImageMapper
import com.jirawatpoo.data.mapper.DetailDataMapper
import com.jirawatpoo.data.source.DetailDataCacheStore
import com.jirawatpoo.data.source.DetailDataStoreFactory
import com.jirawatpoo.data.source.DetailDataStoreRemote
import com.jirawatpoo.domain.model.DataDictDetailPresent
import com.jirawatpoo.domain.model.DataDictImagePresent
import com.jirawatpoo.domain.model.Metadata
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Completable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DictDetailRepositoryTest {

    private lateinit var dictDetailRepository: DictDetailRepository

    @Mock
    private lateinit var mapper:DetailDataMapper
    @Mock
    private lateinit var mapperImage: DetailDataImageMapper
    @Mock
    private lateinit var factory: DetailDataStoreFactory
    @Mock
    private lateinit var remote: DetailDataStoreRemote
    @Mock
    private lateinit var dataBase:DetailDataCacheStore

    @Before
    fun setUp(){
        dictDetailRepository = DictDetailRepository(mapper,mapperImage,factory)
    }

    @Test
    fun getDetailDictFromRemote(){
        whenever(remote.getDatailDict("")).thenReturn(Single.just(DetailDataImageFactory.makeDataDictDetailData()))
        whenever(dataBase.saveDetailDict()).thenReturn(Completable.complete())

        whenever(factory.retrieveRemoteDataStore()).thenReturn(remote)
        whenever(factory.retrieveCacheDataStore()).thenReturn(dataBase)
        whenever(factory.retrieveDetailData(any())).thenReturn(remote)

        whenever(mapper.mapToEntity(any())).thenReturn(DataDictDetailPresent(com.jirawatpoo.domain.model.Metadata(""),
            arrayListOf()))

        val data = dictDetailRepository.getDetailDict("").test()
        data.assertComplete()
    }
}