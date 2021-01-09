package com.ydhnwb.android_clean_arch_skeleton.presentation.main

import com.ydhnwb.feature_post.data.dto.response.PostResponse

interface PostAdapterListener {
    fun onTap(post: PostResponse)
    fun onLongTap(post: PostResponse)
}