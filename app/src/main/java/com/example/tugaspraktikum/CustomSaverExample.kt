package com.example.tugaspraktikum

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

data class User(val name: String, val age: Int)

val userSaver = Saver<User, Map<String, Any>>(
    save = { mapOf("name" to it.name, "age" to it.age) },
    restore = { User(name = it["name"] as String, age = it["age"] as Int) },
)

@Composable
fun CustomSaverExample() {
    var user by rememberSaveable(stateSaver = userSaver) {
        mutableStateOf(
            User("Budi", 28)
        )
    }

    Column {
        Text(text = "Name: ${user.name}, Age: ${user.age}")
        Button(
            onClick = {user = user.copy(age = user.age + 1)}
        ) { Text("Increase Age") }
    }
}