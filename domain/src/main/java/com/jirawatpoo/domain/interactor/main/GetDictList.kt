package com.jirawatpoo.domain.interactor.main

import com.jirawatpoo.domain.executor.PostExecutionThread
import com.jirawatpoo.domain.executor.ThreadExecutor
import com.jirawatpoo.domain.interactor.FlowableUseCase
import com.jirawatpoo.domain.model.DataDictDomain
import com.jirawatpoo.domain.repository.MainRepository
import io.reactivex.Flowable
import javax.inject.Inject

class GetDictList @Inject constructor(
    threadExeutor:ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val repository: MainRepository
):FlowableUseCase<List<DataDictDomain>,Int>(threadExeutor,postExecutionThread) {

    override fun buildUseCaseObservable(params: Int?): Flowable<List<DataDictDomain>>
            = repository.getDictList(params ?: 0)

}