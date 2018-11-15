package com.jirawatpoo.oxforddictpicture.injection.module

import com.jirawatpoo.data.MainDataRepository
import com.jirawatpoo.data.executor.JobExecutor
import com.jirawatpoo.domain.executor.ThreadExecutor
import com.jirawatpoo.domain.repository.MainRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun bindMainRepository(repository: MainDataRepository): MainRepository

    @Binds
    abstract fun bindThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor
}