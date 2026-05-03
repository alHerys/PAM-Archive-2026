package com.example.tugaspraktikum.modul7

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorScreen(
    modifier: Modifier = Modifier,
    discount: Int = 0,
    onCalculateClick: (Int) -> Unit,
    onResetClick: () -> Unit,
) {
    var number by rememberSaveable { mutableIntStateOf(0) }

    Column(
        modifier = modifier
            .padding(32.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Transaction Amount",
            fontSize = 24.sp,
            fontWeight = FontWeight.Companion.Light
        )

        Spacer(Modifier.Companion.height(16.dp))

        TextField(
            modifier = Modifier.Companion.fillMaxWidth(),
            value = number.toString(),
            onValueChange = { number = it.toIntOrNull() ?: 0 },
            textStyle = LocalTextStyle.current.copy(fontSize = 28.sp)
        )

        Spacer(Modifier.Companion.size(16.dp))

        Row(Modifier.Companion.align(Alignment.Companion.End)) {
            Button(onClick = { onCalculateClick(number) }) {
                Text(text = "Calculate")
            }

            Spacer(Modifier.Companion.size(8.dp))
            Button(
                onClick = {
                    number = 0
                    onResetClick()
                }
            ) {
                Text("Reset")
            }
        }

        Spacer(Modifier.Companion.size(16.dp))
        HorizontalDivider()
        Spacer(Modifier.Companion.size(16.dp))
        Text("Discount: $discount", fontSize = 24.sp)
    }
}