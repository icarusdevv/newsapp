package com.example.newsapp.data.models

import com.example.newsapp.framework.network.responses.ArticleResponse
import com.google.gson.annotations.SerializedName

data class Everything(
    val status: String? = null,
    val totalResults : Int? = null,
    val articles: List<ArticleResponse> ?= null
)
