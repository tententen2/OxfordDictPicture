package com.jirawatpoo.remote.service

import com.jirawatpoo.remote.model.DataDictImage
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface DetailImageService {
    @GET("api/search/images")
    fun getdetailImage(
        @Query("q") query:String,
        @Query("t") t:String = "images",
        @Query("count") count:String = "5",
        @Query("safesearch") safe:String = "1",
        @Query("locale") locale:String = "en_US",
        @Query("uiv") uiv:String = "4"
    ):Single<DataDictImage>
}