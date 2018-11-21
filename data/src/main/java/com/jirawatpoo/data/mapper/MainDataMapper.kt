package com.jirawatpoo.data.mapper

import com.jirawatpoo.data.model.DataDictData
import com.jirawatpoo.domain.model.DataDictDomain
import javax.inject.Inject

class MainDataMapper @Inject constructor():Mapper<DataDictData,DataDictDomain> {
    override fun mapFromEntity(type: DataDictData): DataDictDomain
        = DataDictDomain(type.id,type.title)

    override fun mapToEntity(type: DataDictDomain): DataDictData
        = DataDictData(type.id,type.title)
}