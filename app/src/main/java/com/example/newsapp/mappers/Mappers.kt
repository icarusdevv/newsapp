package com.example.newsapp.mappers

import com.example.newsapp.data.models.Everything
import com.example.newsapp.framework.network.responses.EverythingResponse

object Mappers {
    fun toEverythingModel(everythingResponse: EverythingResponse?): Everything{
        return Everything(
            status = everythingResponse?.status,
            totalResults = everythingResponse?.totalResults,
            articles = everythingResponse?.articles
        )
    }
}