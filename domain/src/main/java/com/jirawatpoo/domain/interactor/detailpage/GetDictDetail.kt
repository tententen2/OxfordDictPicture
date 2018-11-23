package com.jirawatpoo.domain.interactor.detailpage

import com.jirawatpoo.domain.executor.PostExecutionThread
import com.jirawatpoo.domain.executor.ThreadExecutor
import com.jirawatpoo.domain.interactor.SingleUseCase
import com.jirawatpoo.domain.model.DataDictDetailPresent
import com.jirawatpoo.domain.model.GroupDataDetail
import com.jirawatpoo.domain.repository.DetailRepository
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import javax.inject.Inject

class GetDictDetail @Inject constructor(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val repository: DetailRepository
):SingleUseCase<GroupDataDetail,String>(threadExecutor,postExecutionThread) {

    override fun buildUseCaseObservable(params: String): Single<GroupDataDetail> =
        Single.zip(repository.getDetailDict(params),repository.getDetailImage(params), BiFunction { t1, t2 ->
            GroupDataDetail(t1,t2)
        })
}