package com.jirawatpoo.remote

import android.content.Context
import android.support.annotation.RawRes
import com.google.gson.Gson
import com.jirawatpoo.data.model.DataDictData
import com.jirawatpoo.data.repository.main.MainRemote
import io.reactivex.Flowable
import javax.inject.Inject

class MainRemoteImpl @Inject constructor(
    private val context: Context
):MainRemote {

    @RawRes private val resourceId:Int = R.raw.oxford_3000

    override fun getMainDataList(page: Int, query: String): Flowable<List<DataDictData>>
         = Flowable.fromCallable {
            context.jsonToClass<List<String>>(resourceId)
        }.flatMap {
        val dataFilter = it.filter {
            it.contains(query)
        }
        val item = page*100
        val first = item-100
        val last = if(item > dataFilter.size) dataFilter.size else item
        if(first > dataFilter.size){
            Flowable.fromCallable {
                listOf<String>()
            }
        }else{
            Flowable.fromCallable {
                dataFilter.subList(first,last)
            }
        }

        }.map {
         it.map {
             DataDictData(1,it)
         }
    }
}

inline fun <reified T> Context.jsonToClass(@RawRes resourceId: Int): T =
    Gson().fromJson(resources.openRawResource(resourceId).bufferedReader().use { it.readText() }, T::class.java)