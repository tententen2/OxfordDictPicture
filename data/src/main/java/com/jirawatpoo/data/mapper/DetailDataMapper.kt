package com.jirawatpoo.data.mapper

import com.google.gson.Gson
import com.jirawatpoo.data.model.DataDictDetailData
import com.jirawatpoo.domain.model.DataDictDetailPresent
import javax.inject.Inject

open class DetailDataMapper @Inject constructor(): Mapper<DataDictDetailPresent, DataDictDetailData> {

    override fun mapToEntity(type: DataDictDetailData): DataDictDetailPresent {
        val raw = Gson().toJson(type)
        return Gson().fromJson(raw, DataDictDetailPresent::class.java)
    }

    override fun mapFromEntity(type: DataDictDetailPresent): DataDictDetailData {
        val raw = Gson().toJson(type)
        return Gson().fromJson(raw,DataDictDetailData::class.java)
    }
}