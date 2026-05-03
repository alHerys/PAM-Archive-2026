package com.example.tugaspraktikum.modul6.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToDetails: (Int, String) -> Unit,
    isSwitchChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    name: String,
    onValueChange: (String) -> Unit,
    onNavigateToAbout: () -> Unit,
) {
    val locations = listOf("Paris", "Tokyo", "New York", "London")

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Travel Journal",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Premium: ")
            Switch(
                checked = isSwitchChecked,
                onCheckedChange = onCheckedChange
            )
        }
        Spacer(Modifier.height(16.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Name") },
            value = name,
            onValueChange = onValueChange,
        )
        Button(
            onClick = onNavigateToAbout,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("Go to About Page")
        }
        Spacer(Modifier.height(16.dp))
        locations.forEachIndexed { index, name ->
            Button(
                onClick = { onNavigateToDetails(index, name) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Text("Visit $name")
            }
        }
    }
}