package com.jirawatpoo.oxforddictpicture.main.mapper

import com.jirawatpoo.domain.model.DataDictDomain
import com.jirawatpoo.oxforddictpicture.main.model.DataDictModel

class MainPresentMapper:Mapper<DataDictModel,DataDictDomain> {
    override fun mapToView(type: DataDictDomain): DataDictModel
     = DataDictModel(type.id,type.title)
}