package com.ydhnwb.feature_post.usecase

interface ResponseCallback <T> {
    fun onSuccess(data: T)
    fun onError(error: Error)
}

interface ResponseListCallback <T> {
    fun onSuccess(datas: List<T>)
    fun onError(error: Error)
}