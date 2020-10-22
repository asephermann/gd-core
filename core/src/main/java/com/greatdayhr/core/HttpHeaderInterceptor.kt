package com.greatdayhr.core

import android.content.SharedPreferences
import com.greatdayhr.core.extension.get
import okhttp3.Interceptor

class HttpHeaderInterceptor(private val preferences: SharedPreferences) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        var request = chain.request()
        if (preferences.get("token") === null) {
            return chain.proceed(request)
        }
        request = request.newBuilder()
            .addHeader("Authorization", "${preferences.get("token")}")
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .build()
        return chain.proceed(request)
    }
}