package com.jirawatpoo.remote

import com.jirawatpoo.remote.model.DataDictDetailRemote
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailDictService {

    @GET("api/v1/entries/en/{word}/regions=us")
    fun getDetailDict(
        @Path("word") word:String
    ) : Single<DataDictDetailRemote>
}