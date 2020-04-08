package com.greatdayhr.core.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule(private val app: Context) {
    @Provides
    @Singleton
    fun context(): Context = app.applicationContext
}