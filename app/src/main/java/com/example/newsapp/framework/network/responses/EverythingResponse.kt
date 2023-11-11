package com.example.newsapp.framework.network.responses

import com.google.gson.annotations.SerializedName

data class EverythingResponse(
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("totalResults")
    val totalResults : Int? = null,
    @SerializedName("articles")
    val articles: List<ArticleResponse> ?= listOf()
)