package com.example.dagger.network

import retrofit2.http.GET

interface NewsFeedApi {

    @GET("/v2/top-headlines")
    suspend fun getNewsItems(): NetworkNewsContainer

    @GET("/v2")
    suspend fun getFail()
}