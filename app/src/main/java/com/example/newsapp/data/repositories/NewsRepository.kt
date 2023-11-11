package com.example.newsapp.data.repositories

import com.example.newsapp.data.models.Everything
import com.example.newsapp.framework.network.Service
import com.example.newsapp.mappers.Mappers.toEverythingModel

class NewsRepository constructor(private val retrofitService: Service) {
    suspend fun getEverything(): Everything {
        val result = retrofitService.getEverything()
        return toEverythingModel(result.body())
    }
}