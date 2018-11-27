package com.jirawatpoo.oxforddictpicture.main.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.jirawatpoo.domain.interactor.detailpage.GetDictDetail
import com.jirawatpoo.domain.model.GroupDataDetail
import com.jirawatpoo.oxforddictpicture.main.mapper.DetailPresentMapper
import com.jirawatpoo.oxforddictpicture.main.mapper.ImagePresentMapper
import com.jirawatpoo.oxforddictpicture.main.model.DisplayDetailData
import com.jirawatpoo.oxforddictpicture.main.model.DisplayImageData
import com.jirawatpoo.oxforddictpicture.main.state.Network
import com.jirawatpoo.oxforddictpicture.main.state.NetworkLoad
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class DetailDictViewModel @Inject constructor(
        private val getDictDetail:GetDictDetail,
        private val mapperDetail:DetailPresentMapper,
        private val mapperImage:ImagePresentMapper
):ViewModel() {

    val detailData:MutableLiveData<DisplayDetailData> = MutableLiveData()
    val imageData:MutableLiveData<DisplayImageData> = MutableLiveData()
    val stateLoad:MutableLiveData<NetworkLoad> = MutableLiveData()


    fun executeData(query:String){
        stateLoad.value = NetworkLoad.Loading()

        getDictDetail.execute(DictDetailSubsciber(),query)
    }


    inner class DictDetailSubsciber:DisposableSingleObserver<GroupDataDetail>(){
        override fun onSuccess(t: GroupDataDetail) {
            stateLoad.value = NetworkLoad.Loaded()
            detailData.value = mapperDetail.mapToView(t)
            imageData.value = mapperImage.mapToView(t)
        }

        override fun onError(e: Throwable) {
            stateLoad.value = NetworkLoad.LoadError(e.localizedMessage)
        }

    }

}