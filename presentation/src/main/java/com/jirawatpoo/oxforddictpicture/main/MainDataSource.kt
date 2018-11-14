package com.jirawatpoo.oxforddictpicture.main

import android.arch.paging.PageKeyedDataSource
import com.jirawatpoo.oxforddictpicture.main.model.DataDict

class MainDataSource: PageKeyedDataSource<Int,DataDict>() {
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, DataDict>) {
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, DataDict>) {
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, DataDict>) {
    }
}