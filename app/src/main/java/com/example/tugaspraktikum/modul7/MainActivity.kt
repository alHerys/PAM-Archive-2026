package com.example.tugaspraktikum.modul7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.tugaspraktikum.modul7.ui.theme.TugasPraktikumTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val vm = CalculatorScreenViewModel()
        setContent {
            val discount = vm.discount.collectAsState()
            TugasPraktikumTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(Modifier.padding(innerPadding)) {
                        CalculatorScreen(
                            discount = discount.value,
                            onCalculateClick = { vm.compute(it) },
                            onResetClick = { vm.reset() }
                        )
                        UserPanel(
                            user = vm.user.collectAsState().value
                        )
                    }
                }
            }
        }
    }
}