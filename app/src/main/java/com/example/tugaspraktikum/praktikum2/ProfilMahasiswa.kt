package com.example.tugaspraktikum.praktikum2

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfilMahasiswa() {
    Row(
        verticalAlignment =
            Alignment.CenterVertically
    ) {
        Box(contentAlignment = Alignment.TopEnd) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Ikon Profil",
                modifier = Modifier.size(48.dp)
            )
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Ikon Profil",
                modifier = Modifier.size(15.dp)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = "Nama: Muhammad Abdurrahman",
                fontWeight = FontWeight.Bold
            )
            Text(text = "NIM: 24515020000000")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfilMahasiswa() {
    ProfilMahasiswa()
}