package com.jirawatpoo.oxforddictpicture.injection.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.jirawatpoo.oxforddictpicture.main.viewmodel.MainViewModel
import com.jirawatpoo.oxforddictpicture.main.ViewModelFactory
import com.jirawatpoo.oxforddictpicture.main.viewmodel.DetailDictViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

/**
 * Annotation class to identify view models by classname.
 */
@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)

/**
 * Module that provides all dependencies from the presentation package/layer.
 */
@Module
abstract class PresentationModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel):ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(DetailDictViewModel::class)
    abstract fun bindDetailViewModel(viewModel: DetailDictViewModel):ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory):ViewModelProvider.Factory
}