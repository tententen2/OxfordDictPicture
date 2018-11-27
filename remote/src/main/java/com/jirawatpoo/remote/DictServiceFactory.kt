package com.jirawatpoo.remote

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jirawatpoo.remote.service.DetailDictService
import com.jirawatpoo.remote.service.DetailImageService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object DictServiceFactory {

    fun makeDetailDictService(isDebug: Boolean): DetailDictService {
        val okHttpClient = makeOkHttpClient(
            makeLoggingInterceptor(isDebug),HttpInterCeptor())
        return makeRetrofit(EndPoint.oxfordDict,okHttpClient,makeGson()).create(DetailDictService::class.java)
    }

    fun makeDetailImageService(isDebug: Boolean): DetailImageService {
        val okHttpClient = makeOkHttpClient(
            makeLoggingInterceptor(isDebug),HttpInterCeptor()
        )
        return makeRetrofit(EndPoint.oxfordImage,okHttpClient, makeGson()).create(DetailImageService::class.java)
    }

    private fun makeRetrofit(baseUrl:String,okHttpClient: OkHttpClient,gson:Gson):Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    private fun makeGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
    }


    private fun makeOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor,interCeptor:Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(interCeptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }


    private fun makeLoggingInterceptor(isDebug: Boolean): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (isDebug)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
        return logging
    }
}