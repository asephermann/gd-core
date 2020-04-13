package com.greatdayhr.core.extension

import java.text.SimpleDateFormat
import java.util.*

fun Date.getStringTimeStampWithDate(): String {
    val dateFormat = SimpleDateFormat(
        "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
        Locale.getDefault()
    )
    dateFormat.timeZone = TimeZone.getTimeZone("GMT")
    return dateFormat.format(this)
}