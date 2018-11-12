package com.jirawatpoo.oxforddictpicture.injection

import android.app.Application
import com.jirawatpoo.oxforddictpicture.MainApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [AndroidSupportInjectionModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application):Builder

        fun build():AppComponent
    }

    fun inject(app:MainApplication)
}