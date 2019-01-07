package com.jirawatpoo.data.mapper

import com.jirawatpoo.data.factory.DetailDataImageFactory
import com.jirawatpoo.data.model.DataDictImageData
import com.jirawatpoo.domain.model.DataDictImagePresent
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.assertEquals

@RunWith(MockitoJUnitRunner::class)
class DetailDataImageMapperTest {

    private lateinit var detailDataImageMapper:DetailDataImageMapper

    @Before
    fun setUp(){
        detailDataImageMapper = DetailDataImageMapper()
    }

    @Test
    fun mapFromEntity(){
        val makeDataDictImageData = DetailDataImageFactory.makeDataDictImageData()
        val dataDictMapper = detailDataImageMapper.mapFromEntity(makeDataDictImageData)
        assertDataDict(makeDataDictImageData,dataDictMapper)
    }

    @Test
    fun mapToEntity(){
        val makeDataDictPresent = DetailDataImageFactory.makeDataDictImagePresent()
        val dataDictMapper = detailDataImageMapper.mapToEntity(makeDataDictPresent)
        assertDataDict(dataDictMapper,makeDataDictPresent)
    }

    private fun assertDataDict(dataDictImage:DataDictImageData,dataDictImagePresent: DataDictImagePresent){
        assertEquals(dataDictImage.status,dataDictImagePresent.status)
        assertEquals(dataDictImage.data.cache.key,dataDictImagePresent.data.cache.key)
    }
}