package com.example.audify.di.module

import androidx.lifecycle.ViewModel
import com.example.audify.ui.main.SongViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.reflect.KClass

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)

@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)

@ExperimentalCoroutinesApi
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SongViewModel::class)
    abstract fun bindSongsViewModel(viewModel: SongViewModel): ViewModel
}