package com.ydhnwb.feature_post.domain

import com.google.gson.annotations.SerializedName


//should be mapped from PostResponse to Post
//but i dont have enought time wkww
data class Post (
    var id : Int,
    val userId : Int,
    val title : String,
    val body : String
    )