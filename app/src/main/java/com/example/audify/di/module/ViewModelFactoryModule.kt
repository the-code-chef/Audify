package com.example.audify.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.audify.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {

    @Binds
    fun bindViewModelFactory(factoryModule: ViewModelProviderFactory): ViewModelProvider.Factory
}