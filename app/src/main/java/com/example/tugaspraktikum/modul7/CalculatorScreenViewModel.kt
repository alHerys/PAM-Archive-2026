package com.example.tugaspraktikum.modul7

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CalculatorScreenViewModel : ViewModel() {
    private var _discount = MutableStateFlow(0)
    private var _user = MutableStateFlow(User())
    val discount = _discount.asStateFlow()
    val user = _user.asStateFlow()

    fun compute(number: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            Thread.sleep(10_000)
            val percent = if (number > 100_000) 0.2 else 0.1
            _discount.update { (percent * number).toInt() }
            if (number > 100_000) {
                setMemberStatus(true)
                setMemberName("Alvianto Hery Sarborn")
            } else {
                setMemberName("Guest")
                setMemberStatus(false)
            }
        }
    }

    fun reset() {
        setMemberName("Guest")
        setMemberStatus(false)
        _discount.update { 0 }
    }

    private fun setMemberName(name: String) {
        _user.update { it.copy(name = name) }
    }

    private fun setMemberStatus(status: Boolean) {
        _user.update { it.copy(memberStatus = status) }
    }
}

data class User(
    val name: String = "Guest",
    val memberStatus: Boolean = false,
)