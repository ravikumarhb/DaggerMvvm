package com.example.dagger.network

import retrofit2.http.GET

// Interface to get the headlines
interface NewsFeedApi {

    @GET("/v2/top-headlines")
    suspend fun getNewsItems(): NetworkNewsContainer

}