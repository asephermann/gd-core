package com.greatdayhr.core

import me.jessyan.retrofiturlmanager.RetrofitUrlManager

object RetrofitUrl {
    fun set(baseUrl: String?) {
        RetrofitUrlManager.getInstance().setGlobalDomain(baseUrl)
    }
}