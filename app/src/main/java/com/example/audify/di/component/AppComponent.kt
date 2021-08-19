package com.example.audify.di.component

import android.app.Application
import com.example.audify.Audify
import com.example.audify.di.builder.ActivityBuilder
import com.example.audify.di.module.AudifyDatabaseModule
import com.example.audify.di.module.ViewModelFactoryModule
import com.example.audify.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AudifyDatabaseModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class,
        ActivityBuilder::class
    ]
)
interface AppComponent : AndroidInjector<Audify> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun create(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(app: Audify)
}