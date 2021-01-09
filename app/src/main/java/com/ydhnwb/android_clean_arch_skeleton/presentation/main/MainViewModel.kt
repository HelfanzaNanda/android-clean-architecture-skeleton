package com.ydhnwb.android_clean_arch_skeleton.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ydhnwb.feature_post.data.dto.response.PostResponse
import com.ydhnwb.feature_post.usecase.GetPost
import com.ydhnwb.feature_post.usecase.ResponseListCallback

class MainViewModel(private val getPostUseCase : GetPost) : ViewModel() {
    private val state = MutableLiveData<MainActivityState>()
    private val posts = MutableLiveData(mutableListOf<PostResponse>())

    private fun setIsLoading(b : Boolean){
        state.value = MainActivityState.IsLoading(b)
    }

    private fun showToast(message: String){
        state.value = MainActivityState.ShowtToast(message)
    }

    fun fetchPost() {
        setIsLoading(true)
        getPostUseCase.fetchAllPost(object: ResponseListCallback<PostResponse>{
            override fun onSuccess(datas: List<PostResponse>) {
                setIsLoading(false)
                posts.postValue(datas.toMutableList())
            }
            override fun onError(error: Error) {
                setIsLoading(false)
                showToast(error.message.toString())
            }
        })
    }

    fun listenToPosts() = posts
    fun listenToState() = state
}

sealed class MainActivityState {
    data class IsLoading(val isLoading : Boolean) : MainActivityState()
    data class ShowtToast(val message : String) : MainActivityState()
}