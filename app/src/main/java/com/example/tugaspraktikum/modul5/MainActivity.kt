package com.example.tugaspraktikum.modul5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tugaspraktikum.modul5.ui.theme.TugasPraktikumTheme

class MainActivity : ComponentActivity() {
    val gadgets = listOf(
        Gadget(1, "Smartphone", "Perangkat komunikasi genggam"),
        Gadget(2, "Laptop", "Komputer portabel untuk bekerja"),
        Gadget(3, "Tablet", "Perangkat layar sentuh antara hp dan laptop"),
        Gadget(4, "Smartwatch", "Jam tangan pintar pelacak kesehatan"),
        Gadget(5, "Earbuds", "Perangkat audio nirkabel"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TugasPraktikumTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GadgetGrid(Modifier.padding(innerPadding), gadgets)
                }
            }
        }
    }
}

@Composable
fun GadgetItem(
    gadget: Gadget,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = gadget.name, style = MaterialTheme.typography.headlineMedium)
            Text(text = gadget.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun GadgetList(
    modifier: Modifier = Modifier,
    gadgets: List<Gadget>,
) {
    LazyColumn(
        contentPadding = PaddingValues(bottom = 16.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(gadgets) { gadget ->
            GadgetItem(gadget = gadget)
        }
    }
}

@Composable
fun GadgetGrid(
    modifier: Modifier = Modifier,
    gadgets: List<Gadget>,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(bottom = 16.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(gadgets) { gadget ->
            GadgetItem(gadget = gadget)
        }
    }
}