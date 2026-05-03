package com.example.tugaspraktikum.modul7

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserPanel(
    modifier: Modifier = Modifier,
    user: User,
) {
    Column(modifier.padding(32.dp)) {
        Spacer(Modifier.size(16.dp))
        HorizontalDivider()
        Spacer(Modifier.size(16.dp))
        Text(
            "Membership",
            fontSize = 24.sp,
            fontWeight = FontWeight.Light
        )
        Spacer(Modifier.size(16.dp))
        Text(
            user.name,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            if (user.memberStatus) "Premium Member" else "Non-Member",
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic
        )
    }
}