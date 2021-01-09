package com.ydhnwb.feature_post.data.dto.response

import com.google.gson.annotations.SerializedName

data class PostResponse (
    @SerializedName("id")
    var id : Int? = null,

    @SerializedName("userId")
    val userId : Int? = null,

    @SerializedName("title")
    val title : String? = null,

    @SerializedName("body")
    val body : String? = null

)