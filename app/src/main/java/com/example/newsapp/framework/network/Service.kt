package com.example.newsapp.framework.network

import com.example.newsapp.framework.network.responses.EverythingResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import java.util.concurrent.TimeUnit

interface Service{

    @GET("/v2/everything")
    suspend fun getEverything() : Response<EverythingResponse>

    companion object {

        private val interceptor = Interceptor { chain ->
            val newRequest = chain.request().newBuilder()
                .addHeader("X-Api-Key", "39fa1baf7fc34578996c3529a4106ff6")
                .build()
            chain.proceed(newRequest)
        }

        private var retrofitService: Service ?= null
        fun getInstance() : Service? {

            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(interceptor)
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build()

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://newsapi.org/")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(Service::class.java)
            }
            return retrofitService
        }
    }
}