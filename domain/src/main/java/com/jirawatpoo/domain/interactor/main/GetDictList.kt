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
):FlowableUseCase<List<DataDictDomain>,GetListParam>(threadExeutor,postExecutionThread) {

    override fun buildUseCaseObservable(params: GetListParam?): Flowable<List<DataDictDomain>>
            = repository.getDictList(params?.page ?: 0,params?.query ?: "")

}

data class GetListParam(
    val page:Int,
    val query:String
)