package com.example.tugaspraktikum.modulPraktikum.modul3

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.tugaspraktikum.modulPraktikum.modul3.ui.theme.TugasPraktikumTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TugasPraktikumTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FormScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun FormScreen(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }

    Column(modifier) {
        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
                Log.d("INPUT", "Nama: $name")
            },
            label = { Text("Nama")}
        )

        Button(
            onClick = {Log.d("BUTTON", "Button ditekan oleh $name")}
        ) {
            Text("Submit")
        }
    }
}

@Composable
fun CounterWithBy(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }

    Column(modifier) {
        Text("Counter: $count")

        Button(
            onClick = {count++}
        ) {
            Text("Tambah")
        }
    }
}

@Composable
fun CounterWithoutBy(modifier: Modifier = Modifier) {
    val count = remember { mutableStateOf(0) }

    Column(modifier) {
        Text("Counter: ${count.value}")

        Button(
            onClick = {
                count.value++
            }
        ) {
            Text("Tambah")
        }
    }
}

@Composable
fun CounterTest(modifier: Modifier = Modifier) {
    var count = 0
    Column(modifier) {
        Text("Counter: $count")

        Button(
            onClick = {
                count++
                Log.d("COUNTER", "count = $count")
            }
        ) {
            Text("Tambah")
        }
    }
}

@Composable
fun CounterStateTest(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }
    Column(modifier) {
        Text("Counter: $count")

        Button(
            onClick = {
                count++
                Log.d("COUNTER", "count = $count")
            }
        ) {
            Text("Tambah")
        }
    }
}