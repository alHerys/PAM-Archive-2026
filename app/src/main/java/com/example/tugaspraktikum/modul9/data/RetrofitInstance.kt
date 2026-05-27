package com.example.tugaspraktikum.modul9.data

import com.example.tugaspraktikum.modul9.data.services.BookService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
	private const val BASE_URL = ""
	private val retrofit: Retrofit by lazy {
		val sbHttpClient = OkHttpClient().newBuilder()
			.addInterceptor(ApiKeyInterceptor(""))
			.build()

		Retrofit.Builder()
			.baseUrl(BASE_URL)
			.client(sbHttpClient)
			.addConverterFactory(GsonConverterFactory.create())
			.build()
	}

	val bookService: BookService by lazy {
		retrofit.create(BookService::class.java)
	}
}