package com.jirawatpoo.data.source

import com.jirawatpoo.data.factory.DetailDataImageFactory
import com.jirawatpoo.data.model.DataDictImageData
import com.jirawatpoo.data.repository.detaildict.DetailDictRemote
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailDataStoreRemoteTest {
    private lateinit var detailDataStoreRemote: DetailDataStoreRemote

    @Mock
    private lateinit var detailDictRemote: DetailDictRemote

    @Before
    fun setUp(){
        detailDataStoreRemote = DetailDataStoreRemote(detailDictRemote)
    }

    @Test
    fun getDetailImage(){
        val data = DetailDataImageFactory.makeDataDictImageData()
        whenever(detailDictRemote.getDetailImage("")).thenReturn(Single.just(data))
        val observer = detailDataStoreRemote.getDetailImage("").test()
        observer.assertValue(data)
    }

    @Test
    fun getDatailDict(){
        val data = DetailDataImageFactory.makeDataDictDetailData()
        whenever(detailDictRemote.getDetailDict("")).thenReturn(Single.just(data))
        val observer = detailDataStoreRemote.getDatailDict("").test()
        observer.assertValue(data)
    }

}