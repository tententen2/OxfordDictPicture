package com.jirawatpoo.oxforddictpicture

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MainApplication:Application() {
//    @Inject lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
//
//    override fun activityInjector(): AndroidInjector<Activity>  = activityDispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
//        DaggerAppComponent.builder().application(this).build().inject(this)
    }
}