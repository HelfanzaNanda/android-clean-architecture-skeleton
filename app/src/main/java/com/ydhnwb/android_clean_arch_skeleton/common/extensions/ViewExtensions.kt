package com.ydhnwb.android_clean_arch_skeleton.common.extensions

import android.opengl.Visibility
import android.view.View

fun View.hide(){
    this.visibility = View.GONE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}