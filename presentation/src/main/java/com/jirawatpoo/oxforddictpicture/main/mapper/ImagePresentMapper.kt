package com.jirawatpoo.oxforddictpicture.main.mapper

import com.jirawatpoo.domain.model.GroupDataDetail
import com.jirawatpoo.oxforddictpicture.main.model.DisplayImageData
import javax.inject.Inject

class ImagePresentMapper @Inject constructor(): Mapper<DisplayImageData, GroupDataDetail> {
    override fun mapToView(type: GroupDataDetail): DisplayImageData {
        val listImage : ArrayList<String> = arrayListOf()
        type.detailImage.data.result.items.forEach {
            listImage.add(it.media)
        }
        return DisplayImageData(listImage)
    }
}