package com.jirawatpoo.remote.mapper

import com.jirawatpoo.data.model.DataDictData
import com.jirawatpoo.remote.model.DataDictRemote

class DataDictMapper:EntityMapper<DataDictRemote,DataDictData> {
    override fun mapFromRemote(type: DataDictRemote): DataDictData
    = DataDictData(type.id,type.title)
}


