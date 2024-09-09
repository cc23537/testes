package com.example.appcomida

import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public fun getRetrofit(): Retrofit {
    val logging = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)

    val client = UnsafeOkHttpClient.getUnsafeOkHttpClient().newBuilder()
        .addInterceptor(logging)
        .build()

    return Retrofit.Builder()
        .baseUrl("http://10.0.2.2:8081/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
