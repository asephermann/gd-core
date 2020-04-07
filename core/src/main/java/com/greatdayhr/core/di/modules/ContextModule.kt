package com.greatdayhr.core.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ContextModule(private val app: Application) {
    @Provides
    @Singleton
    fun application(): Application = app

    @Provides
    @Singleton
    fun context(): Context = app.applicationContext
}