package com.example.tugaspraktikum.modul9.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tugaspraktikum.modul9.data.repositories.BookRepository

class BookViewModelFactory(private val repository: BookRepository) :
	ViewModelProvider.NewInstanceFactory() {
	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		try {
			val constructor = modelClass.getDeclaredConstructor(BookRepository::class.java)
			return constructor.newInstance(repository)
		} catch (e: Exception) {
			Log.e("Error", e.message.toString())
		}
		return super.create(modelClass)
	}
}