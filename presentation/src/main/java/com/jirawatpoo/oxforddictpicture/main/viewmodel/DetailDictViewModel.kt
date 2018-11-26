package com.jirawatpoo.oxforddictpicture.main.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.jirawatpoo.domain.interactor.detailpage.GetDictDetail
import com.jirawatpoo.domain.model.DataDictDetailPresent
import com.jirawatpoo.domain.model.GroupDataDetail
import com.jirawatpoo.oxforddictpicture.main.mapper.DetailPresentMapper
import com.jirawatpoo.oxforddictpicture.main.mapper.ImagePresentMapper
import com.jirawatpoo.oxforddictpicture.main.model.DisplayDetailData
import com.jirawatpoo.oxforddictpicture.main.model.DisplayImageData
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.subscribers.DisposableSubscriber
import javax.inject.Inject

class DetailDictViewModel @Inject constructor(
        private val getDictDetail:GetDictDetail,
        private val mapperDetail:DetailPresentMapper,
        private val mapperImage:ImagePresentMapper
):ViewModel() {

    val detailData:MutableLiveData<DisplayDetailData> = MutableLiveData()
    val imageData:MutableLiveData<DisplayImageData> = MutableLiveData()

    fun executeData(query:String){
        getDictDetail.execute(DictDetailSubsciber(),query)
    }


    inner class DictDetailSubsciber:DisposableSingleObserver<GroupDataDetail>(){
        override fun onSuccess(t: GroupDataDetail) {
            detailData.value = mapperDetail.mapToView(t)
            imageData.value = mapperImage.mapToView(t)
        }

        override fun onError(e: Throwable) {
        }

    }

}