package com.jirawatpoo.oxforddictpicture.injection.module

import com.jirawatpoo.cache.DetailDictCacheImp
import com.jirawatpoo.data.repository.detaildict.DetailDictCache
import dagger.Binds
import dagger.Module

@Module
abstract class CacheModule {

    @Binds
    abstract fun bindDetailDictCache(cache:DetailDictCacheImp): DetailDictCache
}