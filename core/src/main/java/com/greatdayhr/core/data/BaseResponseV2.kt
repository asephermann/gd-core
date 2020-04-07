package com.greatdayhr.core.data

import com.google.gson.annotations.SerializedName

data class BaseResponseV2<T>(
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: T
)
