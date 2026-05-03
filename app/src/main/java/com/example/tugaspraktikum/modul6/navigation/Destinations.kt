package com.example.tugaspraktikum.modul6.navigation

import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class Details(
    val locationId: Int,
    val locationName: String,
    val isPremium: Boolean = false,
)

@Serializable
object Profile

@Serializable
object EditUsername