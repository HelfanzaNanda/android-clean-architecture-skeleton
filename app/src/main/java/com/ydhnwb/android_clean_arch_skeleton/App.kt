package com.ydhnwb.android_clean_arch_skeleton

import android.app.Application
import com.ydhnwb.android_clean_arch_skeleton.common.module.*
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(androidModule, apiModule, useCaseModule, repositoryModule, viewModelModule))
        }
    }
}