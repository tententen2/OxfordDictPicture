package com.jirawatpoo.cache

import com.jirawatpoo.data.repository.detaildict.DetailDictCache
import javax.inject.Inject

class DetailDictCacheImp @Inject constructor() : DetailDictCache {
    override fun isCache(): Boolean {
        return false
    }
}