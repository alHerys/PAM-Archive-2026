package com.example.tugaspraktikum.modul6.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    locationId: Int,
    locationName: String,
    onBack: () -> Unit,
    isPremium: Boolean,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                if (isPremium) Color(0xFFFFD700)
                else Color.Transparent
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Destination Details",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Name: $locationName",
            fontWeight = FontWeight.Bold
        )
        Text(text = "ID: $locationId")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onBack) {
            Text("Go Back")
        }
    }
}