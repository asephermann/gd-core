package com.greatdayhr.core.di

import android.content.SharedPreferences
import com.greatdayhr.core.ResponseHandler
import com.greatdayhr.core.di.modules.ContextModule
import com.greatdayhr.core.di.modules.HttpInterceptorModule
import com.greatdayhr.core.di.modules.RetrofitModule
import com.greatdayhr.core.di.modules.StorageModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Component(modules = [ContextModule::class, RetrofitModule::class, StorageModule::class, HttpInterceptorModule::class])
@Singleton
interface CoreComponent {
    fun getRetrofit(): Retrofit
    fun getSharedPreferences(): SharedPreferences
    fun getResponseHandler(): ResponseHandler
}