package com.madfinal.tlanguaged0.data.datasource.network.supabase.builder

import okhttp3.Interceptor
import okhttp3.Response

class ApiKey(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("apiKey", apiKey)
            .build()
        return chain.proceed(request)
    }
}