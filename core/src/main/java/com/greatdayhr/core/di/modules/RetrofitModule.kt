package com.greatdayhr.core.di.modules

import com.google.gson.GsonBuilder
import com.greatdayhr.core.HttpHeaderInterceptor
import com.greatdayhr.core.ResponseHandler
import dagger.Module
import dagger.Provides
import com.me.retrofiturlmanager.RetrofitUrlManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module()
class RetrofitModule {
    @Provides
    @Singleton
    fun httpClient(
        logInterceptor: HttpLoggingInterceptor,
        headerInterceptor: HttpHeaderInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
        builder.connectTimeout(10, TimeUnit.SECONDS)
        builder.writeTimeout(10, TimeUnit.SECONDS)
        builder.readTimeout(30, TimeUnit.SECONDS)
        builder.addInterceptor(headerInterceptor)
        builder.addInterceptor(logInterceptor)
        val builderManager = RetrofitUrlManager.getInstance().with(builder)
        return builderManager.build()
    }

    @Provides
    @Singleton
    fun retrofit(client: OkHttpClient): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl("https://api.com")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun responseHandler(retrofit: Retrofit) = ResponseHandler(retrofit)
}