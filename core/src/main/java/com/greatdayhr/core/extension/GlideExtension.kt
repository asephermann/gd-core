package com.greatdayhr.core.extension

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.amulyakhare.textdrawable.TextDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.greatdayhr.core.R

fun ImageView.loadImageRectangle(url: Any, name: String, radius: Int) {
    val drawable = TextDrawable.builder()
        .buildRoundRect(
            initialName(name),
            ContextCompat.getColor(context, R.color.colorMango),
            radius
        )
    Glide.with(this.context).asBitmap().load(url).centerCrop().error(drawable)
        .into(object : BitmapImageViewTarget(this) {
            override fun setResource(resource: Bitmap?) {
                val circularBitmapDrawable =
                    RoundedBitmapDrawableFactory.create(context.resources, resource)
                circularBitmapDrawable.cornerRadius = radius.toFloat()
                this@loadImageRectangle.setImageDrawable(circularBitmapDrawable)
            }
        })
}

fun initialName(name: String): String {
    return name
        .split(' ')
        .mapNotNull { it.firstOrNull()?.toString() }
        .reduce { acc, s -> acc + s }
}