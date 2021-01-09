package com.ydhnwb.android_clean_arch_skeleton.common.config

import com.ydhnwb.feature_post.data.api.ApiPostService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object APIClient {
    const val ENDPOINT = "https://jsonplaceholder.typicode.com/"
    private var retrofit: Retrofit? = null

    private val client = OkHttpClient.Builder().apply {
        writeTimeout(60, TimeUnit.SECONDS)
        connectTimeout(60, TimeUnit.SECONDS)
        readTimeout(60, TimeUnit.SECONDS)
    }.build()

    private fun getClient() : Retrofit {
        return if(retrofit == null){
            retrofit = Retrofit.Builder().apply {
                baseUrl(ENDPOINT)
                client(client)
                addConverterFactory(GsonConverterFactory.create())
            }.build()
            retrofit!!
        }else{
            retrofit!!
        }
    }

    fun providePostService() = getClient().create(ApiPostService::class.java)
}