package com.example.tugaspraktikum.modul9.data

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor(private val apikey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder().header(
            "apikey", apikey
        ).header("prefer", "return=representation")
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}