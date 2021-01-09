package com.ydhnwb.android_clean_arch_skeleton.common.module

import kotlinx.coroutines.asCoroutineDispatcher
import org.koin.dsl.module
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext

val androidModule = module {
    single<CoroutineContext> { Executors.newSingleThreadExecutor().asCoroutineDispatcher() }
}