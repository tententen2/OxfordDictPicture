package com.jirawatpoo.remote

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class HttpInterCeptor : Interceptor {

    private val appId = "app_id"
    private val appKey = "app_key"

    override fun intercept(chain: Interceptor.Chain): Response {
        val oldRequest = chain.request()
        val request = oldRequest.newBuilder()
            .addHeader(appId,EndPoint.appIdValue)
            .addHeader(appKey,EndPoint.appKeyValue)
            .build()
        return chain.proceed(request)
    }
}

class NoInternetExcaption: IOException()
