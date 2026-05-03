package com.example.tugaspraktikum.modul6.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.tugaspraktikum.modul6.UserData

@Composable
fun EditUsernameScreen(
    modifier: Modifier = Modifier,
    onSave: (UserData) -> Unit,
    onCancel: () -> Unit,
) {
    var tempName by remember { mutableStateOf("") }
    var tempBirthPlace by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = tempName,
            onValueChange = { tempName = it },
            label = { Text("Enter New Username") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = tempBirthPlace,
            onValueChange = { tempBirthPlace = it },
            label = { Text("Enter New Birth Place") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                onSave(
                    UserData(
                        name = tempName,
                        birthPlace = tempBirthPlace
                    )
                )
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Confirm & Return")
        }

        Button(
            onClick = onCancel,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Cancel")
        }
    }
}

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    userProfile: UserData,
    onEditClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = null,
            modifier = Modifier.size(100.dp),
            tint = MaterialTheme.colorScheme.primary
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = "Name: ${userProfile.name}",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Birth Place: ${userProfile.birthPlace}",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(32.dp))

        Button(
            onClick = onEditClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(Icons.Default.Edit, contentDescription = null)
            Spacer(Modifier.width(8.dp))
            Text("Edit User Data")
        }

        Text(
            text = "This screen listens for updates from the editor.",
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(top = 16.dp),
            color = Color.Gray
        )
    }
}