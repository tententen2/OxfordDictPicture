package com.jirawatpoo.remote.mapper

import com.google.gson.Gson
import com.jirawatpoo.data.model.DataDictImageData
import com.jirawatpoo.remote.model.DataDictImage
import javax.inject.Inject

class DetailDictImageMapper @Inject constructor():EntityMapper<DataDictImage,DataDictImageData> {
    override fun mapFromRemote(type: DataDictImage): DataDictImageData {
        val raw = Gson().toJson(type)
        return Gson().fromJson(raw,DataDictImageData::class.java)
    }
}