package com.example.dagger.network

import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.http.GET

interface NewsFeedApi {
    @GET("/v2/top-headlines")
    fun getNewsItems() : Deferred<ResponseBody>
}