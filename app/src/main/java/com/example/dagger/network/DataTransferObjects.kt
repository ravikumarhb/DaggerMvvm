package com.example.dagger.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkNewsContainer(@Json(name = "articles") val articles: List<NetworkNews>)


@JsonClass(generateAdapter = true)
data class NetworkNews(
    @Json(name = "title") val title: String? = "",
    @Json(name = "description") val desc: String? = "",
    @Json(name = "url") val url: String = "",
    @Json(name = "publishedAt") val publishedAt: String? = "",
    @Json(name = "urlToImage") val imageUrl: String? = ""
)
