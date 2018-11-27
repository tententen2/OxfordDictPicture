package com.jirawatpoo.remote.mapper

import com.google.gson.Gson
import com.jirawatpoo.data.model.DataDictDetailData
import com.jirawatpoo.remote.model.DataDictDetailRemote
import javax.inject.Inject

class DetailDictMapper @Inject constructor():EntityMapper<DataDictDetailRemote,DataDictDetailData> {
    override fun mapFromRemote(type: DataDictDetailRemote): DataDictDetailData {
        val raw = Gson().toJson(type)
        return Gson().fromJson(raw,DataDictDetailData::class.java)
    }
}