package com.greatdayhr.core

import com.me.retrofiturlmanager.RetrofitUrlManager
import okhttp3.OkHttpClient

object RetrofitUrl {
    fun set(baseUrl: String?) {
        RetrofitUrlManager.getInstance().setGlobalDomain(baseUrl)
    }

    fun with(builder: OkHttpClient.Builder): OkHttpClient.Builder {
        return RetrofitUrlManager.getInstance().with(builder)
    }
}