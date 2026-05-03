package com.example.tugaspraktikum.modul6

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData(
    val name: String,
    val birthPlace: String,
): Parcelable
