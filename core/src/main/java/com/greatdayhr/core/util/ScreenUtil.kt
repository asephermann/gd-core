package com.greatdayhr.core.util

import android.content.Context
import android.content.ContextWrapper
import android.util.DisplayMetrics
import android.view.WindowManager

class ScreenUtil(context: Context) : ContextWrapper(context) {

    var height: Int? = 0
    var width: Int? = 0

    init {
        val windowManager: WindowManager =
            context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        val metrics = DisplayMetrics()
        display.getMetrics(metrics)

        height = metrics.heightPixels
        width = metrics.widthPixels
    }
}