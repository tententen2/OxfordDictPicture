package com.jirawatpoo.remote

import android.content.Context
import com.google.gson.Gson
import com.jirawatpoo.data.model.DataDictData
import com.jirawatpoo.data.repository.main.MainRemote
import io.reactivex.Flowable

class MainRemoteImpl constructor(
    private val context: Context
):MainRemote {

    override fun getMainDataList(page: Int): Flowable<List<DataDictData>>
         = Flowable.fromCallable {
            context.jsonToClass<List<String>>(R.raw.oxford_3000)
        }.flatMap {
            Flowable.fromCallable {
                it.subList(0,page*100)
            }
        }.map {
         it.map {
             DataDictData(1,it)
         }
    }

}



inline fun <reified T> Context.jsonToClass(resourceId: Int): T =
    Gson().fromJson(resources.openRawResource(resourceId).bufferedReader().use { it.readText() }, T::class.java)