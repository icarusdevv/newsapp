package com.example.newsapp.framework.network.responses

import com.google.gson.annotations.SerializedName

data class ArticleResponse(
    @SerializedName("source")
    val source: Map<String, String>,
    @SerializedName("author")
    val author: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val urlToImage: String,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("content")
    val content: String,
)