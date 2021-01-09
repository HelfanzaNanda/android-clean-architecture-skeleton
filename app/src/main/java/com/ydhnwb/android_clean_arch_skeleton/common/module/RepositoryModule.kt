package com.ydhnwb.android_clean_arch_skeleton.common.module

import com.ydhnwb.feature_post.data.repository.PostRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory {
        PostRepository(get())
    }
}