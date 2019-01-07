package com.jirawatpoo.data.source

import com.jirawatpoo.data.repository.detaildict.DetailDictCache
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.lang.UnsupportedOperationException

@RunWith(MockitoJUnitRunner::class)
class DetailDataCacheStoreTest {

    private lateinit var detailDataCacheStore: DetailDataCacheStore

    @Mock
    private lateinit var cache:DetailDictCache

    @Before
    fun setUp(){
        detailDataCacheStore = DetailDataCacheStore(cache)
    }

    @Test(expected = UnsupportedOperationException::class)
    fun clearDetailImageData(){
        detailDataCacheStore.clearDetailImageData().test()
    }

    @Test
    fun saveDetailImageData(){
        val testObserver = detailDataCacheStore.saveDetailImageData().test()
        testObserver.assertComplete()
    }
}