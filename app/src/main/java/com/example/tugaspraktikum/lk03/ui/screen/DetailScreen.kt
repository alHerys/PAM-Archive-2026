package com.example.tugaspraktikum.lk03.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    itemId: Int,
    onBack: () -> Unit,
) {
    var note by rememberSaveable { mutableStateOf("") }

    Column(modifier.padding(16.dp)) {
        Text(text = "Detail item: $itemId")
        OutlinedTextField(
            value = note,
            onValueChange = { note = it },
            label = { Text("Catatan") }
        )
        Spacer(Modifier.height(12.dp))
        Button(onClick = onBack) {
            Text("Kembali")
        }
    }
}