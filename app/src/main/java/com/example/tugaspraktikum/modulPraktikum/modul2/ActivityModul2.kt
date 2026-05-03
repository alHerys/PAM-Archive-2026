package com.example.tugaspraktikum.modulPraktikum.modul2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.tugaspraktikum.modulPraktikum.modul2.ui.theme.TugasPraktikumTheme

class ActivityModul2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d("LIFECYCLE_TEST", "onCreate dipanggil")
        setContent {
            TugasPraktikumTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ContactUsScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("LIFECYCLE_TEST", "onStart dipanggil")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFECYCLE_TEST", "onResume dipanggil")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LIFECYCLE_TEST", "onPause dipanggil")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LIFECYCLE_TEST", "onStop dipanggil")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFECYCLE_TEST", "onDestroy dipanggil")
    }
}