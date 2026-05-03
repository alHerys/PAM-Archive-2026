package com.example.tugaspraktikum.lazylayout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Food(val name: String, val price: String)

@Composable
fun SimpleFoodList(modifier: Modifier = Modifier) {
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

    LazyColumn(modifier) {
        items(menus) { menu ->
            Text(
                text = "${menu.name} - ${menu.price}",
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
