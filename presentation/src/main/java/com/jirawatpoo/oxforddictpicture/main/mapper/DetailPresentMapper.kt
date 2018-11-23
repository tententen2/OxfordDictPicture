package com.jirawatpoo.oxforddictpicture.main.mapper

import com.jirawatpoo.domain.model.GroupDataDetail
import com.jirawatpoo.oxforddictpicture.main.model.DisplayDetailData
import com.jirawatpoo.oxforddictpicture.main.model.InsideDetailData
import javax.inject.Inject

class DetailPresentMapper @Inject constructor() : Mapper<DisplayDetailData, GroupDataDetail> {
    override fun mapToView(type: GroupDataDetail): DisplayDetailData {
        val list: ArrayList<InsideDetailData> = arrayListOf()
        val listLexical = type.detailData.results.firstOrNull()?.lexicalEntries
        listLexical?.let {
            it.forEach {
                val pronunciation = it.pronunciations?.let {
                    it.firstOrNull()?.audioFile
                } ?: run { "" }

                val definition = it.entries?.let {
                    it.firstOrNull()?.senses?.firstOrNull()?.definitions?.firstOrNull()
                } ?: run { "" }


                var insideData = InsideDetailData(
                    pronunciation = pronunciation,
                    definition = definition,
                    lexicalCategory = it.lexicalCategory
                )
                list.add(insideData)
            }
        }
        return DisplayDetailData(list)
    }
}