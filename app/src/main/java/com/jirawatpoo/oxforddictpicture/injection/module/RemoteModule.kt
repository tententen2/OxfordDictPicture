package com.jirawatpoo.oxforddictpicture.injection.module

import com.jirawatpoo.data.repository.detaildict.DetailDictRemote
import com.jirawatpoo.data.repository.main.MainRemote
import com.jirawatpoo.remote.*
import com.jirawatpoo.remote.service.DetailDictService
import com.jirawatpoo.remote.service.DetailImageService
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RemoteModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideDetailDict(): DetailDictService {
            return DictServiceFactory.makeDetailDictService(BuildConfig.DEBUG)
        }

        @Provides
        @JvmStatic
        fun provideDetailImage(): DetailImageService {
            return DictServiceFactory.makeDetailImageService(BuildConfig.DEBUG)
        }
    }

    @Binds
    abstract fun bindMainRemote(remote: MainRemoteImpl): MainRemote

    @Binds
    abstract fun bindDetailDictRemote(remote: DetailRemote): DetailDictRemote
}