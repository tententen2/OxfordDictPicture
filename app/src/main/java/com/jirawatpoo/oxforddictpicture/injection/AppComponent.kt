package com.jirawatpoo.oxforddictpicture.injection

import android.app.Application
import com.jirawatpoo.oxforddictpicture.MainApplication
import com.jirawatpoo.oxforddictpicture.injection.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApplicationModule::class,
    UiModule::class,
    PresentationModule::class,
    DataModule::class,
    RemoteModule::class,
    CacheModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application):Builder

        fun build():AppComponent
    }

    fun inject(app:MainApplication)
}