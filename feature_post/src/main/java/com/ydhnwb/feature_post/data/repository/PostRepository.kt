package com.ydhnwb.feature_post.data.repository

import com.ydhnwb.feature_post.data.api.ApiPostService
import com.ydhnwb.feature_post.data.dto.response.PostResponse
import com.ydhnwb.feature_post.usecase.ResponseListCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepository (private val postService: ApiPostService){
    fun getPost(listener: ResponseListCallback<PostResponse>){
        postService.getAllPosts().enqueue(object : Callback<List<PostResponse>>{
            override fun onResponse(call: Call<List<PostResponse>>, response: Response<List<PostResponse>>) {
                listener.onSuccess(response.body() ?: listOf()  )
            }
            override fun onFailure(call: Call<List<PostResponse>>, t: Throwable) {
                listener.onError(Error(t.message.toString()))
            }
        })
    }

}