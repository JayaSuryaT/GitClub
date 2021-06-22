package com.digitalcrafts.gitClub.common

import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide


fun View.show() {
    if (visibility != View.VISIBLE) visibility = View.VISIBLE
}

fun View.hide() {
    if (visibility == View.VISIBLE) visibility = View.GONE
}

fun View.toggleVisibility() {
    when (visibility) {
        View.VISIBLE -> hide()
        View.GONE, View.INVISIBLE -> show()
    }
}

fun View.toggleVisibility(shouldShow: Boolean) {
    if (shouldShow) show() else hide()
}

fun ImageView.loadImage(url: String) {

    if (url.isEmpty()) return

    Glide.with(context)
        .load(url)
        .placeholder(ColorDrawable())
        .into(this)
}