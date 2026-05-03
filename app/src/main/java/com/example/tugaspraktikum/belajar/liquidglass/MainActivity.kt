package com.example.tugaspraktikum.belajar.liquidglass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.tugaspraktikum.belajar.liquidglass.glass.GlassBox
import com.example.tugaspraktikum.belajar.liquidglass.glass.GlassContainer
import com.example.tugaspraktikum.belajar.liquidglass.ui.theme.TugasPraktikumTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TugasPraktikumTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Hery",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GlassCardExample(modifier: Modifier = Modifier) {
    GlassContainer(
        modifier = modifier.fillMaxSize(),
        content = {
            // Lapis 1: Background (Wajib ada variasi warna/gambar agar efek kaca terlihat)
            AsyncImage(
                model = "https://picsum.photos/1000/1000",
                contentDescription = "Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        },

        // Lapis 2: GlassBox
        glassContent = {
            GlassBox(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth(0.8f) // Mengambil 80% lebar layar
                    .aspectRatio(1.5f), // Proporsi layaknya kartu kredit/ID Card

                // Catatan: Cek file GlassBox.kt kamu untuk melihat parameter pastinya.
                // Biasanya library seperti ini menyediakan parameter opsional seperti:
                // cornerRadius = 16.dp,
                // blurRadius = 15.dp,
                // noiseOpacity = 0.05f
            ) {
                // Lapis 3: Konten di dalam kaca
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Liquid UI",
                        color = Color.White,
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Elegan & Modern",
                        color = Color.White.copy(alpha = 0.8f),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    )
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TugasPraktikumTheme {
        Greeting("Android")
    }
}