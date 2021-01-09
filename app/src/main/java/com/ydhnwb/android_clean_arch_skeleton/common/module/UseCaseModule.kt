package com.ydhnwb.android_clean_arch_skeleton.common.module

import com.ydhnwb.feature_post.usecase.GetPost
import org.koin.dsl.module

val useCaseModule = module {
    factory {
        GetPost(get(), get())
    }
}

