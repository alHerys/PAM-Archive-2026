package com.example.tugaspraktikum.lazylayout

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugaspraktikum.lazylayout.ui.theme.TugasPraktikumTheme


@Composable
fun LazyGridLayout(modifier: Modifier = Modifier) {
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

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        modifier = modifier
    ) {
        items(menus) { menu ->
            Text(
                text = "${menu.name} - ${menu.price}",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LazyGridLayoutPreview() {
    TugasPraktikumTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            LazyGridLayout(Modifier.padding(innerPadding))
        }
    }
}



