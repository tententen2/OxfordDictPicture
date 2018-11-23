package com.jirawatpoo.domain.interactor.detailpage

import com.jirawatpoo.domain.executor.PostExecutionThread
import com.jirawatpoo.domain.executor.ThreadExecutor
import com.jirawatpoo.domain.interactor.SingleUseCase
import com.jirawatpoo.domain.model.DataDictDetailPresent
import com.jirawatpoo.domain.repository.DetailRepository
import io.reactivex.Single
import javax.inject.Inject

class GetDictDetail @Inject constructor(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val repository: DetailRepository
):SingleUseCase<DataDictDetailPresent,String>(threadExecutor,postExecutionThread) {

    override fun buildUseCaseObservable(params: String): Single<DataDictDetailPresent>
        = repository.getDetailDict(params)
}