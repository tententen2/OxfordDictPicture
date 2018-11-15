package com.jirawatpoo.oxforddictpicture.injection.module

import com.jirawatpoo.domain.executor.PostExecutionThread
import com.jirawatpoo.oxforddictpicture.UiThread
import com.jirawatpoo.oxforddictpicture.ui.MainActivity
import com.jirawatpoo.oxforddictpicture.ui.MainFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Module that provides all dependencies from the mobile-ui package/layer and injects all activities.
 */
@Module
abstract class UiModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @ContributesAndroidInjector(modules = [MainFragmentBinder::class])
    abstract fun contributeMainActivity(): MainActivity
}

@Module
abstract class MainFragmentBinder{

    @ContributesAndroidInjector
    abstract fun bindFragment():MainFragment
}