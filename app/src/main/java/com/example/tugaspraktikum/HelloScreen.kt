package com.example.tugaspraktikum

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun HelloScreen(modifier: Modifier = Modifier) {
    var name by rememberSaveable { mutableStateOf("") }
    HelloContent(
        name = name,
        onNameChange = {name = it}
    )
}

@Composable
fun HelloContent(
    name: String,
    onNameChange: (String) -> Unit
) {
    Column {
        Text(text = "Hello, $name")
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = {Text("Name")}
        )
    }
}