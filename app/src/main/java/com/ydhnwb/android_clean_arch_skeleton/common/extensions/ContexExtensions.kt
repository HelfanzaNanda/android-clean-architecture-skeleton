package com.ydhnwb.android_clean_arch_skeleton.common.extensions

import android.content.Context
import android.widget.Toast


fun Context.showToast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}