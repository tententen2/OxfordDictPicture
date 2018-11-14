package com.jirawatpoo.data

import com.jirawatpoo.data.repository.main.MainRemote
import com.jirawatpoo.domain.model.DataDict
import com.jirawatpoo.domain.repository.MainRepository
import io.reactivex.Flowable
import javax.inject.Inject

class MainDataRepository @Inject constructor(
    private val remote:MainRemote
):MainRepository {
    override fun getDictList(page: Int): Flowable<List<DataDict>>
            = remote.getMainDataList(page)
}