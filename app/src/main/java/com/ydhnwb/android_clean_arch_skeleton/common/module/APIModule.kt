package com.ydhnwb.android_clean_arch_skeleton.common.module

import com.ydhnwb.android_clean_arch_skeleton.common.config.APIClient
import org.koin.dsl.module

val apiModule = module {
    single { APIClient.providePostService() }
}