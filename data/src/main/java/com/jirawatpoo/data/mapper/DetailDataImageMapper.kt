package com.jirawatpoo.data.mapper

import com.google.gson.Gson
import com.jirawatpoo.data.model.DataDictImageData
import com.jirawatpoo.domain.model.DataDictImagePresent
import javax.inject.Inject

class DetailDataImageMapper @Inject constructor():Mapper<DataDictImageData,DataDictImagePresent> {
    override fun mapFromEntity(type: DataDictImageData): DataDictImagePresent {
        val raw = Gson().toJson(type)
        return Gson().fromJson(raw,DataDictImagePresent::class.java)
    }

    override fun mapToEntity(type: DataDictImagePresent): DataDictImageData {
        val raw = Gson().toJson(type)
        return Gson().fromJson(raw,DataDictImageData::class.java)
    }
}