package com.jirawatpoo.oxforddictpicture.main.paging

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PageKeyedDataSource
import android.util.Log
import com.jirawatpoo.domain.interactor.main.GetDictList
import com.jirawatpoo.domain.model.DataDictDomain
import com.jirawatpoo.oxforddictpicture.main.mapper.MainPresentMapper
import com.jirawatpoo.oxforddictpicture.main.model.DataDictModel
import com.jirawatpoo.oxforddictpicture.main.state.NetworkState
import io.reactivex.subscribers.DisposableSubscriber

class MainDataSource constructor(
    private val useCase:GetDictList,
    private val mapper:MainPresentMapper
): PageKeyedDataSource<Int,DataDictModel>() {

    val networkState: MutableLiveData<NetworkState> = MutableLiveData()


    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, DataDictModel>) {
        networkState.postValue(NetworkState.Loading)
        useCase.execute(object : DisposableSubscriber<List<DataDictDomain>>(){
            override fun onComplete() {
                networkState.postValue(NetworkState.Loaded)
            }

            override fun onNext(t: List<DataDictDomain>?) {
                t?.let {
                    callback.onResult(it.map { mapper.mapToView(it) },null,2)
                }
            }

            override fun onError(t: Throwable?) {
                networkState.postValue(NetworkState.LoadFail(t?.localizedMessage ?: ""))
            }

        },1)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, DataDictModel>) {
        networkState.postValue(NetworkState.Loading)
        useCase.execute(object : DisposableSubscriber<List<DataDictDomain>>(){
            override fun onComplete() {
                networkState.postValue(NetworkState.Loaded)
            }

            override fun onNext(t: List<DataDictDomain>?) {
                t?.let {
                    callback.onResult(it.map { mapper.mapToView(it) },params.key+1)
                }
            }

            override fun onError(t: Throwable?) {
                networkState.postValue(NetworkState.LoadFail(t?.localizedMessage ?: ""))
            }

        },params.key)

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, DataDictModel>) {
    }
}
