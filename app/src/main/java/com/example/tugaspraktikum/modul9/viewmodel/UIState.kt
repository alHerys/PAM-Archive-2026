package com.example.tugaspraktikum.modul9.viewmodel

sealed interface UIState<out T> {
	data class Success<T>(val data: T) : UIState<T>
	data class Error(val message: String): UIState<Nothing>
	object Loading : UIState<Nothing>
}