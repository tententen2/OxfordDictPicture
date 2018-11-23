package com.jirawatpoo.oxforddictpicture.main.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.jirawatpoo.domain.interactor.detailpage.GetDictDetail
import com.jirawatpoo.domain.model.DataDictDetailPresent
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.subscribers.DisposableSubscriber
import javax.inject.Inject

class DetailDictViewModel @Inject constructor(
        private val getDictDetail:GetDictDetail
):ViewModel() {

    val detailData:MutableLiveData<DataDictDetailPresent> = MutableLiveData()

    fun executeData(query:String){
        getDictDetail.execute(DictDetailSubsciber(),query)
    }


    inner class DictDetailSubsciber:DisposableSingleObserver<DataDictDetailPresent>(){
        override fun onError(e: Throwable) {

        }

        override fun onSuccess(t: DataDictDetailPresent) {
            detailData.value = t
        }

    }

}