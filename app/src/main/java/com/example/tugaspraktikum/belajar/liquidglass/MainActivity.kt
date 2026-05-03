package com.example.tugaspraktikum.belajar.liquidglass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.tugaspraktikum.belajar.liquidglass.glass.GlassBox
import com.example.tugaspraktikum.belajar.liquidglass.glass.GlassContainer
import com.example.tugaspraktikum.belajar.liquidglass.ui.theme.TugasPraktikumTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TugasPraktikumTheme {
                Scaffold(Modifier.fillMaxSize()) { innerPadding ->
                    GlassCardExample(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

val images = List(20) { "https://picsum.photos/200/${(300..600).random()}" }

@Composable
fun MinimalStaggeredGrid(modifier: Modifier = Modifier) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            start = 8.dp,
            end = 8.dp,
            top = 8.dp,
            // Beri ruang di bawah supaya tombol tidak menutup gambar terakhir
            bottom = 120.dp
        ),
        verticalItemSpacing = 8.dp,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(images) { url ->
            AsyncImage(
                model = url,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.FillWidth
            )
        }
    }
}

@Composable
fun GlassCardExample(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        GlassContainer(
            modifier = Modifier.fillMaxSize(),
            content = {
                MinimalStaggeredGrid()

                Spacer(modifier = Modifier.height(64.dp))
            },
            glassContent = {
                GlassBox(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 32.dp, start = 16.dp, end = 16.dp, top = 16.dp)
                        .size(200f.dp, 60f.dp),
                    shape = RoundedCornerShape(28.dp),
                    contentAlignment = Alignment.Center,

                    blur = 0.5f,
                    scale = 0.25f,
                    tint = Color.White.copy(alpha = 0.75f),
                    elevation = 10.dp,
                    warpEdges = 0.55f,
                    darkness = 0.08f,
                ) {
                    Text(
                        "Glass Button",
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        )
    }
}