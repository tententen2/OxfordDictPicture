package com.jirawatpoo.oxforddictpicture.injection.module

import com.jirawatpoo.data.repository.main.MainRemote
import com.jirawatpoo.remote.MainRemoteImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RemoteModule {

    @Binds
    abstract fun bindMainRemote(remote: MainRemoteImpl): MainRemote
}