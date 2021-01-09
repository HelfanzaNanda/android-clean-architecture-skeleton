package com.ydhnwb.feature_post.usecase

import com.ydhnwb.feature_post.data.dto.response.PostResponse
import com.ydhnwb.feature_post.data.repository.PostRepository
import kotlin.coroutines.CoroutineContext

//if you need coroutine context, just use it.
//i will not use it for now
class GetPost (private val postRepository: PostRepository, private val coroutineContext: CoroutineContext){
    fun fetchAllPost(listener: ResponseListCallback<PostResponse>){
        postRepository.getPost(object : ResponseListCallback<PostResponse>{
            override fun onSuccess(datas: List<PostResponse>) = listener.onSuccess(datas)
            override fun onError(error: Error) = listener.onError(error)
        })
    }
}