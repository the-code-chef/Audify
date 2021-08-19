package com.example.audify.di.module

import android.app.Application
import com.example.audify.data.local.AudifyDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AudifyDatabaseModule  {

    @Singleton
    @Provides
    fun provideDatabase(application: Application) = AudifyDatabase.getInstance(application)

    @Singleton
    @Provides
    fun provideSongsDao(database: AudifyDatabase) = database.getSongsDao()
}