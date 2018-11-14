package com.jirawatpoo.domain.interactor.main

import com.jirawatpoo.domain.executor.PostExecutionThread
import com.jirawatpoo.domain.executor.ThreadExecutor
import com.jirawatpoo.domain.interactor.FlowableUseCase
import com.jirawatpoo.domain.model.DataDict
import io.reactivex.Flowable
import io.reactivex.internal.operators.flowable.FlowableUsing
import javax.inject.Inject

class GetDictList @Inject constructor(
    threadExeutor:ThreadExecutor,
    postExecutionThread: PostExecutionThread
):FlowableUseCase<DataDict,Int>(threadExeutor,postExecutionThread) {
    override fun buildUseCaseObservable(params: Int?): Flowable<DataDict>
            = Flowable.just(DataDict())

}