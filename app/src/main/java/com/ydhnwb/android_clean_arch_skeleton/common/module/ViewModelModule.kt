package com.ydhnwb.android_clean_arch_skeleton.common.module

import com.ydhnwb.android_clean_arch_skeleton.presentation.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(get())
    }
}