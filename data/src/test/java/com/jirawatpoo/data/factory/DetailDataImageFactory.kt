package com.jirawatpoo.data.factory

import com.jirawatpoo.data.model.*
import com.jirawatpoo.domain.model.DataDictImagePresent

class DetailDataImageFactory{

    companion object {
        fun makeDataDictImageData(): DataDictImageData
            = DataDictImageData(Data(Cache(1,1,1,"",""), ResultImage(arrayListOf())),"")

        fun makeDataDictImagePresent(): DataDictImagePresent
            = DataDictImagePresent(com.jirawatpoo.domain.model.Data(com.jirawatpoo.domain.model.Cache(1,1,1,"",""), com.jirawatpoo.domain.model.ResultImage(arrayListOf())),"")

        fun makeDataDictDetailData():DataDictDetailData
            = DataDictDetailData(com.jirawatpoo.data.model.Metadata(""), arrayListOf())
    }
}