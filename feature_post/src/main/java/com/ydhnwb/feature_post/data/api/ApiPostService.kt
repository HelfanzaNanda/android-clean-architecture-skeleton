package com.ydhnwb.feature_post.data.api

import com.ydhnwb.feature_post.data.dto.response.PostResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiPostService {
    @GET("posts")
    fun getAllPosts () : Call<List<PostResponse>>
}