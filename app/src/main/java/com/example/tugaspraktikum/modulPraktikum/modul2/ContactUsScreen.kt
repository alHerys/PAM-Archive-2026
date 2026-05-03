package com.example.tugaspraktikum.modulPraktikum.modul2

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import com.example.tugaspraktikum.modulPraktikum.modul2.ui.theme.TugasPraktikumTheme

@Composable
fun ContactUsScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Halaman Bantuan", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                // Intent ke WhatsApp
                val url = "https://wa.me/6285340423060"
                val intent = Intent(Intent.ACTION_VIEW, url.toUri())
                context.startActivity(intent)
            }
        ) {
            Text(text = "Hubungi via WhatsApp")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ContectUsScreenPreview() {
    TugasPraktikumTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
           ContactUsScreen(Modifier.padding(innerPadding))
        }
    }
}