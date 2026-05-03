package com.example.tugaspraktikum.lazylayout

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun EagerLayout(modifier: Modifier = Modifier) {
    val menus = listOf(
        Food("Kopi Susu", "15k"),
        Food("Roti Bakat", "10k"),
        Food("Pisang Goreng", "8k"),
        Food("Kopi Susu", "15k"),
        Food("Roti Bakar", "10k"),
        Food("Pisang Goreng", "8k"),
        Food("Teh Tarik", "12k"),
        Food("Donat Cokelat", "9k"),
        Food("Nasi Kuning", "18k"),
        Food("Kopi Hitam", "10k"),
        Food("Martabak Telur", "20k"),
        Food("Es Cendol", "7k"),
        Food("Lumpia Sayur", "6k"),
        Food("Perkedel", "5k"),
        Food("Soto Ayam", "16k"),
        Food("Bakso Daging", "14k"),
        Food("Mie Goreng", "13k"),
        Food("Nasi Goreng", "15k"),
        Food("Tahu Goreng", "8k"),
        Food("Tempe Mendoan", "7k"),
        Food("Klepon", "6k"),
    )

    var index = 1

    Column(
        modifier.verticalScroll(rememberScrollState())
    ) {
        menus.forEach { menu ->
            Text("$index. ${menu.name} - ${menu.price}", Modifier.padding(8.dp))
            Log.d("MENU", "Menu $index")
            index++
        }
    }
}